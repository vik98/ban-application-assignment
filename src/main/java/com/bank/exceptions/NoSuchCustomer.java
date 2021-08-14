package com.bank.exceptions;

public class NoSuchCustomer extends RuntimeException{
	public NoSuchCustomer(){
		super("No such customer found");
	}
}
