package com.zest.web.client.service.tutor;

import com.zest.web.client.dao.tutor.TutorDAO;
import com.zest.web.client.model.client.ClientVO;
import com.zest.web.client.model.tutor.TuTorVO;
import com.zest.web.client.model.tutor.Tutor_PropVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class TutorInsertServiceImpl implements TutorInsertService {

	@Autowired
	private TutorDAO tutorDAO;

	@Override
	public TuTorVO tutorInsert(Tutor_PropVO tutor_propVO, ClientVO clientVO) {
		// 튜터에 필요한 내용 추출하기
		TuTorVO tuTorVO = settingTutor(tutor_propVO, clientVO);
		// tutor 넣기
		tuTorVO = tutorDAO.insertTutor(tuTorVO);
		String imagePath = "c:/zest/tutor/" + tuTorVO.getTt_no(); //생성할 폴더
		String orginFilePath = tutor_propVO.getTp_image_path(); //가져올 폴더 
		
		//파일 을 옮기고 삭제 
		moveAndDeleteFile(imagePath,orginFilePath);
		tuTorVO.setTt_im_path(imagePath);
		return tuTorVO;
	}
	
	//이미지 파일 옮기고 삭제하는 메서드
	public void moveAndDeleteFile(String imagePath,String orginFilePath) {
		File tutorFolder = new File(imagePath);
		if (!tutorFolder.exists()) {
			tutorFolder.mkdirs();
		}

		// 프로필 이미지 사진 옮기고 삭제하기
		List<File> dirList = getDirFileList(orginFilePath);
		for (File file : dirList) {
			String tempFileName = file.getName();
			int lastDot = tempFileName.lastIndexOf('.');
			if (tempFileName.substring(0, lastDot).equals("profile")) {
				fileCopy(orginFilePath + tempFileName, imagePath + "/" + tempFileName);
				file.delete();
			}
			file.delete();
		}
		fileDelete(orginFilePath);
	}

	// 디렉토리의 파일 리스트를 읽는 메소드
	public List<File> getDirFileList(String dirPath) {
		List<File> dirFileList = null;
		File dir = new File(dirPath);
		if (dir.exists()) {
			File[] files = dir.listFiles();
			// 파일 배열을 리스트로 변환
			dirFileList = Arrays.asList(files);
		}
		return dirFileList;
	}

	// 파일을 복사하는 메소드
	public void fileCopy(String inFileName, String outFileName) {
		try {
			FileInputStream fis = new FileInputStream(inFileName);
			FileOutputStream fos = new FileOutputStream(outFileName);

			int data = 0;
			byte[] readBytes = new byte[100];
			while ((data = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, data);
			}

			fos.flush();
			fos.close();
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 파일을 삭제하기
	public void fileDelete(String deleteFileName) {
		File a = new File(deleteFileName);
		a.delete();
	}

	// 기본 튜터 데이터 넣어주는 메서드
	public TuTorVO settingTutor(Tutor_PropVO tutor_propVO, ClientVO clientVO) {
		// 튜터에 필요한 내용 추출하기
		TuTorVO tuTorVO = new TuTorVO();
		tuTorVO.setTt_email(clientVO.getCl_email());
		tuTorVO.setTt_name(clientVO.getCl_name());
		tuTorVO.setTt_pass(clientVO.getCl_pass());
		tuTorVO.setTt_hp(tutor_propVO.getTp_hp());
		tuTorVO.setTt_nn(tutor_propVO.getTp_nn());
		tuTorVO.setTt_categroy_id(tutor_propVO.getTp_category_id());
		// tutor 넣기
		return tuTorVO;
	}

	public void setTutorDAO(TutorDAO tutorDAO) {
		this.tutorDAO = tutorDAO;
	}
}
