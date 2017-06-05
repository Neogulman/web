package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Contract_Info;

@Repository @Lazy
public class Contract_Info_Dao extends SqlSessionDaoSupport {
	
	public List<TB_Contract_Info> fnList(TB_Contract_Info vo) throws Exception {
		return getSqlSession().selectList("xml-contract-info.list", vo);
	}
	
	public int fnInsert(TB_Contract_Info vo) throws Exception {
		return getSqlSession().insert("xml-contract-info.insert", vo);
	}

	public int fnDelete(TB_Contract_Info vo) throws Exception {
		return getSqlSession().delete("xml-contract-info.delete", vo);
	}
}