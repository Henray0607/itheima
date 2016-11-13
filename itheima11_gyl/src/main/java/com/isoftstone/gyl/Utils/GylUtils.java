package com.isoftstone.gyl.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class GylUtils {

	public String getDdh(String type){
		SimpleDateFormat df = new SimpleDateFormat("MMddHH");//设置日期格式
		return type+df.format(new Date());// new Date()为获取当前系统时间
	}
	@Test
	public void Test(){
		System.out.println(new GylUtils().getDdh(XsglFenLei.XSYDD));
	}
	
}
