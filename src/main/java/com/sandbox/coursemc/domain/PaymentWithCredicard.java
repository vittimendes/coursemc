package com.sandbox.coursemc.domain;

import javax.persistence.Entity;

import com.sandbox.coursemc.domain.enums.PaymentStatus;

@Entity
public class PaymentWithCredicard extends Payment{
	private static final long serialVersionUID = 1L;
	
	private Integer numberInstallments;
	
	public PaymentWithCredicard () {
		
	}

	public PaymentWithCredicard(Integer id, PaymentStatus status, Request request, Integer numberInstallments) {
		super(id, status, request);
		this.setNumberInstallments(numberInstallments);
	}

	public Integer getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}



}
