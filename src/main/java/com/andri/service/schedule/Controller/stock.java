package com.andri.service.schedule.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andri.service.schedule.Stock.Repo.StockListRepo;
import com.andri.service.schedule.Stock.Repo.StockRepo;
import com.andri.service.schedule.Stock.Repo.stockdifferentRepo;
import com.andri.service.schedule.Stock.model.StockList;
import com.andri.service.schedule.Stock.model.stockdifferent;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stock")
public class stock {
	@Autowired
	StockListRepo repostock;

	@Autowired
	stockdifferentRepo repoRank;

	@RequestMapping("/stock-list")
	public List<StockList> getStockList() {
		return repostock.getStockList();
	}

	@RequestMapping("/stock-rank")
	public List<stockdifferent> getRankList(@RequestParam(name = "date", required = true) String date,
			@RequestParam(name = "sort", required = false) String sort) {
		return repoRank.GetlistRankASC(date);
	}

}
