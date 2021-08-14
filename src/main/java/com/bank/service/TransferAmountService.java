package com.bank.service;

import com.bank.entity.Customer;

public class TransferAmountService {
	public void transfer(Customer sender, Customer beneficiary, int amount) {
		beneficiary.amount = beneficiary.amount + amount;
		sender.amount = sender.amount - amount;
	}
}
