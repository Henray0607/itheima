package com.isoftstone.gyl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.isoftstone.gyl.query.BaseQuery;

public class ProductQuery extends BaseQuery{

	private String spmc; //商品名称
	private String xh;//型号
	private String spbm;//商品编码
	private Double shulv;//税率

	public String getSpmc() {
		return spmc;
	}




	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}




	public String getXh() {
		return xh;
	}




	public void setXh(String xh) {
		this.xh = xh;
	}




	public String getSpbm() {
		return spbm;
	}




	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}




	public Double getShulv() {
		return shulv;
	}




	public void setShulv(Double shulv) {
		this.shulv = shulv;
	}




	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(this.spbm)){//name属性的值不为空
			this.getKeyValues().put("spbm", this.spbm);
		}
		if(StringUtils.isNotBlank(this.spmc)){//name属性的值不为空
			this.getKeyValues().put("spmc", this.spmc);
		}
		if(StringUtils.isNotBlank(this.xh)){//name属性的值不为空
			this.getKeyValues().put("xh", this.xh);
		}
		return this.getKeyValues();
	}

}
