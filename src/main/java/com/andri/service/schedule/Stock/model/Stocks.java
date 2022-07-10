package com.andri.service.schedule.Stock.model;

import java.util.List;

import lombok.Data;

@Data
public class Stocks {
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private List<Stock> data;

}
