package com.sym.interfacecode;

import com.sym.MyExceptions.InsufficientBalanceException;

public class SavingAccount implements IAccount {

	private double balance = 0;

	public double getBalance() {
		return balance;
	}

	@Override
	public void deposit(double amount) throws InsufficientBalanceException{
		balance += amount;
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {

		// minimum balance should be $300
		if (balance - amount >= 300) {
			balance -= amount;
		} else {
			// System.out.println("Insufficient amount for withdrawl");
			throw new InsufficientBalanceException("Insufficient amount for withdrawl");
		}
	}

	@Override
	public void printBalance() {
		System.out.println("Your current balance is: $" + balance);

	}

}
