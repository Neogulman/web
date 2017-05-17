package com.joheul.data.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Config_Anony;

@Repository @Lazy
public class Config_Anony_Dao extends SqlSessionDaoSupport {
	
	public TB_Config_Anony fnView(TB_Config_Anony vo) throws Exception {
		return getSqlSession().selectOne("xml-config-anony.view", vo);
	}

	public int fnUpdate(TB_Config_Anony vo) throws Exception {
		return getSqlSession().update("xml-config-anony.update", vo);
	}
}