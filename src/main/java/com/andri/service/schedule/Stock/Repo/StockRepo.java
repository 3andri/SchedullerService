package com.andri.service.schedule.Stock.Repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andri.service.schedule.Stock.model.Stock;
import com.andri.service.schedule.Stock.model.StockDate;

@Repository
public interface StockRepo extends JpaRepository<Stock, String> {
	@Query(value = "SELECT * from stockdata.stock where StockCode =:stockcode and date not in (SELECT date from stockdifferent where StockCode =:stockcode )order by `date` ASC ", nativeQuery = true)
	public List<Stock> getNonCalculateData(@Param("stockcode") String stockcode);

	@Query(value = "SELECT * from stockdata.stock where StockCode =:stockcode and date < :date order by `Date` DESC limit 1", nativeQuery = true)
	public List<Stock> getLastStock(@Param("stockcode") String stockcode, @Param("date") Date date);
}
