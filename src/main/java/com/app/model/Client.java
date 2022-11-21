 package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan_client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clientId;
	
	private String applicationNumber;
	
	private String clientFullName;
	
	private String email;
	
	private long contactNumber;
	
	private String address;
	
	private String loanType;
	
	private long annualIncome;
	
	private long loanAmount;
	
	private int installments;
	
	private String previousLoans;
	
	private String image;
	
	private int credit;
	
	private String status = "pending";
	
	

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public int getCredit() {
		return credit;
	}


	public void setCredit(int credit) {
		this.credit = credit;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getClientFullName() {
		return clientFullName;
	}

	public void setClientFullName(String clientFullName) {
		this.clientFullName = clientFullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getInstallments() {
		return installments;
	}

	public void setInstallments(int installments) {
		this.installments = installments;
	}

	public String getPreviousLoans() {
		return previousLoans;
	}

	public void setPreviousLoans(String previousLoans) {
		this.previousLoans = previousLoans;
	}



	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", applicationNumber=" + applicationNumber + ", clientFullName="
				+ clientFullName + ", email=" + email + ", contactNumber=" + contactNumber + ", address=" + address
				+ ", loanType=" + loanType + ", annualIncome=" + annualIncome + ", loanAmount=" + loanAmount
				+ ", installments=" + installments + ", previousLoans=" + previousLoans + ", image=" + image
				+ ", credit=" + credit + ", status=" + status + "]";
	}


	
}
