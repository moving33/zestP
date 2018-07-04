package com.zest.web.admin.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.admin.dao.BoardDAO;
import com.zest.web.admin.model.BoardVO;
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	
	@Override
	public void insert(BoardVO vo)  {
		dao.insert(vo);
	}

	@Override
	public List<BoardVO> listAll(Object obj) {
		return dao.listAll(obj);
	}

	@Override
	public BoardVO get(Integer add_no)  {
		
		return dao.get(add_no);
	}

	@Override
	public void boardDelete(Integer add_no)  {
		
		dao.boardDelete(add_no);
		
	}

	@Override
	public void update(BoardVO vo)  {
			dao.update(vo);
	}

	@Override
	public int updateRepleNum(BoardVO vo) {

		return	dao.updateRepleNum(vo);
			
	}

	@Override
	public void updateBoardRead(BoardVO vo) {
		 dao.updateBoardRead(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {

		return dao.getBoardList(vo);
	}

	@Override
	public int getBoardListCount(Object obj) {
		return dao.getBoardListCount(obj);
	}

}
