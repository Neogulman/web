package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_User_Entrust;
import com.joheul.data.dto.TB_User_Info;

@Repository @Lazy
public class User_Info_Dao extends SqlSessionDaoSupport {
	
	public TB_User_Info fnView(TB_User_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-user-info.list", vo);
	}
	
	public TB_User_Info fnWorkView(TB_User_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-user-info.work", vo);
	}
	
	public int fnCnt(TB_User_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-user-info.cnt", vo);
	}

	public List<TB_User_Info> fnList(TB_User_Info vo) throws Exception {
		return getSqlSession().selectList("xml-user-info.list", vo);
	}
	
	public List<TB_User_Info> fnManagerList(TB_User_Info vo) throws Exception {
		return getSqlSession().selectList("xml-user-info.manager-list", vo);
	}
	
	public List<TB_User_Info> fnListAll(TB_User_Info vo) throws Exception {
		return getSqlSession().selectList("xml-user-info.alllist", vo);
	}
	
	public int fnWorkCnt(TB_User_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-user-info.work-cnt", vo);
	}

	public List<TB_User_Info> fnWorkList(TB_User_Info vo) throws Exception {
		return getSqlSession().selectList("xml-user-info.work", vo);
	}
	
	public int fnPwd(TB_User_Info vo) throws Exception {
		return getSqlSession().update("xml-user-info.pwd", vo);
	}
	
	public int fnWorkPwd(TB_User_Info vo) throws Exception {
		return getSqlSession().update("xml-user-info.work-pwd", vo);
	}
	
	public int fnLoginCnt(TB_User_Info vo) throws Exception {
		return getSqlSession().update("xml-user-info.login-cnt", vo);
	}
	
	public int fnLoginFailCnt(TB_User_Info vo) throws Exception {
		return getSqlSession().update("xml-user-info.login-fail-cnt", vo);
	}

	public int fnInsert(TB_User_Info vo) throws Exception {
		return getSqlSession().insert("xml-user-info.insert", vo);
	}

	public int fnUpdate(TB_User_Info vo) throws Exception {
		return getSqlSession().update("xml-user-info.update", vo);
	}

	public int fnDelete(TB_User_Info vo) throws Exception {
		return getSqlSession().update("xml-user-info.delete", vo);
	}

	public int fnStatus(TB_User_Info vo) throws Exception {
		return getSqlSession().update("xml-user-info.status", vo);
	}
	
	public int fnLevel(TB_User_Entrust vo) throws Exception {
		return getSqlSession().update("xml-user-info.level", vo);
	}
	
	public TB_User_Info fnUserPw(TB_User_Info vo) throws Exception {
		return getSqlSession().selectOne("xml-user-info.user-pw", vo);
	}
}