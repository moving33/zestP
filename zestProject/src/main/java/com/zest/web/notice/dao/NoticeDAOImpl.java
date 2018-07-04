package com.zest.web.notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.notice.model.NoticeVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	// 01. 게시글 작성
	@Override
	public void create(NoticeVO vo) throws Exception {
		sqlSessionTemplate.insert("com.zest.notice.insert", vo);
	}

	// 02. 게시글 상세보기
	@Override
	public NoticeVO read(int bno) throws Exception {
		return sqlSessionTemplate.selectOne("com.zest.notice.view", bno);
	}

	// 03. 게시글 수정
	@Override
	public void update(NoticeVO vo) throws Exception {
		sqlSessionTemplate.update("com.zest.notice.updateArticle", vo);

	}

	// 04. 게시글 삭제
	@Override
	public void delete(int bno) throws Exception {
		sqlSessionTemplate.delete("com.zest.notice.deleteArticle", bno);

	}

	// 05. 게시글 전체 목록
	@Override
	public List<NoticeVO> listAll(Object obj) throws Exception {
		System.out.println("공지사항 리스트");
		return sqlSessionTemplate.selectList("com.zest.notice.listAll", obj);
		
	}

	// 게시글 조회수 증가
	@Override
	public void increaseViewcnt(int bno){
		sqlSessionTemplate.update("com.zest.notice.increaseViewcnt", bno);
	}
	
	// 카운트
		public Integer getCount(Object obj) {
			return sqlSessionTemplate.selectOne("com.zest.notice.getCount",obj);
		}
}
