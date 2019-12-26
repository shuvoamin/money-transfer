package com.moneytransfer.services;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class MoneyTransferResponse implements Serializable{
	
	public MoneyTransferResponse() {}
	
	public MoneyTransferResponse(Boolean status, String msg) {
		this.transferStatus = status;
		this.message = msg;
	}
	
	private Boolean transferStatus;
	private String message;
	public Boolean getTransferStatus() {
		return transferStatus;
	}
	public void setTransferStatus(Boolean transferStatus) {
		this.transferStatus = transferStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
