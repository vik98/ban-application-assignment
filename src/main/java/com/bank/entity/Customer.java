package com.bank.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	public Integer bankAccountNumber;
	public String password;
	public String firstName;
	public String lastName;
	public Integer amount;
	public List<Transaction> listOfTransactions;
	
	public Customer() {
		firstName = "";
		lastName = "";
		listOfTransactions = new ArrayList<Transaction>();
	}
	
	public Customer(Integer amount) {
		this();
		this.amount = amount;
	}
	
	public Customer(Integer bankAccountNumber, String password, Integer amount) {
		this();
		this.bankAccountNumber = bankAccountNumber;
		this.password = password;
		this.amount = amount;
	}
	
	public Customer(Integer bankAccountNumber, String password) {
		this(10000);
		this.bankAccountNumber = bankAccountNumber;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Customer Bank Account Number " + bankAccountNumber + " Amount " + amount;
	}
	
}
