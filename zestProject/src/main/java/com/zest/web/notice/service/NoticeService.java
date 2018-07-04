package com.zest.web.notice.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.zest.web.notice.model.NoticeVO;

public interface NoticeService {
	  // 01. 게시글 작성
    public void create(NoticeVO vo) throws Exception;
    // 02. 게시글 상세보기
    public NoticeVO read(int bno) throws Exception;
    // 03. 게시글 수정
    public void update(NoticeVO vo) throws Exception;
    // 04. 게시글 삭제
    public void delete(int bno) throws Exception;
    // 05. 게시글 전체 목록
    public List<NoticeVO> listAll(Object obj) throws Exception;
    // 06. 게시글 조회
    public void increaseViewcnt(int bno);
    // 카운트
    public Integer getCount(Object obj);
}
