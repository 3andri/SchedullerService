package com.andri.service.schedule.Stock.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andri.service.schedule.Stock.model.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock,String>{

}
