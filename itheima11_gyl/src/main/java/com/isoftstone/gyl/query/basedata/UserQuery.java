package com.isoftstone.gyl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.isoftstone.gyl.query.BaseQuery;

public class UserQuery extends BaseQuery{
	private String username;
	private String age;
	private Long did;
	private String sex;

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public Long getDid() {
		return did;
	}



	public void setDid(Long did) {
		this.did = did;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	@Override
	public Map<String, Object> buildWhere() {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(this.username)){//name属性的值不为空
			this.getKeyValues().put("username", this.username);
		}
		if(StringUtils.isNotBlank(this.age)){//description属性的值不为空
			this.getKeyValues().put("age", this.age);
		}
		if(!(this.did==null))
		{
			this.getKeyValues().put("did", this.did);
		}
		if(StringUtils.isNotBlank(this.sex))
		{
			this.getKeyValues().put("sex", this.sex);
		}
			
		return this.getKeyValues();
	}
		
}


