package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Policy_Group_Log;

@Repository @Lazy
public class Policy_Group_Log_Dao extends SqlSessionDaoSupport {
	
	public List<TB_Policy_Group_Log> fnList(TB_Policy_Group_Log vo) throws Exception {
		return getSqlSession().selectList("xml-policy-group-log.list", vo);
	}
	
	public int fnInsert(TB_Policy_Group_Log vo) throws Exception {
		return getSqlSession().insert("xml-policy-group-log.insert", vo);
	}

	public int fnUpdate(TB_Policy_Group_Log vo) throws Exception {
		return getSqlSession().update("xml-policy-group-log.update", vo);
	}
	
	public int fnDelete(TB_Policy_Group_Log vo) throws Exception {
		return getSqlSession().delete("xml-policy-group-log.delete", vo);
	}
}