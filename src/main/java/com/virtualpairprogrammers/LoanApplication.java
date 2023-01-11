package com.virtualpairprogrammers;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.client.RestTemplate;

@Entity
public class LoanApplication 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int principal; // amount borrowed
	private int termInMonths;
	private BigDecimal repayment;
	private Boolean approved;
	
	
	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	// Ideally, what we want to do is to stub this RestTemplate object, and override this getInterestRate() to return the value that we want for the test, which is
	// 10%. But, there's a slight problem which is that, this RestTemplate object is a private variable that only exists within this method.
	// So, there's no way to inject an object to replace it. If I created a mock of this RestTemplate, how can I inject it in this getInterestRate method. There's no way
	// to do that. Unless we refactor the method, and make this RestTemplate variable a variable level class, with a set method, which we don't want to do.
	// We need another technique and mockito gives us the ability to spy on an object.
	// Spy:

	public BigDecimal getInterestRate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://loans.virtualpairprogrammers.com/getInterestRate", BigDecimal.class);
	}



	public BigDecimal getRepayment() {
		return repayment;
	}

	public void setRepayment(BigDecimal repayment) {
		this.repayment = repayment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrincipal() {
		return principal;
	}

	public void setPrincipal(int principal) {
		this.principal = principal;
	}

	public int getTermInMonths() {
		return termInMonths;
	}

	public void setTermInMonths(int termInMonths) {
		this.termInMonths = termInMonths;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
