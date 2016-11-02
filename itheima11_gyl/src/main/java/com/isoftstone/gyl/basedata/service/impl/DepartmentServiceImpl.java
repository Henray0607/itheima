package com.isoftstone.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.isoftstone.gyl.base.dao.BaseDao;
import com.isoftstone.gyl.base.service.impl.BaseServiceImpl;
import com.isoftstone.gyl.basedata.dao.DepartmentDao;
import com.isoftstone.gyl.basedata.service.DepartmentService;
import com.isoftstone.gyl.domain.basedata.Department;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService {

	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.departmentDao;
	}

}
