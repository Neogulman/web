package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Saleslist;

@Repository @Lazy
public class Saleslist_Dao extends SqlSessionDaoSupport {
	
	public int fnCnt(TB_Saleslist vo) throws Exception {
		return getSqlSession().selectOne("xml-saleslist.cnt", vo);
	}

	public TB_Saleslist fnView(TB_Saleslist vo) throws Exception {
		return getSqlSession().selectOne("xml-saleslist.list", vo);
	}

	public List<TB_Saleslist> fnList(TB_Saleslist vo) throws Exception {
		return getSqlSession().selectList("xml-saleslist.list", vo);
	}

	public int fnUpdateStatus(TB_Saleslist vo) throws Exception {
		return getSqlSession().update("xml-saleslist.updateStatus", vo);
	}
	public int fnUpdateStatusAll() throws Exception {
		return getSqlSession().update("xml-saleslist.updateStatusAll");
	}
	public int fnUpdate(TB_Saleslist vo) throws Exception {
		return getSqlSession().update("xml-saleslist.update", vo);
	}
	
	public int fnUpdateNickName(TB_Saleslist vo) throws Exception {
		return getSqlSession().update("xml-saleslist.update-nick", vo);
	}
	
	public int fnInsert(TB_Saleslist vo) throws Exception {
		return getSqlSession().update("xml-saleslist.insert", vo);
	}
	
	public TB_Saleslist fnSelectOne(TB_Saleslist vo) throws Exception {
		return getSqlSession().selectOne("xml-saleslist.selectOne", vo);
	}

	public int fnDelete(TB_Saleslist vo) throws Exception {
		return getSqlSession().delete("xml-saleslist.delete", vo);
	}
}