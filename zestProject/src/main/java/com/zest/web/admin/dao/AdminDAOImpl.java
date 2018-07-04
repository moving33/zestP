package com.zest.web.admin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.admin.model.AdminVO;
import com.zest.web.admin.model.TalentSubmitVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 관리자 등록
	public void adminRegi(AdminVO vo) {
		sqlSessionTemplate.insert("com.zest.admin.insertAdmin", vo);
	}
	
	// 관리자 조회
	public AdminVO adminSearch(AdminVO vo) {
		vo = sqlSessionTemplate.selectOne("com.zest.admin.searchAdmin", vo); 
		return vo != null ? vo : null;
	}

	@Override
	public List<TalentSubmitVO> getTalentSubmit() {
		return sqlSessionTemplate.selectList("com.zest.admin.submitTalent");
				
	}
	
	
	
}
