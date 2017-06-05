package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Reclist;

@Repository @Lazy
public class Reclist_Dao extends SqlSessionDaoSupport {
	
	public int fnCnt(TB_Reclist vo) throws Exception {
		return getSqlSession().selectOne("xml-reclist.cnt", vo);
	}

	public TB_Reclist fnView(TB_Reclist vo) throws Exception {
		return getSqlSession().selectOne("xml-reclist.list", vo);
	}
	
	public List<TB_Reclist> fnList(TB_Reclist vo) throws Exception {
		return getSqlSession().selectList("xml-reclist.list", vo);
	}

	public int fnUpdateStatus(TB_Reclist vo) throws Exception {
		return getSqlSession().update("xml-reclist.updateStatus", vo);
	}
	public int fnUpdateStatusAll() throws Exception {
		return getSqlSession().update("xml-reclist.updateStatusAll");
	}
	public int fnUpdate(TB_Reclist vo) throws Exception {
		return getSqlSession().update("xml-reclist.update", vo);
	}
	
	public int fnUpdateNickName(TB_Reclist vo) throws Exception {
		return getSqlSession().update("xml-reclist.update-nick", vo);
	}
	
	public int fnInsert(TB_Reclist vo) throws Exception {
		return getSqlSession().update("xml-reclist.insert", vo);
	}
	
	public TB_Reclist fnSelectOne(TB_Reclist vo) throws Exception {
		return getSqlSession().selectOne("xml-reclist.selectOne", vo);
	}

	public int fnDelete(TB_Reclist vo) throws Exception {
		return getSqlSession().delete("xml-reclist.delete", vo);
	}
	public int fnDeleteAll(TB_Reclist vo) throws Exception {
		return getSqlSession().delete("xml-reclist.deleteall", vo);
	}
}