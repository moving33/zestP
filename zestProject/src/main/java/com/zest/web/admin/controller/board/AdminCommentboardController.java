package com.zest.web.admin.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zest.web.admin.model.AdminVO;
import com.zest.web.admin.model.CommentVO;
import com.zest.web.admin.service.board.CommentService;
@Controller
public class AdminCommentboardController {

	
	@Autowired
	private CommentService commentservice;
	// 댓글 입력 Comment Insert
	@RequestMapping(value ="/admin/boardcommentinsert" , method = RequestMethod.POST)
	public String commentInsert(HttpServletRequest request, CommentVO vo ,HttpSession session, String ad_reple_addno) {
		
		
		AdminVO adminVO = (AdminVO) session.getAttribute("admin");
		vo.setAd_reple_id(adminVO.getId()); 
		
		commentservice.commentInsert(vo);
		
		System.out.println(vo + "aaaaaaaaaaa");
		request.setAttribute("add_no", vo.getAd_reple_addno());

		return "redirect:/admin/getBoard?add_no=" + ad_reple_addno;
	}
	// 댓글 지움 Comment Delete
	@RequestMapping(value="/admin/commentdelete")
	public String commentDelete(Integer ad_reple_no, String add_no) {
		System.out.println(ad_reple_no + " " + add_no);
		commentservice.commentDelete(ad_reple_no);
		System.out.println("add_no : " + add_no);
		return "redirect:/admin/getBoard?add_no=" + add_no;
	}
	
}
