package com.andri.service.schedule.Stock.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.andri.service.schedule.Stock.model.Stock;
import com.andri.service.schedule.Stock.model.StockDate;

@Repository
public interface StockDateRepo extends JpaRepository<StockDate, Integer> {
	
	@Query(value = "SELECT * FROM StockData.stockdate order by `date` DESC limit 1",nativeQuery = true)
	public StockDate QueryGetLastDate();

}
