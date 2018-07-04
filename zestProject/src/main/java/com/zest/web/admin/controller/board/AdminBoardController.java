package com.zest.web.admin.controller.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zest.web.admin.model.AdminVO;
import com.zest.web.admin.model.BoardVO;
import com.zest.web.admin.service.board.BoardService;
import com.zest.web.admin.service.board.CommentService;
import com.zest.web.util.Paging;
@Controller
@SessionAttributes("board")
public class AdminBoardController {

	
	private static final Logger logger = LoggerFactory.getLogger(AdminBoardController.class);
	
	@Autowired
	private CommentService commentservice;
	
	@Autowired
	private BoardService boardservice;
 

	@Autowired
	private Paging paging;
	// 게시판 리스트 불러오기
	@SuppressWarnings("unused")
	@RequestMapping(value = "/admin/adminBoard", method = RequestMethod.GET)
	public String boardList(BoardVO vo, Model model, HttpServletRequest request,
			@RequestParam(required = false) String pageNum, @RequestParam(required = false) String searchCondition,
			@RequestParam(required = false) String searchKeyword) throws Exception {
		logger.info("...ing");
		
		//게시물 검색하기
		if (searchCondition == null && searchCondition == "") {
			searchCondition = "";
		}
		if (searchKeyword == null && searchKeyword == "") {
			searchKeyword = "";
		}
		
		System.out.println(searchKeyword+searchCondition);

		if (pageNum == null || pageNum == "")
			pageNum = "1";

		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 5; // 게시판에서 게시글의 개수
		int pageBlockSize = 5; // 게시판 개수의 그룹

		Map<String, Object> countMap = new HashMap<>();
		countMap.put("keyword", searchKeyword);
		countMap.put("type",searchCondition);
		
		int count = boardservice.getBoardListCount(countMap);
		
		System.out.println("count : "+ count);
		
		paging.setPaging(pageSize, pageBlockSize, count, currentPage);

		Map<String, Object> map = new HashMap<>();

		map.put("startRow", paging.getWriting_Start());
		map.put("endRow", paging.getWriting_End());
		map.put("type",searchCondition);
		map.put("keyword", searchKeyword);
		
		
		List<BoardVO> memberList = boardservice.listAll(map);

		model.addAttribute("boardList", memberList);
		model.addAttribute("paging", paging);
		model.addAttribute("type",searchCondition);
		model.addAttribute("keyword", searchKeyword);
		return "admin/adminBoard/adminBoardList";
	}
	

	//게시판 작성폼 jsp 가져오기
	@RequestMapping(value="/admin/insert",method=RequestMethod.GET )
	public String viewInsertBoardPage()  {
		return "admin/adminBoard/adminInsertBoard";
	}
	
	//게시판 작성하기
	@RequestMapping(value="/admin/insert",method=RequestMethod.POST )
	public String insertBoard(BoardVO vo , HttpSession session) throws IOException  {
		
		//ip 가져오기
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest(); 
		vo.setAdd_ip(req.getRemoteAddr());
		AdminVO adminVO = (AdminVO) session.getAttribute("admin");
		vo.setAdd_id(adminVO.getId());
		boardservice.insert(vo);
		return "redirect:/admin/adminBoard";
	}
	// 게시판 상세보기
	@RequestMapping("/admin/getBoard")
	public String getBoard(HttpServletRequest request, BoardVO vo, Model model , HttpSession session) {
		logger.info("...ing");
		// 댓글을 작성하고 왔을때
		if(request.getAttribute("add_no") != null) {
			model.addAttribute("board", boardservice.get((Integer)request.getAttribute("add_no")));
			model.addAttribute("commentlist", commentservice.commentList((Integer)request.getAttribute("add_no")));
			
			
		// adminBoardList 에서 클릭해서 왔을때 
		}else {
			model.addAttribute("board", boardservice.get(vo.getAdd_no()));
			model.addAttribute("admin", session.getAttribute("id"));
			model.addAttribute("commentlist", commentservice.commentList(vo.getAdd_no()));
			boardservice.updateBoardRead(vo);
			
		}
		return "admin/adminBoard/adminGetBoard"; 
	}

	// 수정게시판 이동
	@RequestMapping("/admin/boardupdateform")
	public String updateBoard(BoardVO vo, Model model) {
		logger.info("...ing");
		return "admin/adminBoard/adminUpdateBoard"; // 
	}
	//게시판 삭제
	@RequestMapping("/admin/delete")
	public String delete(Integer add_no) {
		//게시판 댓글 전체 지움
		commentservice.commentDeleteAll(add_no);
		//게시판 지움
		boardservice.boardDelete(add_no);

		return "redirect:/admin/adminBoard";
		

	}
	//수정 완료 
	@RequestMapping(value = "/admin/boardupdatecomplete" ,method = RequestMethod.POST)
	public String boardUpdate(BoardVO vo ) {
		logger.info("...ing");
		
		boardservice.update(vo);
		
		
		return "redirect:/admin/adminBoard"; // 
	}
	
	
/*	게시글 검색! ! Search board
  	이거 왜만든지 모르겠음
	@RequestMapping(value ="/boardGetCheck" )
	public String boardSearchController(BoardVO vo , Model model) {
		List<BoardVO> list =  boardservice.getBoardList(vo);
		model.addAttribute("searchList" , list);
		
		return "admin/adminBoard/adminUpdateBoard";
	}
*/
}
