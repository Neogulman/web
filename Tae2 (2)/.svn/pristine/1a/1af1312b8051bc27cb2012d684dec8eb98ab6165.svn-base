package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Report_Templet;

@Repository @Lazy
public class Report_Templet_Dao extends SqlSessionDaoSupport {
	
	public TB_Report_Templet fnView(TB_Report_Templet vo) throws Exception {
		return getSqlSession().selectOne("xml-report-templet.list", vo);
	}
	
	public int fnCnt(TB_Report_Templet vo) throws Exception {
		return getSqlSession().selectOne("xml-report-templet.cnt", vo);
	}

	public List<TB_Report_Templet> fnList(TB_Report_Templet vo) throws Exception {
		return getSqlSession().selectList("xml-report-templet.list", vo);
	}
	
	public int fnInsert(TB_Report_Templet vo) throws Exception {
		return getSqlSession().insert("xml-report-templet.insert", vo);
	}

	public int fnUpdate(TB_Report_Templet vo) throws Exception {
		return getSqlSession().update("xml-report-templet.update", vo);
	}

	public int fnDelete(TB_Report_Templet vo) throws Exception {
		return getSqlSession().delete("xml-report-templet.delete", vo);
	}
}