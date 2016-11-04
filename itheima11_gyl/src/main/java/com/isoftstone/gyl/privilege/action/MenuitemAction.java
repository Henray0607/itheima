package com.isoftstone.gyl.privilege.action;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.domain.privilege.Menuitem;
import com.isoftstone.gyl.privilege.service.MenuitemService;
import com.opensymphony.xwork2.ActionContext;

@Controller("menuitemAction")
public class MenuitemAction extends BaseAction<Menuitem>{
	
	@Resource(name="menuitemService")
	private MenuitemService menuitemService;
	
	public String showMenuitemTree(){
	Collection<Menuitem> menuitems = this.menuitemService.getEntities();
	for (Menuitem menuitem : menuitems) {
		System.out.println(menuitem.getName());
		}
	ActionContext.getContext().getValueStack().push(menuitems);
	return SUCCESS;
	}
	

}
