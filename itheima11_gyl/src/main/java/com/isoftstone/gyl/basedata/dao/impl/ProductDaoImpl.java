package com.isoftstone.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.isoftstone.gyl.base.dao.impl.BaseDaoImpl;
import com.isoftstone.gyl.basedata.dao.ProductDao;
import com.isoftstone.gyl.domain.basedata.Product;

@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

}
