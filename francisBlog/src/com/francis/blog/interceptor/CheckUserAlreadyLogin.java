package com.francis.blog.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.francis.blog.exception.NotLoginException;
import com.francis.blog.pojo.User;
import com.francis.blog.util.QueryConstent;

@Aspect
@Component
public class CheckUserAlreadyLogin {
	@Pointcut("execution(public * com.francis.blog.serviceImpl.ArticleManagerImpl.insert(..))")
	public void checkMethod(){}
	
	@Before("checkMethod()")
	public void checkBefore(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User)session.getAttribute("login_user");
		if(user == null || user.getIdentity() < QueryConstent.ADMIN){
			String errorMsg = "未登录。或者...登录超时。";
			throw new NotLoginException(errorMsg);
		}
	}
}
