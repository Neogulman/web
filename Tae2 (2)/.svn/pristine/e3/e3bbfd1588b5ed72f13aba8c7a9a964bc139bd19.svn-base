package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_User_Login_Log;

@Repository @Lazy
public class User_Login_Log_Dao extends SqlSessionDaoSupport {
	
	public int fnCnt(TB_User_Login_Log vo) throws Exception {
		return getSqlSession().selectOne("xml-user-login-log.cnt", vo);
	}

	public List<TB_User_Login_Log> fnList(TB_User_Login_Log vo) throws Exception {
		return getSqlSession().selectList("xml-user-login-log.list", vo);
	}

	public int fnInsert(TB_User_Login_Log vo) throws Exception {
		return getSqlSession().insert("xml-user-login-log.insert", vo);
	}
}