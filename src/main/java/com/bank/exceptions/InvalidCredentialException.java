package com.bank.exceptions;

public class InvalidCredentialException extends RuntimeException{
	public InvalidCredentialException() {
		super("This credentials provided are incorrect");
	}
}
