package com.zest.web.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.notice.model.NoticeVO;
import com.zest.web.notice.service.NoticeService;
import com.zest.web.util.Paging;

// 공지사항 컨트롤러
@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	@Autowired
	Paging paging;

	// 관리자 페이지 공지사항 화면
	@RequestMapping(value = "admin/notice/noticeList")
	public ModelAndView adminList(ModelAndView modelAndView, @RequestParam(required = false) String pageNum,
			@RequestParam(required = false) String search_type, @RequestParam(required = false) String search_text)
			throws Exception {
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

		int count = noticeService.getCount(map);
		// 페이징처리 설정
		paging.setPaging(pageSize, pageBlockSize, count, currentPage);
		// 페이지에서 가져올 글 설정
		map.put("startRow", paging.getWriting_Start());
		map.put("endRow", paging.getWriting_End());

		List<NoticeVO> list = noticeService.listAll(map);

		System.out.println("받아온 공지사항 게시글 리스트" + list);

		Map<String, Object> model = new HashMap<>();
		model.put("count", count);
		model.put("list", list);
		model.put("pageNum", pageNum);
		model.put("search_text", search_text);
		model.put("search_type", search_type);
		model.put("bp", paging);
		modelAndView.setViewName("notice/adminNoticeList");
		modelAndView.addAllObjects(model); // 데이터를 저장

		return modelAndView;
	}

	// 일반 유저 리스트 화면
	@RequestMapping(value = "notice/list")
	public ModelAndView list(ModelAndView modelAndView, @RequestParam(required = false) String pageNum,
			@RequestParam(required = false) String search_type, @RequestParam(required = false) String search_text)
			throws Exception {
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

		int count = noticeService.getCount(map);
		// 페이징처리 설정
		paging.setPaging(pageSize, pageBlockSize, count, currentPage);
		// 페이지에서 가져올 글 설정
		map.put("startRow", paging.getWriting_Start());
		map.put("endRow", paging.getWriting_End());

		List<NoticeVO> list = noticeService.listAll(map);

		System.out.println("받아온 공지사항 게시글 리스트" + list);

		Map<String, Object> model = new HashMap<>();
		model.put("count", count);
		model.put("list", list);
		model.put("pageNum", pageNum);
		model.put("search_text", search_text);
		model.put("search_type", search_type);
		model.put("bp", paging);
		modelAndView.setViewName("notice/noticeList");
		modelAndView.addAllObjects(model); // 데이터를 저장

		return modelAndView;
	}

	// 작성 화면
	@RequestMapping(value = "notice/write")
	public ModelAndView write() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("notice/noticeWrite");
		return modelAndView; // write.jsp로 이동
	}

	// 게시글 작성처리
	@RequestMapping(value = "notice/insert", method = RequestMethod.POST)
	public ModelAndView insert(NoticeVO vo) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		noticeService.create(vo);
		modelAndView.setViewName("redirect:/admin/notice/noticeList");

		return modelAndView; // write.jsp로 이동
	}

	// 게시글 상세내용 조회
	@RequestMapping(value = "notice/detail")
	public ModelAndView view(@RequestParam int notice_no) throws Exception {
		// 조회수 증가 처리
		noticeService.increaseViewcnt(notice_no);
		ModelAndView mav = new ModelAndView();
		// 뷰의 이름
		mav.setViewName("notice/noticeDetail");
		mav.addObject("dto", noticeService.read(notice_no));
		return mav;
	}

	// 게시글 수정 페이지로 이동
	@RequestMapping(value = "admin/notice/modify")
	public ModelAndView modify(@RequestParam int notice_no) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		// 뷰의 이름
		mav.setViewName("notice/noticeModify");
		mav.addObject("dto", noticeService.read(notice_no));
		return mav;
	}

	// 게시글 수정
	@RequestMapping(value = "notice/update", method = RequestMethod.POST)
	public String update(NoticeVO vo) throws Exception {
		noticeService.update(vo);
		return "redirect:/admin/notice/noticeList";
	}

	// 05. 게시글 삭제
	@RequestMapping("notice/delete")
	public String delete(@RequestParam int notice_no) throws Exception {
		noticeService.delete(notice_no);
		return "redirect:/admin/notice/noticeList";
	}
}
