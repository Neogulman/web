package com.joheul.data.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.TB_Operation_Movie;

@Repository @Lazy
public class Operation_Movie_Dao extends SqlSessionDaoSupport {
	/*
	 * v2.0 movie.log.do
	 */
	public int fnMovieLogCnt(TB_Operation_Movie vo) throws Exception {
		return getSqlSession().selectOne("xml-operation-movie.movie-log-cnt", vo);
	}
	public List<TB_Operation_Movie> fnMovieLog(TB_Operation_Movie vo) throws Exception {
		return getSqlSession().selectList("xml-operation-movie.movie-log", vo);
	}
}