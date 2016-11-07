package com.isoftstone.gyl.basedata.action;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.isoftstone.gyl.base.action.BaseAction;
import com.isoftstone.gyl.basedata.service.UserService;
import com.isoftstone.gyl.domain.basedata.User;
import com.isoftstone.gyl.query.PageResult;
import com.isoftstone.gyl.query.basedata.UserQuery;
import com.opensymphony.xwork2.ActionContext;

@Controller("userAction")
@Scope("prototype")
public class UserAciton extends BaseAction<User>{

	@Resource(name="userService")
	private UserService userService;
	
	private UserQuery userQuery = new UserQuery();
	
	public String showPageResult(){
		this.userQuery.setCurrentPage(super.getCurrentPage());
		PageResult<User> userList = this.userService.getPageResult(userQuery);
		List<User> users= userList.getRows();
		ActionContext.getContext().put("users", userList);
		for (User user : users) {
			
			System.out.println(user.getUsername());
		}
		return LISTACTION;
	}
	
	
	
	
}
