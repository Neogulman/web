package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Code_Info;

@Repository @Lazy
public class Code_Info_Dao extends SqlSessionDaoSupport {
	
	public TB_Code_Info fnView(TB_Code_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-code-info.list", vo);
	}
	
	public TB_Code_Info fnCheck(TB_Code_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-code-info.check", vo);
	}
	
	public int fnCnt(TB_Code_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-code-info.cnt", vo);
	}

	public List<TB_Code_Info> fnList(TB_Code_Info vo) throws Exception {
		return getSqlSession().selectList("xml-code-info.list", vo);
	}
	
	public int fnInsert(TB_Code_Info vo) throws Exception {
		return getSqlSession().insert("xml-code-info.insert", vo);
	}

	public int fnUpdate(TB_Code_Info vo) throws Exception {
		return getSqlSession().update("xml-code-info.update", vo);
	}

	public int fnDelete(TB_Code_Info vo) throws Exception {
		return getSqlSession().delete("xml-code-info.delete", vo);
	}
}