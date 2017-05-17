package com.joheul.data.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Pwd_Rule;

@Repository @Lazy
public class Pwd_Rule_Dao extends SqlSessionDaoSupport {
	
	public TB_Pwd_Rule fnView() throws Exception {
		return getSqlSession().selectOne("xml-pwd-rule.view");
	}
	
	public int fnUpdate(TB_Pwd_Rule vo) throws Exception {
		return getSqlSession().update("xml-pwd-rule.update", vo);
	}
}