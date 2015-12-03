package com.utils;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.entity.*;


/**
 * Configures and provides access to Hibernate sessions, tied to the
 * current thread of execution.  Follows the Thread Local Session
 * pattern, see {@link http://hibernate.org/42.html }.
 */
public class HibernateUtils {

    /** 
     * Location of hibernate.cfg.xml file.
     * Location should be on the classpath as Hibernate uses  
     * #resourceAsStream style lookup for its configuration file. 
     * The default classpath location of the hibernate config file is 
     * in the default package. Use #setConfigFile() to update 
     * the location of the configuration file for the current session.   
     */
	private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static Session getSession(){
    	return sessionFactory.getCurrentSession();
    }
    public static void log(Object o,String action,Session s) throws HibernateException
    {
    	JSONArray jo=JSONArray.fromObject(o);
    	s.save(new Log(action,jo.toString(),o.getClass().getSimpleName()));
    }
    public static void addLog(String action,String detail,String cate)
    {
    	Session s=sessionFactory.getCurrentSession();
    	s.beginTransaction();
    	s.save(new Log(action,detail,cate));
    	try
    	{
    		s.getTransaction().commit();
    	}
    	catch(HibernateException e)
    	{
    		s.getTransaction().rollback();
    		e.printStackTrace();
    	}
    }
    public static boolean isAdmin(String username,String password)
    {
    	if(username==null||password==null) return false;
    	Admin ad=(Admin) load(username, Admin.class);
		if(ad==null||!ad.getPassword().equals(password)) return false;
		return true;
    }
    public static boolean save(Object o) 
    {
    	Session s=sessionFactory.getCurrentSession();
    	
    	try{
    		s.beginTransaction();
        	s.save(o);
        	log(o,"添加记录",s);
    		s.getTransaction().commit();
    	}  
    catch(HibernateException e) {
    	   //回滚事务
    	s.getTransaction().rollback();
    	e.printStackTrace();
    	   return false;
    }
    	return true;
    }
    public static boolean saveOrUpdate(Object o) 
    {
    	Session s=sessionFactory.getCurrentSession();
    	
    	try{
    		s.beginTransaction();
        	s.saveOrUpdate(o);
        	log(o,"添加或更新记录",s);
    		s.getTransaction().commit();
    	}  
    catch(HibernateException e) {
    	   //回滚事务
    	s.getTransaction().rollback();
    	e.printStackTrace();
    	   return false;
    }
    	return true;
    }
    public static boolean delete(Object o) 
    {
    	Session s=sessionFactory.getCurrentSession();
    	
    	try{
    		s.beginTransaction();
        	s.delete(o);
        	log(o,"删除记录",s);
    		s.getTransaction().commit();
    	}  
    catch(HibernateException e) {
    	   //回滚事务
    	   s.getTransaction().rollback();
    	   e.printStackTrace();
    	   return false;
    }
    	return true;
    }
   
    
    public static Object load(long id,Class cls)
    {
    	Session s=sessionFactory.getCurrentSession();
    	s.beginTransaction();
    	/*String hql="from "+clsName+" e where e.id=:myid";
    	Query q=s.createQuery(hql);
    	q.setInteger("myid",id);*/
    	Object o=s.get(cls, id);
    	s.getTransaction().commit();
    	return o;
    }
    public static Object load(String id,Class cls)
    {
    	Session s=sessionFactory.getCurrentSession();
    	s.beginTransaction();

    	Object o=s.get(cls, id);
    	
    	s.getTransaction().commit();
    	return o;
    }
   
   
    public static List query(String hql,Object[] params){
    	Session s=sessionFactory.getCurrentSession();
    	s.beginTransaction();
    	Query q=s.createQuery(hql);
    	if(params!=null)
    	  	for(int j=0;j<params.length;j++)
    	  		q.setParameter(j, params[j]);
    	List list=q.list();
    	s.getTransaction().commit();
      	return list;	  
    }
    public static List query(String hql)
    {
    	Session s=sessionFactory.getCurrentSession();
    	s.beginTransaction();
    	Query q=s.createQuery(hql);
    	List list=q.list();
    	s.getTransaction().commit();
      	return list;	
    }
    public static int getCount(String hql,Object[] params){
    	Session s=sessionFactory.getCurrentSession();
    	s.beginTransaction();
    	Query q=s.createQuery(hql);
    	if(params!=null)
    	  	for(int j=0;j<params.length;j++)
    	  		q.setParameter(j, params[j]);
    	int ret= ((Number) q.iterate().next())
    	         .intValue();;
    	s.getTransaction().commit();
      	return ret;	  
    }
    
    public static boolean update(String hql,Object[] p) 
    {
    	Session s=sessionFactory.getCurrentSession();
    	s.beginTransaction();
    	Query q=s.createQuery(hql);
    	if(p!=null)
    	for(int i=0;i<p.length;i++)
    		q.setParameter(i, p[i]);
    	q.executeUpdate();
    	try{
    		s.getTransaction().commit();
    	}  
    catch(HibernateException e) {
    	   //回滚事务
    	   s.getTransaction().rollback();
    	   return false;
    }
    	return true;
    }
    public static boolean update(Object o) 
    {
    	Session session = sessionFactory.getCurrentSession(); 
    	session.beginTransaction();
    	try{
    		session.update(o); 
    		log(o,"更改记录",session);
        	session.getTransaction().commit(); 
    	}
    	catch(HibernateException e)
    	{
    		session.getTransaction().rollback();
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
   

}