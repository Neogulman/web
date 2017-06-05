package com.neogul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.neogul.data.dto.TB_Wishlist;

@Repository @Lazy
public class Wishlist_Dao extends SqlSessionDaoSupport {
	
	public int fnCnt(TB_Wishlist vo) throws Exception {
		return getSqlSession().selectOne("xml-wishlist.cnt", vo);
	}

	public TB_Wishlist fnView(TB_Wishlist vo) throws Exception {
		return getSqlSession().selectOne("xml-wishlist.list", vo);
	}

	public List<TB_Wishlist> fnList(TB_Wishlist vo) throws Exception {
		return getSqlSession().selectList("xml-wishlist.list", vo);
	}

	public int fnUpdateStatus(TB_Wishlist vo) throws Exception {
		return getSqlSession().update("xml-wishlist.updateStatus", vo);
	}
	public int fnUpdateStatusAll() throws Exception {
		return getSqlSession().update("xml-wishlist.updateStatusAll");
	}
	public int fnUpdate(TB_Wishlist vo) throws Exception {
		return getSqlSession().update("xml-wishlist.update", vo);
	}
	
	public int fnUpdateNickName(TB_Wishlist vo) throws Exception {
		return getSqlSession().update("xml-wishlist.update-nick", vo);
	}
	
	public int fnInsert(TB_Wishlist vo) throws Exception {
		return getSqlSession().update("xml-wishlist.insert", vo);
	}
	
	public TB_Wishlist fnSelectOne(TB_Wishlist vo) throws Exception {
		return getSqlSession().selectOne("xml-wishlist.selectOne", vo);
	}

	public int fnDelete(TB_Wishlist vo) throws Exception {
		return getSqlSession().delete("xml-wishlist.delete", vo);
	}
}