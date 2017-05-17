package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Product;

@Repository @Lazy
public class Product_Dao extends SqlSessionDaoSupport {
	
	public int fnCnt(TB_Product vo) throws Exception {
		return getSqlSession().selectOne("xml-device-info.cnt", vo);
	}

	public TB_Product fnView(TB_Product vo) throws Exception {
		return getSqlSession().selectOne("xml-device-info.list", vo);
	}
	
	public List<TB_Product> fnMonitor(TB_Product vo) throws Exception {
		return getSqlSession().selectList("xml-device-info.monitor", vo);
	}
	
	public List<TB_Product> fnMonitor2(TB_Product vo) throws Exception {
		return getSqlSession().selectList("xml-device-info.monitor2", vo);
	}


	public List<TB_Product> fnList(TB_Product vo) throws Exception {
		return getSqlSession().selectList("xml-device-info.list", vo);
	}

	public int fnUpdateStatus(TB_Product vo) throws Exception {
		return getSqlSession().update("xml-device-info.updateStatus", vo);
	}
	public int fnUpdateStatusAll() throws Exception {
		return getSqlSession().update("xml-device-info.updateStatusAll");
	}
	public int fnUpdate(TB_Product vo) throws Exception {
		return getSqlSession().update("xml-device-info.update", vo);
	}
	
	public int fnUpdateNickName(TB_Product vo) throws Exception {
		return getSqlSession().update("xml-device-info.update-nick", vo);
	}
	
	public int fnInsert(TB_Product vo) throws Exception {
		return getSqlSession().update("xml-device-info.insert", vo);
	}
	
	public TB_Product fnSelectOne(TB_Product vo) throws Exception {
		return getSqlSession().selectOne("xml-device-info.selectOne", vo);
	}

	public int fnDelete(TB_Product vo) throws Exception {
		return getSqlSession().delete("xml-device-info.delete", vo);
	}
}