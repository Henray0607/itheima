package com.isoftstone.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.isoftstone.gyl.base.dao.impl.BaseDaoImpl;
import com.isoftstone.gyl.basedata.dao.DepartmentDao;
import com.isoftstone.gyl.domain.basedata.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

}
