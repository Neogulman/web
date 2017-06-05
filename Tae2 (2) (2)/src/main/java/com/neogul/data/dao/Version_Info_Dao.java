package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Version_Info;

@Repository @Lazy
public class Version_Info_Dao extends SqlSessionDaoSupport {
	
	public List<TB_Version_Info> fnList(TB_Version_Info vo) throws Exception {
		return getSqlSession().selectList("xml-version-info.list", vo);
	}
}