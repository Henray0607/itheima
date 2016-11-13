package com.isoftstone.gyl.business.xsgl.service;

import org.springframework.transaction.annotation.Transactional;

import com.isoftstone.gyl.business.base.service.BaseBusinessService;
import com.isoftstone.gyl.domain.business.xsgl.Xsyddzhib;
import com.isoftstone.gyl.domain.business.xsgl.Xsyddzhub;

public interface XsyddService extends BaseBusinessService<Xsyddzhub, Xsyddzhib>{

	public void addXsydd(Xsyddzhub xsyddzhub);
		
}
