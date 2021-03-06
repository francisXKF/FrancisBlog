package com.francis.blog.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.francis.blog.pojo.ArticleType;
import com.francis.blog.pojo.TagsType;
import com.francis.blog.pojo.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * 解决JSONObject.fromObject抛出"There is a cycle in the hierarchy"异常导致死循环的解决办法
 * @author http://www.tuicool.com/articles/mqmeQb
 */
public class ObjectJsonValueProcessor implements JsonValueProcessor {
	
	/**
	 * 需要留下的字段数组
	 */
	private String[] properties;
	
	/**
	 * 需要做处理的复杂属性类型
	 */
	private Class<?> clazz;
	
	/**
	 * 构造方法,参数必须
	 * @param properties
	 * @param clazz
	 */
	public ObjectJsonValueProcessor(String[] properties,Class<?> clazz){
		this.properties = properties;
		this.clazz =clazz;
	}

	@Override
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		PropertyDescriptor pd = null;  
		Method method = null;  
		StringBuffer json = new StringBuffer("{");  
		try{
			for(int i=0;i<properties.length;i++){
				pd = new PropertyDescriptor(properties[i], clazz);
				method = pd.getReadMethod();
				Object obj = method.invoke(value);
				String v = String.valueOf(method.invoke(value));
				//System.out.println(v + "  one ......................................."+obj.getClass()+".............................................");

				if(obj instanceof ArticleType){
					v = ((ArticleType) obj).getName();
				}
				//该方法有错，不能处理set类型的tagstype
				if(obj instanceof org.hibernate.collection.internal.PersistentSet){
					Set<TagsType> tagsTypes = (Set<TagsType>)obj;
					List<String> tagsNameList = new ArrayList<String>();
					Iterator<TagsType> iterator = tagsTypes.iterator();
					while(iterator.hasNext()){
						tagsNameList.add(iterator.next().getName());
					}
					String tagsNameJSONModel = JSONArray.fromObject(tagsNameList).toString();

					json.append("'"+properties[i]+"':'"+tagsNameJSONModel+"'");
					json.append(i != properties.length-1?",":"");
					continue;				}
				if(obj instanceof HashSet){
					Set<TagsType> tagsTypes = (Set<TagsType>)obj;
					List<String> tagsNameList = new ArrayList<String>();
					Iterator<TagsType> iterator = tagsTypes.iterator();
					while(iterator.hasNext()){
						tagsNameList.add(iterator.next().getName());
					}
					String tagsNameJSONModel = JSONArray.fromObject(tagsNameList).toString();
			
					json.append("'"+properties[i]+"':'"+tagsNameJSONModel+"'");
					json.append(i != properties.length-1?",":"");
					continue;
				}
				if(obj instanceof User){
					v = ((User) obj).getName();
				}
				json.append("'"+properties[i]+"':'"+v+"'");
				json.append(i != properties.length-1?",":"");
				}
			json.append("}");
			}
		catch (Exception e) {
			e.printStackTrace();
			}
		return JSONObject.fromObject(json.toString());  
	}

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		PropertyDescriptor pd = null;
		Method method = null;
		StringBuffer json = new StringBuffer("{");
		try{
			for(int i=0;i<properties.length;i++){
				pd = new PropertyDescriptor(properties[i], clazz);
				method = pd.getReadMethod();
				String v = String.valueOf(method.invoke(value));
				json.append("'"+properties[i]+"':'"+v+"'");
				json.append(i != properties.length-1?",":"");
			}
			json.append("}");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return JSONObject.fromObject(json.toString());
	}
	
	
}
