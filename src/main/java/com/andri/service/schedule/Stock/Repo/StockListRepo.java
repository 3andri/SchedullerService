package com.andri.service.schedule.Stock.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.andri.service.schedule.Stock.model.StockList;

@Repository
public interface StockListRepo extends JpaRepository<StockList, String> {
	@Query(value = "SELECT StockCode,StockName from stockdata.stock stock group by StockCode,StockName  order by StockCode", nativeQuery = true)
	public List<StockList> getStockList();

}
