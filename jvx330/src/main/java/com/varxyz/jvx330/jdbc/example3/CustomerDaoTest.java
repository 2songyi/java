package com.varxyz.jvx330.jdbc.example3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class CustomerDaoTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		CustomerDao dao = context.getBean("customerDao", CustomerDao.class);
//		findAllCustomers(dao);
//		findCustomerByRegDate(dao);
//		findCustomerByEmail(dao);
//		countCustomers(dao);
		findCustomerBySsn(dao);
		
		
		context.close();
	}
	
	// find all customer test
	public static void findAllCustomers(CustomerDao dao) {
		System.out.println("[findAllCustomers()]");
		dao.findAllCustomers().forEach(c -> System.out.println(c));;
	}
	
	//regDate Test
	public static void findCustomerByRegDate(CustomerDao dao){
		System.out.println("findCustomerByRegDate");
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = null;
		try {
			currentDate = format.parse(format.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		dao.findCustomerByRegDate(currentDate).forEach(c -> System.out.println(c));
	}
	
	//find email Test
	public static void findCustomerByEmail(CustomerDao dao) {
		System.out.println("findCustomerByEmail");
		System.out.println(dao.findCustomerByEmail("song2@naver.com"));;
	}
	
	// count test
	public static void countCustomers(CustomerDao dao) {
		System.out.println("countCustomers");
		System.out.println(dao.countCustomers());
	}
	
	// find by ssn
	public static void findCustomerBySsn(CustomerDao dao) {
		System.out.println("findCustomerBySsn");
		System.out.println(dao.findCustomerBySsn("222222-2222222"));
	}
}
