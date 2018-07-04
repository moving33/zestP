package com.zest.web.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.admin.model.CommentVO;
@Repository
public class CommentDAOImpl implements CommentDAO {
	
	
	@Autowired
	private SqlSession sqlsession;
	
	
	private static String namespace = "com.zest.adminBoardComment";
	
	
	@Override
	public void commentInsert(CommentVO vo) {
		sqlsession.insert(namespace+".commentinsert", vo);
	}

	@Override
	public void commentUpdate(CommentVO vo) {
		sqlsession.update(namespace+".commentinsert", vo);
	}

	@Override
	public void commentDelete(Integer ad_reple_no) {
		sqlsession.update(namespace+".commentdelete",ad_reple_no);
	}

	@Override
	public List<CommentVO> commentList(Integer ad_reple_addno) {
		 List<CommentVO> list = sqlsession.selectList(namespace+".commentlist", ad_reple_addno );
	     System.out.println(list.size());
	     return list;
	}

	@Override
	public void commentListAll(Integer ad_reple_addno) {
		sqlsession.delete(namespace+".commentdeleteall" , ad_reple_addno);
	}

}
