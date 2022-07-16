package com.andri.service.schedule.Stock.Repo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andri.service.schedule.Stock.model.Stock;
import com.andri.service.schedule.Stock.model.StockDate;

@Repository
public interface StockDateRepo extends JpaRepository<StockDate, Integer> {
	
	@Query(value = "SELECT * FROM stockdata.stockdate order by `date` DESC limit 1",nativeQuery = true)
	public StockDate QueryGetLastDate();
	
	@Query(value = "SELECT * FROM stockdate WHERE status_get_data =2 order by `date` asc limit 1",nativeQuery = true)
	public StockDate QueryGetFirstError();
	
	

}
