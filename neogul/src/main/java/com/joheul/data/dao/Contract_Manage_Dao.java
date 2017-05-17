package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Contract_Manage;

@Repository @Lazy
public class Contract_Manage_Dao extends SqlSessionDaoSupport {
	
	
	public TB_Contract_Manage fnView(TB_Contract_Manage vo) throws Exception {
		return getSqlSession().selectOne("xml-contract-manage.list", vo);
	}
	
	public int fnCnt(TB_Contract_Manage vo) throws Exception {
		return getSqlSession().selectOne("xml-contract-manage.cnt", vo);
	}
	
	public int fnMax() throws Exception {
		return getSqlSession().selectOne("xml-contract-manage.max");
	}

	public List<TB_Contract_Manage> fnList(TB_Contract_Manage vo) throws Exception {
		return getSqlSession().selectList("xml-contract-manage.list", vo);
	}
	
	
	
	public List<TB_Contract_Manage> fnList() throws Exception {
		return getSqlSession().selectList("xml-contract-manage.list");
	}
	
	public int fnInsert(TB_Contract_Manage vo) throws Exception {
		return getSqlSession().insert("xml-contract-manage.insert", vo);
	}

	public int fnUpdate(TB_Contract_Manage vo) throws Exception {
		return getSqlSession().update("xml-contract-manage.update", vo);
	}

	public int fnDelete(TB_Contract_Manage vo) throws Exception {
		return getSqlSession().delete("xml-contract-manage.delete", vo);
	}
}