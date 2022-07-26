package com.varxyz.jvx330pj.adduser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
	private String userId;
	private String passwd;
	private String userName;
	private String ssn;
	private String email;
	private String addr;
}
