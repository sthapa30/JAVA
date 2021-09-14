package com.sym.interfacecode;

import com.sym.MyExceptions.InsufficientBalanceException;

public class CurrentAccount implements IAccount {

	private double balance;

	public double getBalance() {
		return balance;
	}

	@Override
	public void deposit(double amount) throws InsufficientBalanceException {
		try {
			balance += amount;
		} catch (NullPointerException e) {
			throw new InsufficientBalanceException("Amount cannot be null");
		}

	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (balance - amount >= 0) {
			balance -= amount;
		} else {
			//System.out.println("Insufficient amount for withdraw");
			throw new InsufficientBalanceException("Insufficient balance");
		}
	}

	@Override
	public void printBalance() {
		System.out.println("Your current balance is: $" + balance);

	}

}
