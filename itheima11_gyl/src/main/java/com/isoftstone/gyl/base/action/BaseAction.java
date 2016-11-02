package com.isoftstone.gyl.base.action;

import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {

	private Class classt;
	private T t;

	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		this.classt = (Class) type.getActualTypeArguments()[0];
		try {
			this.t = (T) classt.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public T getModel() {

		return this.t;
	}

	public static final String ADDUI = "addUI";
	public String addUI = ADDUI;

	public static final String UPDATEUI = "updateUI";
	public String update = UPDATEUI;

	public static final String LISTACTION = "listAction";
	public String listAction = LISTACTION;

	public static final String ACTION2ACTION = "action2action";
	public String action2action = LISTACTION;

	/**
	 * 获取httpsession
	 * */
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
}
