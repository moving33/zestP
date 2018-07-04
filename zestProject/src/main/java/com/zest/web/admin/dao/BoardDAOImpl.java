package com.zest.web.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.admin.model.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlsession;
	
	private static String namespace = "com.zest.adminBoard";
	
	 //게시판추가
    @Override
    public void insert(BoardVO vo)  {
        // id = insert
        sqlsession.insert(namespace+".insert", vo);
 
    }
    
    //게시판보기
    @Override
    public List<BoardVO> listAll(Object obj)  {
        List<BoardVO> list = sqlsession.selectList(namespace+".listAll",obj);
        System.out.println(list.size());
        return list;
    }
    
    //게시판 상세
    @Override
    public BoardVO get(Integer add_no)  {
        BoardVO board = sqlsession.selectOne(namespace+".get", add_no);
        System.out.println(board.getAdd_title());
        return board ;
    }
 
    //게시판 삭제
    @Override
    public void boardDelete(Integer add_no)  {
        sqlsession.delete(namespace+".delete", add_no);
 
    }
 
    //게시판 수정
    @Override
    public void update(BoardVO vo)  {
        sqlsession.update(namespace+".update", vo);
 
    }

	@Override
	public int updateRepleNum(BoardVO vo) {
		return sqlsession.update(namespace+".updateRepleNum", vo);
	}
	
	// 조회수 증가
	@Override
	public void updateBoardRead(BoardVO vo) {
		 sqlsession.update(namespace+".updateBoardRead", vo);
	}
	// 게시판 검색 기능
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
			
		return sqlsession.selectList(namespace+".boardGetCheck", vo);
	}

	@Override
	public int getBoardListCount(Object obj) {

			
		return sqlsession.selectOne(namespace+".selectcount", obj);
	}
}
