package com.andri.service.schedule.Stock;

public class Constanta {

	public static final String URL_STOCK="https://idx.co.id/umbraco/Surface/TradingSummary/GetStockSummary?Length=10000&date="; 
	public static final int START_DATE = 20150101;
	public static final int END_DATE = 99999999;
	public static final int status_get_data_SUCCESS = 0;
	public static final int status_get_data_NULL = 1;
	public static final int status_get_data_FAIL = 2;
	public static final int sabtu_minggu_WEEKDAY = 0;
	public static final int sabtu_minggu_SATURDAY = 1;
	public static final int sabtu_minggu_SUNDAY = 2;
	public static final int hari_libur_WORKDAY = 0;
	public static final int hari_libur_HOLYDAY = 1;
	public static final int SCHEDULLER_NORMAL = 0;
	public static final int SCHEDULLER_ERROR = 1;
}
