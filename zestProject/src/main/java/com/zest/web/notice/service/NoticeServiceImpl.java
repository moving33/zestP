package com.zest.web.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.notice.dao.NoticeDAO;
import com.zest.web.notice.model.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDAO noticeDAO;

	// 01. 게시글쓰기
	@Override
	public void create(NoticeVO vo) throws Exception {
		noticeDAO.create(vo);
	}

	// 02. 게시글 상세보기
	@Override
	public NoticeVO read(int bno) throws Exception {
		return noticeDAO.read(bno);
	}

	// 03. 게시글 수정
	@Override
	public void update(NoticeVO vo) throws Exception {
		noticeDAO.update(vo);
	}

	// 04. 게시글 삭제
	@Override
	public void delete(int bno) throws Exception {
		noticeDAO.delete(bno);
	}

	// 05. 게시글 전체 목록
	@Override
	public List<NoticeVO> listAll(Object obj) throws Exception {
		return noticeDAO.listAll(obj);
	}

	// 06. 게시글 조회수 증가
	@Override
	public void increaseViewcnt(int bno) {
			noticeDAO.increaseViewcnt(bno);

	}
	
	// 카운트
	public Integer getCount(Object obj) {
		return noticeDAO.getCount(obj);
	}

}