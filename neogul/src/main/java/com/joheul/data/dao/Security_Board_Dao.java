package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Security_Board;

@Repository @Lazy
public class Security_Board_Dao extends SqlSessionDaoSupport {
	
	public int fnMax() throws Exception {
		return getSqlSession().selectOne("xml-security-board.max");
	}
	public TB_Security_Board fnView(TB_Security_Board vo) throws Exception {
		return getSqlSession().selectOne("xml-security-board.list", vo);
	}
	
	public int fnCnt(TB_Security_Board vo) throws Exception {
		return getSqlSession().selectOne("xml-security-board.cnt", vo);
	}

	public List<TB_Security_Board> fnList(TB_Security_Board vo) throws Exception {
		return getSqlSession().selectList("xml-security-board.list", vo);
	}
	
	public int fnInsert(TB_Security_Board vo) throws Exception {
		return getSqlSession().insert("xml-security-board.insert", vo);
	}

	public int fnUpdate(TB_Security_Board vo) throws Exception {
		return getSqlSession().update("xml-security-board.update", vo);
	}

	public int fnDelete(TB_Security_Board vo) throws Exception {
		return getSqlSession().delete("xml-security-board.delete", vo);
	}
}