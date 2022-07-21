package com.varxyz.banking.domain2;

import java.util.*;

import com.varxyz.banking.domain.Account;

public class Customer {
	protected String name; // 이름
	protected String ssn; // 주민번호
	protected String phone; // 연락처
	protected String coustomerId; // 고객아이디
	protected String passwd; // 비밀번호
	List<Account> list = new ArrayList<Account>(); // 보유계좌

	public Customer(String name, String ssn, String phone, String coustomerId, String passwd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.coustomerId = coustomerId;
		this.passwd = passwd;
	}
	
}