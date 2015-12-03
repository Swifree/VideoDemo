package com.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.ToStringBuilder;


@MappedSuperclass  
public class Record implements Serializable{
	private static final long serialVersionUID = 1L;
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
