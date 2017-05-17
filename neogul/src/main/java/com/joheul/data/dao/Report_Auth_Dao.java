package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Report_Auth;

@Repository @Lazy
public class Report_Auth_Dao extends SqlSessionDaoSupport {
	
	
	public int fnCnt(TB_Report_Auth vo) throws Exception {
		return getSqlSession().selectOne("xml-report-auth.cnt", vo);
	}
	
	
	public List<TB_Report_Auth> fnList(TB_Report_Auth vo) throws Exception {
		return getSqlSession().selectList("xml-report-auth.list", vo);
	}
	
	public int fnInsert(TB_Report_Auth vo) throws Exception {
		return getSqlSession().insert("xml-report-auth.insert", vo);
	}
	
	public int fnDelete(TB_Report_Auth vo) throws Exception {
		return getSqlSession().delete("xml-report-auth.delete", vo);
	}


}