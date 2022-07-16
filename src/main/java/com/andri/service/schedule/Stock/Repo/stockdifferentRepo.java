package com.andri.service.schedule.Stock.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.andri.service.schedule.Stock.model.StockDate;
import com.andri.service.schedule.Stock.model.stockdifferent;
import com.andri.service.schedule.Stock.model.stockdifferentId;

@Repository
public interface stockdifferentRepo extends JpaRepository<stockdifferent, stockdifferentId> {
	
	@Query(value = "SELECT StockCode  FROM stock group by StockCode ",nativeQuery = true)
	public List<String> GetlistStock();
	
	

}
