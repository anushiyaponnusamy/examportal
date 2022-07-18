package com.exam.helper;

public class UserNotFoundException extends Exception{

	public UserNotFoundException() {
		super("User with this UserName not found in DB!!");
		// TODO Auto-generated constructor stub
	}
public UserNotFoundException(String msg) {
	super(msg);
}
}
