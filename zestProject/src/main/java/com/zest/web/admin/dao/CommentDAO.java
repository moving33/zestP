package com.zest.web.admin.dao;

import java.util.List;

import com.zest.web.admin.model.CommentVO;

public interface CommentDAO {

	public void commentInsert(CommentVO vo) ;
	
	public void commentUpdate(CommentVO vo) ;
	
	public void commentDelete(Integer ad_reple_no) ;
	// ��� ��������
	public List<CommentVO> commentList(Integer ad_reple_addno) ;
	// �Խñۿ� �ش��ϴ� ��� ��� �����
	public void commentListAll(Integer ad_reple_addno);	


}
