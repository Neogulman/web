/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.neogul.ui.view.crud;

//import javax.transaction.Transactional;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.neogul.data.dao.ProductRepository;
import com.neogul.data.dto.Product;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.spring.annotation.UIScope;

/**
 * Basic Container implementation. Reads data from the database using spring data and
 * keeps all the changes in memory after that.
 *
 * @author Vaadin Ltd
 */
@Component
@UIScope
@Transactional
public class ProductContainerImpl extends BeanContainer<Integer, Product> implements ProductContainer {

    @Autowired
    private ProductRepository productRepository;

    public ProductContainerImpl() throws IllegalArgumentException {
        super(Product.class);
        setBeanIdProperty("id");
    }

    @PostConstruct
    public void init() {
        List<Product> all = null;
		try {
			all = productRepository.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(all != null){
			addAll(all);
		}
    }
}
