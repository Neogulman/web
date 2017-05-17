package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Fault_Report;

@Repository @Lazy
public class Fault_Report_Dao extends SqlSessionDaoSupport {
	
	public TB_Fault_Report fnView(TB_Fault_Report vo) throws Exception {
		return getSqlSession().selectOne("xml-fault-report.list", vo);
	}
	
	public int fnCnt(TB_Fault_Report vo) throws Exception {
		return getSqlSession().selectOne("xml-fault-report.cnt", vo);
	}
	
	public int fnMax() throws Exception {
		return getSqlSession().selectOne("xml-fault-report.max");
	}

	public List<TB_Fault_Report> fnList(TB_Fault_Report vo) throws Exception {
		return getSqlSession().selectList("xml-fault-report.list", vo);
	}
	
	public List<TB_Fault_Report> fnListPrint(TB_Fault_Report vo) throws Exception {
		return getSqlSession().selectList("xml-fault-report.printlist", vo);
	}
	
	public int fnInsert(TB_Fault_Report vo) throws Exception {
		return getSqlSession().insert("xml-fault-report.insert", vo);
	}

	public int fnUpdate(TB_Fault_Report vo) throws Exception {
		return getSqlSession().update("xml-fault-report.update", vo);
	}

	public int fnDelete(TB_Fault_Report vo) throws Exception {
		return getSqlSession().delete("xml-fault-report.delete", vo);
	}
}