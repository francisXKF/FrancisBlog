package com.francis.blog.util;

import java.lang.reflect.Field;

public class GetClassFieldName {
	public String[] getFieldName(Object obj){
		Field[] fields = obj.getClass().getDeclaredFields();  
		String[] fieldNames = new String[fields.length];    
		for (int i=0; i < fields.length; i++)  
		{    
		    fieldNames[i] = fields[i].getName();    
		}    
		return fieldNames;
	}
}
