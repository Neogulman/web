package com.neogul.data.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Config_Movie;

@Repository @Lazy
public class Config_Movie_Dao extends SqlSessionDaoSupport {
	
	public TB_Config_Movie fnView(TB_Config_Movie vo) throws Exception {
		return getSqlSession().selectOne("xml-config-movie.view", vo);
	}

	public int fnUpdate(TB_Config_Movie vo) throws Exception {
		return getSqlSession().update("xml-config-movie.update", vo);
	}
}