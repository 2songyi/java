package com.varxyz.banking.domain;

import java.util.*;

public interface AccountService {
	Account createSavingAccount(String accountNum, double balance, double interestRate);
	Account createCheckingAccount(String accountNum, double balance, double overdraftAmount);
	Collection<Account> getAccountBySsn(String ssn);
	Account getAccountByAccountNum(String accountNum);
	
}
