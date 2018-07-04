package com.zest.web.admin.service.board;

import java.util.List;

import com.zest.web.admin.model.BoardVO;

public interface BoardService {

	
	
	public void insert(BoardVO vo) ;
	
	public List<BoardVO> listAll(Object obj) ;
	
	public BoardVO get(Integer add_no) ; 
	
	public void boardDelete(Integer add_no) ;

	public void update(BoardVO vo) ;
	// ��� ���� 
	public int updateRepleNum(BoardVO vo);
	// ��ȸ�� ����
	public void updateBoardRead(BoardVO vo);
	// �˻� ��� 
	public List<BoardVO> getBoardList(BoardVO vo);
	
	public int getBoardListCount(Object obj);
}
