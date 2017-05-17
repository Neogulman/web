package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_User_Info_History;

@Repository @Lazy
public class User_Info_History_Dao extends SqlSessionDaoSupport {
	
	public List<TB_User_Info_History> fnList(TB_User_Info_History vo) throws Exception {
		return getSqlSession().selectList("xml-user-info-history.list", vo);
	}	
	
	public int fnInsert(TB_User_Info_History vo) throws Exception {
		return getSqlSession().insert("xml-user-info-history.insert", vo);
	}
}