package com.jbk.Bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal converstionMultiple;
	private BigDecimal quantity;
	private BigDecimal calculatedAmount;
	private int port;

	public CurrencyConversionBean() {

	}


	public CurrencyConversionBean(Long id, String from, String to, BigDecimal converstionMultiple, BigDecimal quantity,
			BigDecimal calculatedAmount, int port) {

		this.id = id;
		this.from = from;
		this.to = to;
		this.converstionMultiple = converstionMultiple;
		this.quantity = quantity;
		this.calculatedAmount = calculatedAmount;
		this.port = port;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConverstionMultiple() {
		return converstionMultiple;
	}

	public void setConverstionMultiple(BigDecimal converstionMultiple) {
		this.converstionMultiple = converstionMultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}

	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "CurrencyConversionBean [id=" + id + ", from=" + from + ", to=" + to + ", converstionMultiple="
				+ converstionMultiple + ", quantity=" + quantity + ", calculatedAmount=" + calculatedAmount + ", port="
				+ port + "]";
	}


}
