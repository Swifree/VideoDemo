package com.action;


import com.entity.Admin;
import com.utils.HibernateUtils;

public class AdminAction extends BaseAction<Admin>{
	public String login()
	{
		System.out.println(entity.getUsername());
		if(HibernateUtils.isAdmin(entity.getUsername(), entity.getPassword())){
			msg="登陆成功";
			request.getSession().setAttribute("username", entity.getUsername());
			request.getSession().setAttribute("password", entity.getPassword());
		}
		else msg="用户名或密码错误";
		
		return SUCCESS;
	}

}
