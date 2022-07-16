package com.andri.service.schedule.Stock.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andri.service.schedule.Stock.Repo.StockDateRepo;
import com.andri.service.schedule.Stock.Repo.StockRepo;
import com.andri.service.schedule.Stock.Repo.stockdifferentRepo;
import com.andri.service.schedule.Stock.model.Stock;
import com.andri.service.schedule.Stock.model.stockdifferent;

@Service
public class Scheduller_different {

	Logger log = LoggerFactory.getLogger(Schedule_Run.class);
	@Autowired
	stockdifferentRepo stockdifferentRepo;
	@Autowired
	StockRepo stock;

	public void StockChangeCalculate() {
		List<String> stockCodes = stockdifferentRepo.GetlistStock();
		for (String string : stockCodes) {
			log.info("start data "+string);
			List<Stock> stocks = stock.getNonCalculateData(string);
			//List<stockdifferent> stockdifferents=new ArrayList<stockdifferent>();
			stocks.forEach(stock -> {

				stockdifferent stockdifferent = new stockdifferent();
				stockdifferent.setDate(stock.getDate());
				stockdifferent.setStockCode(stock.getStockCode());
				stockdifferent.setPricetoday(stock.getClose());
				stockdifferent.setPriceyesterday(stock.getClose() - stock.getChange());
				stockdifferent.setChange(stock.getChange());
				BigDecimal percent = new BigDecimal(stock.getChange() / (stock.getClose() - stock.getChange()) * 100)
						.setScale(2, RoundingMode.HALF_UP);
				stockdifferent.setPercentage(percent.doubleValue());
				stockdifferent.setStatus(stock.getChange() < 0 ? "-" : "+");
				System.out.println(stockdifferent.toString());
				//stockdifferents.add(stockdifferent);
			});
			//stockdifferentRepo.saveAll(stockdifferents);
			log.info("stop data "+string);
		}
		System.out.println("Test ...............");
	}

}
