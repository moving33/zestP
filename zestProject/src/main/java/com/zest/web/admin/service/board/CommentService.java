package com.zest.web.admin.service.board;

import java.util.List;

import com.zest.web.admin.model.CommentVO;

public interface CommentService {

	
	public void commentInsert(CommentVO vo) ;
	
	public void commentUpdate(CommentVO vo) ;
	
	public void commentDelete(Integer ad_reple_no) ;
	// ��� ��������
	public List<CommentVO> commentList(Integer ad_reple_addno) ;
	// �Խñۿ� �ش��ϴ� ��� ��� �����
	public void commentDeleteAll(Integer ad_reple_addno);	


}
