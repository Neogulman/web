package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Operation_Log;
import com.neogul.data.dto.TB_Policy_Item;

@Repository @Lazy
public class Policy_Item_Dao extends SqlSessionDaoSupport {
	
	public TB_Policy_Item fnCheck(TB_Policy_Item vo) throws Exception {
		return getSqlSession().selectOne("xml-policy-item.check", vo);
	}
	public TB_Policy_Item fnView(TB_Policy_Item vo) throws Exception {
		return getSqlSession().selectOne("xml-policy-item.list", vo);
	}
	
	public int fnCnt(TB_Policy_Item vo) throws Exception {
		return getSqlSession().selectOne("xml-policy-item.cnt", vo);
	}

	public List<TB_Policy_Item> fnList(TB_Policy_Item vo) throws Exception {
		return getSqlSession().selectList("xml-policy-item.list", vo);
	}
	
	public List<TB_Policy_Item> fnPop(TB_Policy_Item vo) throws Exception {
		return getSqlSession().selectList("xml-policy-item.pop", vo);
	}
	
	public List<TB_Operation_Log> fnNotList(TB_Operation_Log vo) throws Exception {
		return getSqlSession().selectList("xml-operation-log.not-list", vo);
	}
	
	public int fnInsert(TB_Policy_Item vo) throws Exception {
		return getSqlSession().insert("xml-policy-item.insert", vo);
	}

	public int fnUpdate(TB_Policy_Item vo) throws Exception {
		return getSqlSession().update("xml-policy-item.update", vo);
	}

	public int fnDelete(TB_Policy_Item vo) throws Exception {
		return getSqlSession().delete("xml-policy-item.delete", vo);
	}

	public int fnDeleteName(TB_Policy_Item vo) throws Exception {
		return getSqlSession().delete("xml-policy-item.delete-name", vo);
	}
}