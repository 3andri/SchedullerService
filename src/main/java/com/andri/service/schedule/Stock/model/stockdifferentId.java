package com.andri.service.schedule.Stock.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class stockdifferentId implements Serializable {
	private java.util.Date Date;
	private String StockCode;
}
