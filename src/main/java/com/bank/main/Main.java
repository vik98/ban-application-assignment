package com.bank.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.entity.Customer;
import com.bank.service.CreditDebitService;
import com.bank.service.GenerateOTPService;
import com.bank.service.LoginService;
import com.bank.service.TransferAmountService;

public class Main {
	final static LoginService loginService = new LoginService();
	final static Scanner sc = new Scanner(System.in);
	final static CreditDebitService creditDebitService = new CreditDebitService();
	final static GenerateOTPService otpService = new GenerateOTPService();
	final static TransferAmountService transferAmountService = new TransferAmountService();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Projects\\eclipse-workspace\\bank-application\\transaction.txt", true));
	    writer.append("Start of the file:");
	    writer.newLine();
		Customer customer1 = new Customer(12345, "asdfg", 10000);
		loginService.addNewCustomer(customer1);
		
		Customer customer2 = new Customer(1234, "asdfg", 100);
		loginService.addNewCustomer(customer2);
		
		System.out.println("Enter the bank account number");
		Integer bankAccountNumber = sc.nextInt();
		System.out.println("Enter the password");
		String password = sc.next();
		
		if(checkCredentials(bankAccountNumber, password)) {
			Customer currentCustomer = loginService.getCustomer(bankAccountNumber);
			boolean check =false;
			do {
				
				printMenu();
				int option = sc.nextInt();
				
				switch(option) {
				case 1:
					System.out.println("Enter amount to Deposit");
					int amount = sc.nextInt();
					creditDebitService.depositAmount(currentCustomer, amount);
					writer.append(amount + " deposited to " + currentCustomer.bankAccountNumber);
					writer.newLine();
					break;
				case 2:
					System.out.println("Enter amount to withdraw");
					int amount1 = sc.nextInt();
					creditDebitService.withdrawAmount(currentCustomer, amount1);
					writer.append(amount1 + " withdrawn from " + currentCustomer.bankAccountNumber);
					writer.newLine();
					break;
				case 3:
					int otp = otpService.getOTP();
					System.out.println("Generated OTP" +  otp);
					System.out.println("Enter OTP");
					int enteredOTP = sc.nextInt();
					if(otp!=enteredOTP) {
						System.out.println("Incorrect OTP, Try again later");
					}else {
						System.out.println("Enter beneficiary bankaccount number");
						int beneficiaryBankAccountNumber = sc.nextInt();
						System.out.println("Enter Amount to be transferred");
						int transferAmount = sc.nextInt();
						Customer beneficiary = loginService.getCustomer(beneficiaryBankAccountNumber);
						transferAmountService.transfer(currentCustomer, beneficiary, transferAmount);
						writer.append(transferAmount + " transferred from " + currentCustomer.bankAccountNumber + " to " + beneficiaryBankAccountNumber);
						writer.newLine();
					}	
					break;
				case 4:
					check=true;
					break;
				}
			}while(!check);
			
			loginService.printAllCustomers();
			
			writer.close();
		}
		
	}

	public static boolean checkCredentials(Integer bankAccountNumber, String password) {
		return loginService.verifyCustomer(bankAccountNumber,password);
	}
	
	public static void printMenu() {
		System.out.println("Enter the operation you want to execute");
		System.out.println("1. Deposit");
		System.out.println("2. Withdrawal");
		System.out.println("3. Transfer");
		System.out.println("4. Logout");
	}
	
}
