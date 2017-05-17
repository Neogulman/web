package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Manager_Ip;

@Repository @Lazy
public class Manager_Ip_Dao extends SqlSessionDaoSupport {
	
	public TB_Manager_Ip fnView(TB_Manager_Ip vo) throws Exception {
		return getSqlSession().selectOne("xml-manager-ip.list", vo);
	}

	public List<TB_Manager_Ip> fnList(TB_Manager_Ip vo) throws Exception {
		return getSqlSession().selectList("xml-manager-ip.list", vo);
	}
	
	public int fnInsert(TB_Manager_Ip vo) throws Exception {
		return getSqlSession().insert("xml-manager-ip.insert", vo);
	}
	
	public int fnUpdate(TB_Manager_Ip vo) throws Exception {
		return getSqlSession().update("xml-manager-ip.update", vo);
	}

	public int fnDelete(TB_Manager_Ip vo) throws Exception {
		return getSqlSession().delete("xml-manager-ip.delete", vo);
	}
}