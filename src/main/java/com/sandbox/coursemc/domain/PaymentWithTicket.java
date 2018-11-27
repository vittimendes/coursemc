package com.sandbox.coursemc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.sandbox.coursemc.domain.enums.PaymentStatus;

@Entity
public class PaymentWithTicket extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Date dueDate;
	private Date datePayment;
	
	public PaymentWithTicket() {
		
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public PaymentWithTicket(Integer id, PaymentStatus status, Request request, Date dueDate, Date datePayment) {
		super(id, status, request);
		this.datePayment = datePayment;
		this.dueDate = dueDate;
	}


	
}
