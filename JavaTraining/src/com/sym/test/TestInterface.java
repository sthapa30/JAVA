package com.sym.test;

import com.sym.MyExceptions.InsufficientBalanceException;
import com.sym.interfacecode.CurrentAccount;
import com.sym.interfacecode.IAccount;
import com.sym.interfacecode.SavingAccount;

public class TestInterface {

	public static void main(String[] args) {
		IAccount currentAccount = new CurrentAccount();
		try {
			currentAccount.deposit(0);
			currentAccount.printBalance();
			currentAccount.withdraw(20);
			currentAccount.printBalance();

		} catch (InsufficientBalanceException e) {
			System.out.println(e.getErrorMessage());
			e.printStackTrace();
		}

		// Better use create object like this
		// because it allows to use Class methods too
		// e.d getBalance() method
		SavingAccount savingAccount = new SavingAccount();
		try {
			savingAccount.deposit(3000);
			savingAccount.printBalance();
			savingAccount.withdraw(2100);
			savingAccount.printBalance();
			savingAccount.withdraw(10000);

		} catch (InsufficientBalanceException e) {
			System.out.println(e.getErrorMessage());
		}

		System.out.println("My saving is " + savingAccount.getBalance());

	}

}
