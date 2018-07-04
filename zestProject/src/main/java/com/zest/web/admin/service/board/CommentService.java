package com.zest.web.admin.service.board;

import java.util.List;

import com.zest.web.admin.model.CommentVO;

public interface CommentService {

	
	public void commentInsert(CommentVO vo) ;
	
	public void commentUpdate(CommentVO vo) ;
	
	public void commentDelete(Integer ad_reple_no) ;
	// 댓글 가져오기
	public List<CommentVO> commentList(Integer ad_reple_addno) ;
	// 게시글에 해당하는 댓글 모두 지우기
	public void commentDeleteAll(Integer ad_reple_addno);	


}
