package com.zest.web.client.controller.common;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.client.ClientVO;
import com.zest.web.client.service.client.ClientModifyService;
import com.zest.web.client.service.client.ClientSearchService;


//회원정보수정 페이지
@Controller
public class ClientModifyPageController {

	private Logger logger = LoggerFactory.getLogger(ClientModifyPageController.class);

	@Autowired
	private ClientSearchService clientSearchService;
	@Autowired
	private ClientModifyService clientModifyService;


	@RequestMapping(value = "/clientModifyPage")
	public ModelAndView clientModifyPage(ModelAndView modelAndView) {
		logger.info("...ing");

		modelAndView.setViewName("common/clientModifyPage");
		return modelAndView;
	}

	// 이미지 파일 업로드관련
	@RequestMapping(value = "/clientModify", method = RequestMethod.POST)
	public ModelAndView clientModify(ClientVO vo, MultipartFile file_profile, HttpSession session, ModelAndView modelAndView) throws IllegalStateException, IOException {
		logger.info("2222222222222222222");
		//해당 client가 있는 지 확인
		if(session.getAttribute("client") != null) {
			ClientVO clientVO = (ClientVO) session.getAttribute("client");
			logger.info("3333333333333333333");
			logger.info("사용자 세션 clientVO" + clientVO);
			
			
			//사용자의 넘버 가져오기 
			String cl_no = String.valueOf(clientVO.getCl_no()); 
			logger.info("사용자 넘버" + cl_no);
			
			// 프로필사진
			String fileNameProfile = file_profile.getOriginalFilename();
			logger.info("프로필사진" + fileNameProfile);

			
			// 업로드 파일 로컬에 저장하기
			// 폴더 만들기
			File clientPropFolder = new File("c:/zest/client/"+cl_no);
			if (!clientPropFolder.exists()) {
			// 해당 폴더가 없으면 생성
				clientPropFolder.mkdirs();
			}
			file_profile.transferTo(new File("c:/zest/client/"+cl_no+"/profile." + getFileExtension(fileNameProfile)));
			
			String imagePath = "LocalImage/client/"+cl_no+"/profile." + getFileExtension(fileNameProfile);
			
			/*//추가된 사진 처리하고 저장하기
			MultipartFile file = vo.getFile_profile();
			if(!file.isEmpty()) {
				String clientAddFileName = file.getOriginalFilename();
				file.transferTo(new File("c:/zest/client/"+cl_no+"/add"+"."+getFileExtension(clientAddFileName)));
			}*/
			
			//사진 경로 업데이트 해주기
			/*String imagePath = "c:/zest/client/"+cl_no+"/";*/
			clientVO.setCl_im_path(imagePath);
			clientVO.setCl_nn(vo.getCl_nn());
			clientVO.setCl_hp(vo.getCl_hp());
			clientModifyService.modifyClient(clientVO);
			
			
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

		
		
		public ClientSearchService getClientSearchService() {
			return clientSearchService;
		}

		public void setClientSearchService(ClientSearchService clientSearchService) {
			this.clientSearchService = clientSearchService;
		}

		public ClientModifyService getClientModifyService() {
			return clientModifyService;
		}

		public void setClientModifyService(ClientModifyService clientModifyService) {
			this.clientModifyService = clientModifyService;
		}
	
		
		
	

}
