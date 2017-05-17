package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Report_InformationInOut;

@Repository @Lazy
public class Report_InformationInOut_Dao extends SqlSessionDaoSupport {
	
	public int fnCnt(TB_Report_InformationInOut vo) throws Exception {
		return getSqlSession().selectOne("xml-report-information-inout.cnt", vo);
	}

	public TB_Report_InformationInOut fnView(TB_Report_InformationInOut vo) throws Exception {
		return getSqlSession().selectOne("xml-report-information-inout.list", vo);
	}

	public List<TB_Report_InformationInOut> fnList(TB_Report_InformationInOut vo) throws Exception {
		return getSqlSession().selectList("xml-report-information-inout.list", vo);
	}

	public int fnInsert(TB_Report_InformationInOut vo) throws Exception {
		return getSqlSession().insert("xml-report-information-inout.insert", vo);
	}
	
	public int fnUpdate(TB_Report_InformationInOut vo) throws Exception {
		return getSqlSession().update("xml-report-information-inout.update", vo);
	}

	public int fnDelete(TB_Report_InformationInOut vo) throws Exception {
		return getSqlSession().delete("xml-report-information-inout.delete", vo);
	}
}