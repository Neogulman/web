package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Data_Board;

@Repository @Lazy
public class Data_Board_Dao extends SqlSessionDaoSupport {
	
	public TB_Data_Board fnView(TB_Data_Board vo) throws Exception {
		return getSqlSession().selectOne("xml-data-board.list", vo);
	}
	
	public int fnCnt(TB_Data_Board vo) throws Exception {
		return getSqlSession().selectOne("xml-data-board.cnt", vo);
	}

	public List<TB_Data_Board> fnList(TB_Data_Board vo) throws Exception {
		return getSqlSession().selectList("xml-data-board.list", vo);
	}
	
	public int fnInsert(TB_Data_Board vo) throws Exception {
		return getSqlSession().insert("xml-data-board.insert", vo);
	}

	public int fnUpdate(TB_Data_Board vo) throws Exception {
		return getSqlSession().update("xml-data-board.update", vo);
	}

	public int fnDelete(TB_Data_Board vo) throws Exception {
		return getSqlSession().delete("xml-data-board.delete", vo);
	}
}