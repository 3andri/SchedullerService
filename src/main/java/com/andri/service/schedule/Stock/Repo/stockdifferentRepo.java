package com.andri.service.schedule.Stock.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andri.service.schedule.Stock.model.StockDate;
import com.andri.service.schedule.Stock.model.stockdifferent;
import com.andri.service.schedule.Stock.model.stockdifferentId;

@Repository
public interface stockdifferentRepo extends JpaRepository<stockdifferent, stockdifferentId> {
	
	@Query(value = "SELECT StockCode  FROM stock group by StockCode ",nativeQuery = true)
	public List<String> GetlistStock();
	
	@Query(value = "SELECT * from stockdata.stockdifferent s where `date` =:date ORDER BY percentage ASC limit 50 ",nativeQuery = true)
	public List<stockdifferent> GetlistRankASC(@Param("date") String date);
	
	@Query(value = "SELECT * from stockdata.stockdifferent s where `date` =:date ORDER BY percentage DESC limit 50 ",nativeQuery = true)
	public List<stockdifferent> GetlistRankDESC(@Param("date") String date);
	
	

}
