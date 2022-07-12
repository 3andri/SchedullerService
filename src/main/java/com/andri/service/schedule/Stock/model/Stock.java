package com.andri.service.schedule.Stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "stock")
@IdClass(StockId.class)
public class Stock {
	@Column
	private int No;
	@Column
	private int IDStockSummary;
	@Id
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private java.util.Date Date;
	@Id
	@Column
	private String StockCode;
	@Column
	private String StockName;
	@Column
	private String Remarks;
	@Column
	private double Previous;
	@Column
	private double OpenPrice;
	@Column
	private double FirstTrade;
	@Column
	private double High;
	@Column
	private double Low;
	@Column
	private double Close;
	@Column
	private double Change;
	@Column
	private double Volume;
	@Column
	private double Value;
	@Column
	private double Frequency;
	@Column
	private double IndexIndividual;
	@Column
	private double Offer;
	@Column
	private double OfferVolume;
	@Column
	private double Bid;
	@Column
	private double BidVolume;
	@Column
	private double ListedShares;
	@Column
	private double TradebleShares;
	@Column
	private double WeightForIndex;
	@Column
	private double ForeignSell;
	@Column
	private double ForeignBuy;
	@Column
	private String DelistingDate;
	@Column
	private double NonRegularVolume;
	@Column
	private double NonRegularValue;
	@Column
	private double NonRegularFrequency;
	@Column
	private String persen;
	@Column
	private String percentage;
}
