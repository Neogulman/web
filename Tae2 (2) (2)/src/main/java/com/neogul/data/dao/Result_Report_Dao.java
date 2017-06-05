package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Result_Report;

@Repository @Lazy
public class Result_Report_Dao extends SqlSessionDaoSupport {
	
	public TB_Result_Report fnView(TB_Result_Report vo) throws Exception {
		return getSqlSession().selectOne("xml-result-report.list", vo);
	}
	
	public int fnCnt(TB_Result_Report vo) throws Exception {
		return getSqlSession().selectOne("xml-result-report.cnt", vo);
	}
	
	public int fnMax() throws Exception {
		return getSqlSession().selectOne("xml-result-report.max");
	}
	
	public List<TB_Result_Report> fnList(TB_Result_Report vo) throws Exception {
		return getSqlSession().selectList("xml-result-report.list", vo);
	}
	
	public int fnInsert(TB_Result_Report vo) throws Exception {
		return getSqlSession().insert("xml-result-report.insert", vo);
	}

	public int fnUpdate(TB_Result_Report vo) throws Exception {
		return getSqlSession().update("xml-result-report.update", vo);
	}

	public int fnDelete(TB_Result_Report vo) throws Exception {
		return getSqlSession().delete("xml-result-report.delete", vo);
	}
}