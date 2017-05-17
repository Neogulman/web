package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Work_Plan;

@Repository @Lazy
public class Work_Plan_Dao extends SqlSessionDaoSupport {
	
	public TB_Work_Plan fnView(TB_Work_Plan vo) throws Exception {
		return getSqlSession().selectOne("xml-work-plan.list", vo);
	}
	
	public int fnCnt(TB_Work_Plan vo) throws Exception {
		return getSqlSession().selectOne("xml-work-plan.cnt", vo);
	}
	
	public int fnMax() throws Exception {
		return getSqlSession().selectOne("xml-work-plan.max");
	}

	public List<TB_Work_Plan> fnList(TB_Work_Plan vo) throws Exception {
		return getSqlSession().selectList("xml-work-plan.list", vo);
	}
	
	public List<TB_Work_Plan> fnListPrint(TB_Work_Plan vo) throws Exception {
		return getSqlSession().selectList("xml-work-plan.printlist", vo);
	}
	
	public int fnInsert(TB_Work_Plan vo) throws Exception {
		return getSqlSession().insert("xml-work-plan.insert", vo);
	}

	public int fnUpdate(TB_Work_Plan vo) throws Exception {
		return getSqlSession().update("xml-work-plan.update", vo);
	}

	public int fnDelete(TB_Work_Plan vo) throws Exception {
		return getSqlSession().delete("xml-work-plan.delete", vo);
	}
}