package com.fuxuan.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @author Fuxuan
 *
 */
public class TradeRecord implements Serializable {

	private static final long serialVersionUID = -6933004002818669361L;

	private Integer id;//主键
	
	private Date addTime;//交易时间
	
	private Integer status;//交易状态(1，等待支付，2支付成功，3支付失败)
	
	private Integer type;//交易类型(1.支付，2.退款)
	
	private BigDecimal count;//金额
	
	private Integer currency;//币种(1.人民币,2，美元)
	
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal  count) {
		this.count = count;
	}

	public Integer getCurrency() {
		return currency;
	}

	public void setCurrency(Integer currency) {
		this.currency = currency;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TradeRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TradeRecord(Integer id, Date addTime, Integer status, Integer type, BigDecimal count, Integer currency,
			User user) {
		super();
		this.id = id;
		this.addTime = addTime;
		this.status = status;
		this.type = type;
		this.count = count;
		this.currency = currency;
		this.user = user;
	}
	
	
}
