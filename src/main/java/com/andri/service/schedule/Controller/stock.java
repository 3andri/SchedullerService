package com.andri.service.schedule.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andri.service.schedule.Stock.Repo.StockListRepo;
import com.andri.service.schedule.Stock.Repo.StockRepo;
import com.andri.service.schedule.Stock.model.StockList;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stock")
public class stock {
	@Autowired
	StockListRepo repo;
	
	
	@RequestMapping("/stock-list")
	public List<StockList> getStockList() {
		return repo.getStockList();
	}
	
	@RequestMapping("/stock-rank")
	public List<StockList> getRankList() {
		return repo.getStockList();
	}

}
