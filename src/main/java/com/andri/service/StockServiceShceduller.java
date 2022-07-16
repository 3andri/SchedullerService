package com.andri.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.andri.service.lelang.Service.SchedullerRun;
import com.andri.service.schedule.Stock.Constanta;
import com.andri.service.schedule.Stock.service.Schedule_Run;
import com.andri.service.schedule.Stock.service.Scheduller_different;

@Service
public class StockServiceShceduller {
	@Autowired
	public Schedule_Run data;
	int i = 0;
	@Autowired
	public Scheduller_different different;

	@Scheduled(fixedRate = 60 * 60 * 1000)
	void scheduleNormal() {
		System.out.println("Start Normal Scheduller +" + i++);
		data.GetStockDataNormal(Constanta.SCHEDULLER_NORMAL);
	}
	
	
	@Scheduled(fixedRate =24 *60 * 60 * 1000)
	void scheduleError() {
		System.out.println("Start Error Scheduller +" + i++);
		data.GetStockDataNormal(Constanta.SCHEDULLER_ERROR);
	}
	@Scheduled(fixedRate =24 *60 * 60 * 1000)
	void scheduleStockDifferent() {
		different.StockChangeCalculate();
	}
}
