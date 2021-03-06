package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Config_Movie;
import com.joheul.data.dto.TB_Operation_Info;
import com.joheul.data.dto.TB_Operation_Log;
import com.joheul.data.dto.TB_Policy_Item;

@Repository @Lazy
public class Operation_Info_Dao extends SqlSessionDaoSupport {
	
	public int fnMax() throws Exception {
		return getSqlSession().selectOne("xml-operation-info.max");
	}

	public TB_Operation_Info fnCheck(TB_Operation_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-operation-info.check", vo);
	}

	public int fnCnt(TB_Operation_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-operation-info.cnt", vo);
	}

	public int fnDCnt(TB_Operation_Log vo) throws Exception {
		return getSqlSession().selectOne("xml-operation-info.day-cnt", vo);
	}

	public int fnMCnt(TB_Operation_Log vo) throws Exception {
		return getSqlSession().selectOne("xml-operation-info.month-cnt", vo);
	}

	public TB_Operation_Info fnView(TB_Operation_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-operation-info.list", vo);
	}
	
	public List<TB_Operation_Info> fnList(TB_Operation_Info vo) throws Exception {
		return getSqlSession().selectList("xml-operation-info.list", vo);
	}
	
	public List<TB_Operation_Info> fnTimeline(TB_Operation_Info vo) throws Exception {
		return getSqlSession().selectList("xml-operation-info.timeline", vo);
	}
	
	public int fnInsert(TB_Operation_Info vo) throws Exception {
		return getSqlSession().update("xml-operation-info.insert", vo);
	}

	public int fnUpdate(TB_Operation_Info vo) throws Exception {
		return getSqlSession().update("xml-operation-info.update", vo);
	}

	public int fnDelete(TB_Operation_Info vo) throws Exception {
		return getSqlSession().delete("xml-operation-info.delete", vo);
	}

	public int fnReport(TB_Operation_Info vo) throws Exception {
		return getSqlSession().update("xml-operation-info.report", vo);
	}
	
	public TB_Operation_Info fnSelectOne(TB_Operation_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-operation-info.selectOne", vo);
	}
	
	public List<String> fnSelectPolicyItem(TB_Policy_Item vo) throws Exception {
		return  getSqlSession().selectList("xml-operation-info.selectPolicyItem", vo);
	}
	
	public TB_Config_Movie fnMovie(TB_Config_Movie vo) throws Exception {
		return getSqlSession().selectOne("xml-config-movie.view", vo);
	}
	public int fnUpdateStatus(TB_Operation_Info vo) throws Exception {
		return getSqlSession().update("xml-operation-info.updateStatus", vo);
	}
	
	/*
	 * v2.0 new 접속 통계 수정 부분
	 * 
	 */
	public int fnDWorkStatus(TB_Operation_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-operation-info.dwork-status", vo);
	}
	public int fnMWorkStatus(TB_Operation_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-operation-info.mwork-status", vo);
	}

	public TB_Operation_Info fnSelectOutOne(TB_Operation_Info vo) {
		return getSqlSession().selectOne("xml-operation-info.selectOutOne", vo);
	}

	

	
}