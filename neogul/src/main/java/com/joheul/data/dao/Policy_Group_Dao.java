package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Policy_Group;

@Repository @Lazy
public class Policy_Group_Dao extends SqlSessionDaoSupport {
	
	public int fnMax() throws Exception {
		return getSqlSession().selectOne("xml-policy-group.max");
	}
	
	public TB_Policy_Group fnCheck(TB_Policy_Group vo) throws Exception {
		return getSqlSession().selectOne("xml-policy-group.check", vo);
	}

	public TB_Policy_Group fnView(TB_Policy_Group vo) throws Exception {
		return getSqlSession().selectOne("xml-policy-group.list", vo);
	}
	
	public int fnCnt(TB_Policy_Group vo) throws Exception {
		return getSqlSession().selectOne("xml-policy-group.cnt", vo);
	}

	public List<TB_Policy_Group> fnList(TB_Policy_Group vo) throws Exception {
		return getSqlSession().selectList("xml-policy-group.list", vo);
	}
	
	public List<TB_Policy_Group> fnItemList(TB_Policy_Group vo) throws Exception {
		return getSqlSession().selectList("xml-policy-group.item-list", vo);
	}
	
	public int fnInsert(TB_Policy_Group vo) throws Exception {
		return getSqlSession().insert("xml-policy-group.insert", vo);
	}

	public int fnItemInsert(TB_Policy_Group vo) throws Exception {
		return getSqlSession().insert("xml-policy-group.item-insert", vo);
	}
	
	public int fnUpdate(TB_Policy_Group vo) throws Exception {
		return getSqlSession().update("xml-policy-group.update", vo);
	}

	public int fnDelete(TB_Policy_Group vo) throws Exception {
		return getSqlSession().delete("xml-policy-group.delete", vo);
	}

	public int fnItemDelete(TB_Policy_Group vo) throws Exception {
		return getSqlSession().delete("xml-policy-group.item-delete", vo);
	}
}