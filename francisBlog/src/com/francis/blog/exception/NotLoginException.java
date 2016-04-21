package com.francis.blog.exception;

public class NotLoginException extends RuntimeException{
	public NotLoginException(String errorMsg){
		super(errorMsg);
	}
}
