package com.zest.web.admin.controller.tutor;

import com.zest.web.client.model.client.ClientVO;
import com.zest.web.client.model.tutor.TuTorVO;
import com.zest.web.client.model.tutor.Tutor_PropVO;
import com.zest.web.client.service.client.ClientSearchService;
import com.zest.web.client.service.tutor.TutorImageUpdateService;
import com.zest.web.client.service.tutor.TutorInsertService;
import com.zest.web.client.service.tutor.Tutor_PropSearchService;
import com.zest.web.client.service.tutor.Tutor_PropUpdateService;
import com.zest.web.util.Paging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TutorManagePageController {

	@Autowired
	private Tutor_PropSearchService tutor_propSearchService;

	@Autowired
	private ClientSearchService clientSearchService;

	@Autowired
	private Tutor_PropUpdateService tutor_PropUpdateService;

	@Autowired
	private TutorInsertService tutorInsertService;

	@Autowired
	private TutorImageUpdateService tutorImageUpdateService;

	@Autowired
	private Paging paging;

	// 튜터신청관리페이지
	@RequestMapping(value = "/admin/tutorManager/prop")
	public ModelAndView viewPropPage(ModelAndView modelAndView, @RequestParam(required = false) String pageNum,
			@RequestParam(required = false) String search_type, @RequestParam(required = false) String search_text) {

		if (pageNum == null || pageNum == "")
			pageNum = "1";

		// 현재페이지
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 7; // 페이지당 보여줄 글
		int pageBlockSize = 5; // 페이지 블록의 사이즈

		// 검색설정확인
		if (search_type == null)
			search_type = "";
		if (search_text == null)
			search_text = "";

		// service로 넘겨줄 map객체 생성
		Map<String, Object> map = new HashMap<>();
		map.put("search_type", search_type);
		map.put("search_text", search_text);

		// 검색설정확인
		if (search_type == null)
			search_type = "";
		if (search_text == null)
			search_text = "";

		int count = tutor_propSearchService.getTutor_propCount(map);

		// 페이징처리 설정
		paging.setPaging(pageSize, pageBlockSize, count, currentPage);
		// 페이지에서 가져올 글 설정
		map.put("startRow", paging.getWriting_Start());
		map.put("endRow", paging.getWriting_End());
		// 페이지에표시할 글 받아오기

		List<Tutor_PropVO> list = tutor_propSearchService.getListTutor_prop(map);

		if (list.isEmpty()) {
			System.out.println("aaaaa");
		}
		for (Tutor_PropVO vo : list) {
			// 날짜 변환
			vo.setFormat_tpd(vo.getTp_prop_date().toString().substring(0, 19));
		}

		// View에서 사용할 녀석들 넣기
		Map<String, Object> model = new HashMap<>();

		model.put("count", count);
		model.put("tutorPropList", list);
		model.put("pageNum", pageNum);
		model.put("search_text", search_text);
		model.put("search_type", search_type);
		model.put("bp", paging);
		model.put("display", "none");
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("admin/tutorManager/tutorPropPage");
		return modelAndView;
	}

	// 튜터 상세 페이지
	@RequestMapping(value = "/admin/tutorManager/prop/{num}")
	public ModelAndView viewDetailPropPage(ModelAndView modelAndView, @PathVariable String num,
			@RequestParam(required = false) String pageNum, @RequestParam(required = false) String search_type,
			@RequestParam(required = false) String search_text, HttpServletRequest request) {

		if (pageNum == null || pageNum == "")
			pageNum = "1";
		// 현재페이지
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 7; // 페이지당 보여줄 글
		int pageBlockSize = 5; // 페이지 블록의 사이즈

		// 검색설정확인
		if (search_type == null)
			search_type = "";
		if (search_text == null)
			search_text = "";

		// service로 넘겨줄 map객체 생성
		Map<String, Object> map = new HashMap<>();
		map.put("search_type", search_type);
		map.put("search_text", search_text);

		// 검색설정확인
		if (search_type == null)
			search_type = "";
		if (search_text == null)
			search_text = "";

		int count = tutor_propSearchService.getTutor_propCount(map);

		// 페이징처리 설정
		paging.setPaging(pageSize, pageBlockSize, count, currentPage);
		// 페이지에서 가져올 글 설정
		map.put("startRow", paging.getWriting_Start());
		map.put("endRow", paging.getWriting_End());
		// 페이지에표시할 글 받아오기

		List<Tutor_PropVO> list = tutor_propSearchService.getListTutor_prop(map);

		if (list.isEmpty()) {
			System.out.println("aaaaa");
		}
		for (Tutor_PropVO vo : list) {
			// 날짜 변환
			vo.setFormat_tpd(vo.getTp_prop_date().toString().substring(0, 19));
		}
		// 상세페이지 실질 내용

		Integer number = Integer.parseInt(num); // 넘겨받은 번호 파싱
		Tutor_PropVO tempVo = tutor_propSearchService.getTutor_propNumber(number);
		System.out.println(tempVo.toString());
		System.out.println();

		// View에서 사용할 녀석들 넣기
		Map<String, Object> model = new HashMap<>();

		File dirFile = new File(tempVo.getTp_image_path());
		File[] files = dirFile.listFiles();
		for (File tempFile : files) {
			if (tempFile.isFile()) {
				String tempPath = tempFile.getParent();
				String tempFileName = tempFile.getName();
				int lastDot = tempFileName.lastIndexOf('.');

				if (tempFileName.substring(0, lastDot).equals("profile")) {
					model.put("profile", "/LocalImage/tutorProp/" + num + "/" + tempFileName);
				}
				if (tempFileName.substring(0, lastDot).equals("certification")) {
					model.put("certification", "/LocalImage/tutorProp/" + num + "/" + tempFileName);
				}
				for (int i = 0; i < files.length; i++) {
					if (tempFileName.substring(0, lastDot).equals("add" + i)) {
						model.put("add" + i, "/LocalImage/tutorProp/" + num + "/" + tempFileName);
					}
				}
			}
		}
		model.put("count", count);
		model.put("tutorPropList", list);
		model.put("pageNum", pageNum);
		model.put("search_text", search_text);
		model.put("search_type", search_type);
		model.put("bp", paging);
		model.put("tempVO", tempVo);
		// 디스플레이처리
		model.put("display", "block");
		modelAndView.addAllObjects(model);

		modelAndView.setViewName("admin/tutorManager/tutorPropPage");
		return modelAndView;
	}

	// 승인여부결정
	@RequestMapping(value = "/admin/tutorManager/propSubmit", method = RequestMethod.POST)
	@ResponseBody
	public String submitTutorPorp(@RequestBody Map<String, Object> modelMap) {

		// email를 가지고 튜터를 신청한 해당 클래스를 가져온다
		ClientVO tempClientVO = new ClientVO();
		tempClientVO.setCl_email((String) modelMap.get("email"));
		tempClientVO = clientSearchService.getClient(tempClientVO);
		
		//승인요청 거부 처리 
		if ((modelMap.get("denyCode")) != null) {
			int code = Integer.valueOf((String)modelMap.get("denyCode"));
			System.out.println(code);
			
			Tutor_PropVO tempTutor_PropVO = new Tutor_PropVO();
			tempTutor_PropVO.setTp_no(Integer.valueOf((String) modelMap.get("no")));
			//승인 실패 이유를 메세지 항목에 저장
			tempTutor_PropVO.setTp_message(String.valueOf(code));
			//승인 상태 코드를 상태 코드에 저장
			tempTutor_PropVO.setTp_status(new Integer(1));
			//실패 이유 DB에 어..업데이트
			tutor_PropUpdateService.updateTutor_prop(tempTutor_PropVO);
			return null;
		
		} else {

			// 요청처리된 튜터를 승인한다.
			Tutor_PropVO tempTutor_PropVO = new Tutor_PropVO();
			//승인요청을하는 튜터신청테이블의 프라이머리키를 VO 객체에 저장
			tempTutor_PropVO.setTp_no(Integer.valueOf((String) modelMap.get("no")));
			//업데이트를 할 상태코드 저장
			tempTutor_PropVO.setTp_status(new Integer(1));
			
			//튜터 테이블의 정보를 넘겨줄 튜터신청 객체 생성
			Tutor_PropVO temp = new Tutor_PropVO();
			
			//튜터신청테이블 정보를 저장
			temp = tutor_propSearchService.getTutor_propNumber(Integer.valueOf((String) modelMap.get("no")));
			
			//위에서 요청처리된 튜터 정보를 업데이트  = 상태코드 업데이트
			tutor_PropUpdateService.updateTutor_prop(tempTutor_PropVO);

			// 승인 튜터 업데이트 하기
			TuTorVO torVO = tutorInsertService.tutorInsert(temp, tempClientVO);			
			// 튜터 이미지경로 업데이트
			System.out.println(torVO.getTt_no());
			
			//주소값줌
			tutorImageUpdateService.updateImage(torVO);

			return "test";
		}

	}

	public void setTutor_propSearchService(Tutor_PropSearchService tutor_propSearchService) {
		this.tutor_propSearchService = tutor_propSearchService;
	}

	public void setClientSearchService(ClientSearchService clientSearchService) {
		this.clientSearchService = clientSearchService;
	}

	public void setTutor_PropUpdateService(Tutor_PropUpdateService tutor_PropUpdateService) {
		this.tutor_PropUpdateService = tutor_PropUpdateService;
	}

	public void setTutorInsertService(TutorInsertService tutorInsertService) {
		this.tutorInsertService = tutorInsertService;
	}

}
