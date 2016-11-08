package com.isoftstone.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.base.service.impl.BaseServiceImpl;
import com.isoftstone.gyl.basedata.dao.ProductDao;
import com.isoftstone.gyl.basedata.service.ProductService;
import com.isoftstone.gyl.domain.basedata.Product;

@Repository("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{

	@Resource(name="productDao")
	private ProductDao productDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.productDao;
	}

}
