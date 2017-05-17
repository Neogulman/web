package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Pwd_Modify_History;

@Repository @Lazy
public class Pwd_Modify_History_Dao extends SqlSessionDaoSupport {
	
	
	public int fnCnt(TB_Pwd_Modify_History vo) throws Exception {
		return getSqlSession().selectOne("xml-pwd-modify-history.cnt", vo);
	}

	public List<TB_Pwd_Modify_History> fnList(TB_Pwd_Modify_History vo) throws Exception {
		return getSqlSession().selectList("xml-pwd-modify-history.list", vo);
	}
	
	public int fnInsert(TB_Pwd_Modify_History vo) throws Exception {
		return getSqlSession().insert("xml-pwd-modify-history.insert", vo);
	}
	
	public TB_Pwd_Modify_History fnView() throws Exception {
		return getSqlSession().selectOne("xml-pwd-modify-history.latest");
	}

	public TB_Pwd_Modify_History fnLatest(TB_Pwd_Modify_History vo) throws Exception {
		return getSqlSession().selectOne("xml-pwd-modify-history.latest", vo);
	}
	
	public int fnDelete(TB_Pwd_Modify_History vo) throws Exception {
		return getSqlSession().delete("xml-pwd-modify-history.delete", vo);
	}
}