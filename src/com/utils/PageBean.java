package com.utils;

import java.util.List;

public class PageBean {
	private int total, mxpg,pg;
	private List list;

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	
	/**
	 * @return the mxpg
	 */
	public int getMxpg() {
		return mxpg;
	}
	/**
	 * @param mxpg the mxpg to set
	 */
	public void setMxpg(int mxpg) {
		this.mxpg = mxpg;
	}
	
	
	/**
	 * @return the pg
	 */
	public int getPg() {
		return pg;
	}
	/**
	 * @param pg the pg to set
	 */
	public void setPg(int pg) {
		this.pg = pg;
	}
	public List getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List list) {
		this.list = list;
	}
	public  int getIndex(int pg)
	{
		if(pg<1) pg=1;
		if(pg>mxpg) pg=mxpg;
		return pg;
	}
	public PageBean(){}
	public PageBean(int t,int m,int p,List l){
		total=t;
		mxpg=m;
		pg=p;
		list=l;
	}
	public String getFirstPage(String uri,String []names,String []params)
	{
		uri+="?";
		for(int i=0;i<names.length;i++)
			if(params[i]!=null)
				uri+=names[i]+"="+params[i]+"&";
		return uri;
	}
	public String getPrePage(String uri,String []names,String []params)
	{
		uri+="?";
		for(int i=0;i<names.length;i++)
			if(params[i]!=null)
				uri+=names[i]+"="+params[i]+"&";
		return uri+"pg="+getIndex(pg-1);
	}
	public String getNextPage(String uri,String []names,String []params)
	{
		uri+="?";
		for(int i=0;i<names.length;i++)
			if(params[i]!=null)
				uri+=names[i]+"="+params[i]+"&";
		return uri+"pg="+getIndex(pg+1);
	}
	public String getLastPage(String uri,String []names,String []params)
	{
		uri+="?";
		for(int i=0;i<names.length;i++)
			if(params[i]!=null)
				uri+=names[i]+"="+params[i]+"&";
		return uri+"pg="+mxpg;
	}
	
}
