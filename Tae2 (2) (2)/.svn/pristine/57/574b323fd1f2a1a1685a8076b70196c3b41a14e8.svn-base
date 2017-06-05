package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_System_Info;

@Repository @Lazy
public class System_Info_Dao extends SqlSessionDaoSupport {
	
	public TB_System_Info fnView(TB_System_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-system-info.list", vo);
	}

	public List<TB_System_Info> fnList(TB_System_Info vo) throws Exception {
		return getSqlSession().selectList("xml-system-info.list", vo);
	}
	
	public int fnInsert(TB_System_Info vo) throws Exception {
		return getSqlSession().insert("xml-system-info.insert", vo);
	}

	public int fnUpdate(TB_System_Info vo) throws Exception {
		return getSqlSession().update("xml-system-info.update", vo);
	}
}