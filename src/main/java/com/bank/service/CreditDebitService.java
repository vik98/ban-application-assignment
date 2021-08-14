package com.bank.service;

import com.bank.entity.Customer;

public class CreditDebitService {
	public void depositAmount(Customer customer, int amount) {
		customer.amount = customer.amount + amount;
	}
	
	public void withdrawAmount(Customer customer, int amount) {
		customer.amount = customer.amount - amount;

	}
}
