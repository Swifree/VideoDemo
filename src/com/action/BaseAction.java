package com.action;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.utils.HibernateUtils;


public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	  
      protected   T entity=getInstance();
      protected String msg;
      protected HttpServletResponse response=ServletActionContext.getResponse();
      protected HttpServletRequest  request=ServletActionContext.getRequest();
      {
    	  response.setCharacterEncoding("UTF-8");
      }
      public String add() {
    	msg="添加成功";
       if(!HibernateUtils.save(entity))
       	msg="添加失败";
       try {
		response.getWriter().println(msg);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       return null;
      }
      
      public String  delete() 
      {
    	  msg="删除成功";
    	if(!HibernateUtils.delete(entity))
    	 msg="删除失败";
    	  try {
			response.getWriter().println(msg);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return null;
      }
      public String addOrUpdate() {
      	msg="添加或更新成功";
         if(!HibernateUtils.saveOrUpdate(entity))
         	msg="添加或更新失败";
         try {
  		response.getWriter().println(msg);
  	} catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
         return null;
        }
      public String update()
      {
    	  msg="添加或更新成功";
          if(!HibernateUtils.update(entity))
          	msg="添加或更新失败";
          try {
   		response.getWriter().println(msg);
   	} catch (IOException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
      }
          return null;
      }
     public  T getInstance() 
     {
    	 T t=null;
    	 Type genType = getClass().getGenericSuperclass();
 		 Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
 		 Class<T> entityClass = (Class) params[0];
 		 System.out.println(entityClass.getName());
 		 try {
			t=entityClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		 return t;
     }
     
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return entity;
	}
         
}
