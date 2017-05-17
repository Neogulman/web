package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Project_List;



@Repository @Lazy
public class Project_List_Dao extends SqlSessionDaoSupport {
	
	public TB_Project_List fnView(TB_Project_List vo) throws Exception {
		return getSqlSession().selectOne("xml-project-list.list", vo);
	}
	
	public int fnCnt(TB_Project_List vo) throws Exception {
		return getSqlSession().selectOne("xml-project-list.cnt", vo);
	}

	public List<TB_Project_List> fnList(TB_Project_List vo) throws Exception {
		return getSqlSession().selectList("xml-project-list.list", vo);
	}
	
	public int fnInsert(TB_Project_List vo) throws Exception {
		return getSqlSession().insert("xml-project-list.insert", vo);
	}

	public int fnUpdate(TB_Project_List vo) throws Exception {
		return getSqlSession().update("xml-project-list.update", vo);
	}

	public int fnDelete(TB_Project_List vo) throws Exception {
		return getSqlSession().delete("xml-project-list.delete", vo);
	}
}