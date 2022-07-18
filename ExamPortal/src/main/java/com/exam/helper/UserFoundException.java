package com.exam.helper;

public class UserFoundException extends Exception{
	public UserFoundException() {
		super("User with this UserName is already there in DB!!try with another");
		// TODO Auto-generated constructor stub
	}
public UserFoundException(String msg) {
	super(msg);
}
}
