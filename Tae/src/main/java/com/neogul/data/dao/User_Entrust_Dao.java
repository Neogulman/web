package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_User_Entrust;

@Repository @Lazy
public class User_Entrust_Dao extends SqlSessionDaoSupport {
	
	public TB_User_Entrust fnView(TB_User_Entrust vo) throws Exception {
		return getSqlSession().selectOne("xml-user-entrust.list", vo);
	}
	
	public int fnCnt(TB_User_Entrust vo) throws Exception {
		return getSqlSession().selectOne("xml-user-entrust.cnt", vo);
	}

	public List<TB_User_Entrust> fnList(TB_User_Entrust vo) throws Exception {
		return getSqlSession().selectList("xml-user-entrust.list", vo);
	}
	
	public int fnInsert(TB_User_Entrust vo) throws Exception {
		return getSqlSession().insert("xml-user-entrust.insert", vo);
	}

	public int fnUpdate(TB_User_Entrust vo) throws Exception {
		return getSqlSession().update("xml-user-entrust.update", vo);
	}
}