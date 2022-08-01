package com.varxyz.jvx330.mvc.example6;

import com.varxyz.jvx330.mvc.example5.CustomerCommand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountCommand {

	private CustomerCommand customer;
	private String accType;
	private int passwd;
	
	public AccountCommand() {
		
	}
}
