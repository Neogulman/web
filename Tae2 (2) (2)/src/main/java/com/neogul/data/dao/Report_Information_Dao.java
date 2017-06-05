package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Report_Information;

@Repository @Lazy
public class Report_Information_Dao extends SqlSessionDaoSupport {
	
	public int fnMrgNo() throws Exception {
		return getSqlSession().selectOne("xml-report-information.mrg-no");
	}

	public int fnCnt(TB_Report_Information vo) throws Exception {
		return getSqlSession().selectOne("xml-report-information.cnt", vo);
	}

	public TB_Report_Information fnView(TB_Report_Information vo) throws Exception {
		return getSqlSession().selectOne("xml-report-information.list", vo);
	}

	public List<TB_Report_Information> fnList(TB_Report_Information vo) throws Exception {
		return getSqlSession().selectList("xml-report-information.list", vo);
	}

	public int fnInsert(TB_Report_Information vo) throws Exception {
		return getSqlSession().insert("xml-report-information.insert", vo);
	}
	
	public int fnUpdate(TB_Report_Information vo) throws Exception {
		return getSqlSession().update("xml-report-information.update", vo);
	}

	public int fnDelete(TB_Report_Information vo) throws Exception {
		return getSqlSession().delete("xml-report-information.delete", vo);
	}
}