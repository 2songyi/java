package com.varxyz.jv250.banking;

import java.util.List;

import com.google.protobuf.Timestamp;

public class Customer {
	private long cid;
	protected String name; // 이름
	protected String ssn; // 주민번호
	protected String phone; // 연락처
	protected String customerId; // 고객아이디
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

	public Customer(String name, String ssn, String phone, String customerId, String passwd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.customerId = customerId;
		this.passwd = passwd;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return cid + ", " + name + ", " + ssn + ", " + phone + ", " + customerId + ", " + passwd;
	}

}
