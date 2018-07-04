package com.zest.web.client.controller.common;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.client.ClientVO;
import com.zest.web.client.model.tutor.Tutor_PropVO;
import com.zest.web.client.service.tutor.Tutor_PropInsertService;
import com.zest.web.client.service.tutor.Tutor_PropSearchService;
import com.zest.web.client.service.tutor.Tutor_PropUpdateService;

//튜터 등록 페이지
@Controller
public class TutorRegiPageController {

	private Logger logger = LoggerFactory.getLogger(TutorRegiPageController.class);

	@Autowired
	private Tutor_PropInsertService insertService;
	@Autowired
	private Tutor_PropSearchService searchService;
	@Autowired
	private Tutor_PropUpdateService updateService;

	@RequestMapping(value = "/tutorRegiPage")
	public ModelAndView viewTutorRegiPage(ModelAndView modelAndView) {
		logger.info("...ing");

		modelAndView.setViewName("common/tutorRegistPage");
		return modelAndView;
	}

	// 이미지 파일 업로드관련
	@RequestMapping(value = "/tutorRegiPage", method = RequestMethod.POST)
	public ModelAndView insertTutorRegiPage(Tutor_PropVO vo, MultipartFile file_profile,
			MultipartFile file_certification, HttpSession session,ModelAndView modelAndView) throws IllegalStateException, IOException {

		// 클라이언트 객체로부터 정보 가져오기
		if (session.getAttribute("client") != null) {
			ClientVO clientVO = (ClientVO) session.getAttribute("client");
			vo.setTp_email(clientVO.getCl_email());
			// insert
			insertService.insertTutor_prop(vo);
			// 방금 insert한 객체 가져오기
			Tutor_PropVO insertVo = searchService.getTutor_prop(vo);
				
			//insert 한 튜터의 넘버 가져오기 
			String tutorProp_no = String.valueOf(insertVo.getTp_no()); 
			// 프로필사진
			String fileNameProfile = file_profile.getOriginalFilename();
			// 증명사진
			String fileNameCertification = file_certification.getOriginalFilename();

			// 업로드 파일 로컬에 저장하기
			// 폴더 만들기
			File tutorPropFolder = new File("c:/zest/tutorProp/"+tutorProp_no);
			if (!tutorPropFolder.exists()) {
				// 해당 폴더가 없으면 생성
				tutorPropFolder.mkdirs();
			}
			file_profile.transferTo(new File("c:/zest/tutorProp/"+tutorProp_no+"/profile." + getFileExtension(fileNameProfile)));
			file_certification.transferTo(
					new File("c:/zest/tutorProp/"+tutorProp_no+"/certification." + getFileExtension(fileNameCertification)));

			// 추가된 사진 처리하고 저장하기
			for (int i = 0; i < vo.getFile_add().length; i++) {
				MultipartFile file = vo.getFile_add()[i];
				if(!file.isEmpty()) {
				String tutorAddFileName = file.getOriginalFilename();
				file.transferTo(new File("c:/zest/tutorProp/"+tutorProp_no+"/add" + i +"."+ getFileExtension(tutorAddFileName)));
				}
			}
			
			//사진 경로 업데이트 해주기
			String imagePath = "c:/zest/tutorProp/"+tutorProp_no+"/";
			insertVo.setTp_image_path(imagePath);
			updateService.updateTutor_prop(insertVo);
			
		}
		modelAndView.setViewName("common/myPage");
		return modelAndView;
	}

	// 파일확장자 구하는 메서드
	String getFileExtension(String data) {
		int pos = data.lastIndexOf(".");
		String ext = data.substring(pos + 1);
		return ext;
	}

	public Tutor_PropInsertService getInsertService() {
		return insertService;
	}

	public void setInsertService(Tutor_PropInsertService insertService) {
		this.insertService = insertService;
	}

	public Tutor_PropSearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(Tutor_PropSearchService searchService) {
		this.searchService = searchService;
	}
	
	

}
