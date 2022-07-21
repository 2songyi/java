package com.varxyz.jv251.domain;

import java.util.List;

public class Customer {
	private long cid;
	protected String name; // 이름
	protected String ssn; // 주민번호
	protected String phone; // 연락처
	protected String userId; // 고객아이디
	protected String passwd; // 비밀번호
	private List<Account> accountList;

	public Customer() {

	}

	public Customer(long cid) {
		this.cid = cid;
	}

	public Customer(String name, String ssn, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}

	public Customer(String name, String ssn, String phone, String userId, String passwd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = userId;
		this.passwd = passwd;
	}


	@Override
	public String toString() {
		return cid + ", " + name + ", " + ssn + ", " + phone + ", " + userId + ", " + passwd;
	}

//	@Override
//	public String toString() {
//		return "Customer [cid=" + cid + ", name=" + name + ", ssn=" + ssn + ", phone=" + phone + ", userId=" + userId
//				+ ", passwd=" + passwd + ", accountList=" + accountList + "]";
//	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

}
