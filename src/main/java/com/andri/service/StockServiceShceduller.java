package com.andri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.andri.service.schedule.Stock.Constanta;
import com.andri.service.schedule.Stock.service.Schedule_Run;

@Service
public class StockServiceShceduller {
	@Autowired
	public Schedule_Run data;
	int i = 0;

	@Scheduled(fixedRate = 60 * 60 * 1000)
	void scheduleNormal() {
		System.out.println("Start Normal Scheduller +" + i++);
		data.GetStockDataNormal(Constanta.SCHEDULLER_NORMAL);
	}
	
	
	//@Scheduled(fixedRate = 60 * 60 * 1000)
	void scheduleError() {
		System.out.println("Start Error Scheduller +" + i++);
		data.GetStockDataNormal(Constanta.SCHEDULLER_ERROR);
	}
}
