package com.joheul.data.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_MailConfig;

@Repository @Lazy
public class MailConfig_Dao extends SqlSessionDaoSupport {
	
	public TB_MailConfig fnView() throws Exception {
		return getSqlSession().selectOne("xml-mail-config.view");
	}

	public int fnUpdate(TB_MailConfig vo) throws Exception {
		return getSqlSession().update("xml-mail-config.update", vo);
	}
}