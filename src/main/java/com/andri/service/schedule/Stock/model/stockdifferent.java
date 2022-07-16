package com.andri.service.schedule.Stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity(name = "stockdifferent")
@IdClass(stockdifferentId.class)
public class stockdifferent {
	@Id
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private java.util.Date Date;
	@Id
	@Column
	private String StockCode;
	@Column
	private Double pricetoday;
	@Column
	private Double priceyesterday;
	@Column
	private Double percentage;
	@Column
	private Double change;
	@Column
	private String status;

}
