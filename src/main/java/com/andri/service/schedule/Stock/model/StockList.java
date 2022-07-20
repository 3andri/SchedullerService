package com.andri.service.schedule.Stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "stock")
public class StockList {
	@Column
	@Id
	private String stockcode;
	@Column
	private String stockname;
	
}
