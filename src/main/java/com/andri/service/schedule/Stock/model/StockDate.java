package com.andri.service.schedule.Stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class StockDate {
	@Id
	@Column
	private int date;
	@Column
	private int status_get_data;
	@Column
	private int sabtu_minggu;
	@Column
	private int hari_libur;
	@Column
	private int keterangan;

}
