package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Operation_Log;

@Repository 

public class Operation_Log_Dao extends SqlSessionDaoSupport {
	
	public int fnCnt(TB_Operation_Log vo) throws Exception {
		return getSqlSession().selectOne("xml-operation-log.cnt", vo);
	}

	public List<TB_Operation_Log> fnList(TB_Operation_Log vo) throws Exception {
		return getSqlSession().selectList("xml-operation-log.list", vo);
	}

	public List<TB_Operation_Log> fnMovieList(TB_Operation_Log vo) throws Exception {
		return getSqlSession().selectList("xml-operation-log.movie-list", vo);
	}
	
	public List<TB_Operation_Log> fnReport(TB_Operation_Log vo) throws Exception {
		return getSqlSession().selectList("xml-operation-log.report", vo);
	}
	
	public int fnInsert(TB_Operation_Log vo) throws Exception {
		return getSqlSession().insert("xml-operation-log.insert", vo);
	}
	
	public int fnInsertLogs(List<TB_Operation_Log> logs) throws Exception {
		return getSqlSession().insert("xml-operation-log.insertLogs", logs);
	}
}