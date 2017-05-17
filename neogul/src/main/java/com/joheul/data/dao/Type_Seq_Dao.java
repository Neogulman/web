package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Type_Seq;

@Repository @Lazy
public class Type_Seq_Dao extends SqlSessionDaoSupport {
	
	public TB_Type_Seq fnView(TB_Type_Seq vo) throws Exception {
		return getSqlSession().selectOne("xml-type-seq.list", vo);
	}

	public List<TB_Type_Seq> fnList(TB_Type_Seq vo) throws Exception {
		return getSqlSession().selectList("xml-type-seq.list", vo);
	}

	public int fnUpdate(TB_Type_Seq vo) throws Exception {
		return getSqlSession().update("xml-type-seq.update", vo);
	}

	
}