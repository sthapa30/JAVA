package com.sym.interfacecode;

import com.sym.MyExceptions.InsufficientBalanceException;

public interface IAccount {

	public void deposit(double amount) throws InsufficientBalanceException;

	public void withdraw(double amount) throws InsufficientBalanceException;
	
	public void printBalance();

}
