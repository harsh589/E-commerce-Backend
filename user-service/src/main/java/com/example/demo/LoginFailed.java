package com.example.demo;

public class LoginFailed extends RuntimeException {
public LoginFailed(String message) {
	super( message);
}
}
