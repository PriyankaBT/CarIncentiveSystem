package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Car_Admin")
public class CarAdmin {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMIN_SEQ")
	@SequenceGenerator(sequenceName = "companyId_seq", allocationSize = 1, name = "ADMIN_SEQ")
	
	private int companyId;
	private String userName;
	private String mailId;
	private Long contactNo;
	private String password;

	public CarAdmin() {

	}

	public CarAdmin(int companyId, String userName, String mailId, Long contactNo, String password) {
		super();
		this.companyId = companyId;
		this.userName = userName;
		this.mailId = mailId;
		this.contactNo = contactNo;
		this.password = password;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CarAdmin [companyId=" + companyId + ", userName=" + userName + ", mailId=" + mailId + ", contactNo="
				+ contactNo + ", password=" + password + "]";
	}

	
}