package com.zest.web.admin.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.admin.dao.CommentDAO;
import com.zest.web.admin.model.CommentVO;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentdao;
	
	@Override
	public void commentInsert(CommentVO vo) {
			
		commentdao.commentInsert(vo);
		
	}

	@Override
	public void commentUpdate(CommentVO vo) {

		commentdao.commentUpdate(vo);
	}

	@Override
	public void commentDelete(Integer ad_reple_no) {

		commentdao.commentDelete(ad_reple_no);
	}

	@Override
	public List<CommentVO> commentList(Integer ad_reple_addno) {
	
		
		return commentdao.commentList(ad_reple_addno);
	}

	@Override
	public void commentDeleteAll(Integer ad_reple_addno) {

		commentdao.commentListAll(ad_reple_addno);
	}

}
