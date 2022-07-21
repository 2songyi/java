package com.varxyz.jv251.service;

import java.util.List;
import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.execption.CustomerNotFoundException;

public class BankServiceTest {
	public static void main(String[] args) {
		// 하나씩 객체를 생성하지 않고 정보만 넘기면 알아서 정보입력, 계좌생성 알아서 됨
		
		BankService service = BankService.getInstance();
		String name = "나나";
		String ssn = "800123-1234568";
		String phone = "010-8777-7800";
		String userId = "framew";
		String passwd = "fram12";
		
//		// 1. 신규 고객 등록
//		service.addCustomer(name, ssn, phone, userId, passwd);
		
//		try {
//			// 2. SavingAccount 생성
//			service.addSavingAccount(7000.0, 0.4, ssn);
//		} catch (CustomerNotFoundException e) {
//			e.printStackTrace();
//		}
////		 3. 고객 등록 확인
//		Customer customer = service.getCustomerBySsn(ssn);
//		System.out.println(customer);
//		
////		이거로딩..? / 레이지로딩
//		for (Account account : customer.getAccountList()) { 
//		System.out.println(account);
//		}
//		nullpointerror뜸 -> 쿼리문에 account를 innerjoin해서 account정보도 같이 가져올 수 있다.
		
		// 4. 고객 계좌 목록 확인
//		List<Account> myList = service.getAccountsBySsn(ssn);
//		for (Account account : myList) {
//			System.out.println(account);
//		}
		
		Account account = service.getAccount("740-04-1524");
		System.out.println(account);
		double a = service.deposite(1550, account);
		account.setBalance(a);
		System.out.println(account);
		
	}
}
