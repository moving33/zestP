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
	
	 //�Խ����߰�
    @Override
    public void insert(BoardVO vo)  {
        // id = insert
        sqlsession.insert(namespace+".insert", vo);
 
    }
    
    //�Խ��Ǻ���
    @Override
    public List<BoardVO> listAll(Object obj)  {
        List<BoardVO> list = sqlsession.selectList(namespace+".listAll",obj);
        System.out.println(list.size());
        return list;
    }
    
    //�Խ��� ��
    @Override
    public BoardVO get(Integer add_no)  {
        BoardVO board = sqlsession.selectOne(namespace+".get", add_no);
        System.out.println(board.getAdd_title());
        return board ;
    }
 
    //�Խ��� ����
    @Override
    public void boardDelete(Integer add_no)  {
        sqlsession.delete(namespace+".delete", add_no);
 
    }
 
    //�Խ��� ����
    @Override
    public void update(BoardVO vo)  {
        sqlsession.update(namespace+".update", vo);
 
    }

	@Override
	public int updateRepleNum(BoardVO vo) {
		return sqlsession.update(namespace+".updateRepleNum", vo);
	}
	
	// ��ȸ�� ����
	@Override
	public void updateBoardRead(BoardVO vo) {
		 sqlsession.update(namespace+".updateBoardRead", vo);
	}
	// �Խ��� �˻� ���
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
			
		return sqlsession.selectList(namespace+".boardGetCheck", vo);
	}

	@Override
	public int getBoardListCount(Object obj) {

			
		return sqlsession.selectOne(namespace+".selectcount", obj);
	}
}
