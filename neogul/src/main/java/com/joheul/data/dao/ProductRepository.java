package com.joheul.data.dao;

import java.util.Collection;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.joheul.data.dto.Category;
import com.joheul.data.dto.Product;

@Repository @Lazy
public class ProductRepository extends SqlSessionDaoSupport {

	public List<Product> findAll() throws Exception{
		Product vo = new Product();
		return getSqlSession().selectList("xml-product.findAll", vo);
	}

	public Collection<Category> getAllCategories() throws Exception{
		Category vo = new Category();
		return getSqlSession().selectList("xml-product.getAllCategories", vo);
	}

	public Product getProduct(int productId) throws Exception{
		Product vo = new Product();
		vo.setId(productId);
		return getSqlSession().selectOne("xml-product.getProduct", vo);
	}

	public void deleteProduct(int id) throws Exception{
		Product vo = new Product();
		vo.setId(id);
		getSqlSession().delete("xml-product.deleteProduct", vo);
	}

}
