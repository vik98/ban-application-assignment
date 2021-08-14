package com.bank.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.bank.entity.Customer;
import com.bank.exceptions.InvalidCredentialException;
import com.bank.exceptions.NoSuchCustomer;

public class LoginService {
	private Map<Integer, Customer > loginCreds;
	
	public LoginService() {
		this.loginCreds = new HashMap<Integer, Customer>();
	}
	
	public void addNewCustomer(Customer customer) {
		if(customer==null) {
			throw new NoSuchCustomer();
		}
		this.loginCreds.put(customer.bankAccountNumber, customer);
	}
	
	public boolean verifyCustomer(Integer bankAccountNumber, String password) {
		
		if(!loginCreds.containsKey(bankAccountNumber)) {
			throw new InvalidCredentialException();
		}
		Customer customerInDB= loginCreds.get(bankAccountNumber);
		if(customerInDB.password.equals(password)) {
			return true;
		}else {
			throw new InvalidCredentialException();
		}
	}
	
	public Customer getCustomer(Integer bankAccountNumber) {
		if(!loginCreds.containsKey(bankAccountNumber)) {
			throw new InvalidCredentialException();
		}
		return loginCreds.get(bankAccountNumber);
	}
	
	public void updateCustomer(Integer bankAccountNumber, Customer customer) {
		loginCreds.put(bankAccountNumber,customer);
	}
	
	public void printAllCustomers() {
		for(Map.Entry<Integer, Customer> entry: loginCreds.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
	
}
