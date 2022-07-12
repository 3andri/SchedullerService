package com.andri.service.schedule.Stock.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.andri.service.schedule.Stock.ChromeDrivergrab;
import com.andri.service.schedule.Stock.Constanta;
import com.andri.service.schedule.Stock.Repo.StockDateRepo;
import com.andri.service.schedule.Stock.Repo.StockRepo;
import com.andri.service.schedule.Stock.model.Stock;
import com.andri.service.schedule.Stock.model.StockDate;
import com.andri.service.schedule.Stock.model.Stocks;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;

@Service
public class Schedule_Run {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	StockRepo repo;

	@Autowired
	StockDateRepo stockdate;

	SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");

	int schedullerStatus;

	public void GetStockDataNormal(int schedullerStatus) {
		this.schedullerStatus = schedullerStatus;
		int loop = 0;
		while (loop++ < 2) {
			int Day = this.schedullerStatus == Constanta.SCHEDULLER_NORMAL ? getDayNormal() : getDayError();
			StockDate dateData = new StockDate();
			if (getToday() >= Day) {
				dateData.setDate(Day);
				dateData.setStatus_get_data(Constanta.status_get_data_NULL);
				dateData.setHari_libur(Constanta.hari_libur_HOLYDAY);
				if ("SUNDAY".equalsIgnoreCase(getDayofweek(Day))) {
					dateData.setSabtu_minggu(Constanta.sabtu_minggu_SUNDAY);
					stockdate.save(dateData);
				} else if ("SATURDAY".equalsIgnoreCase(getDayofweek(Day))) {
					dateData.setSabtu_minggu(Constanta.sabtu_minggu_SATURDAY);
					stockdate.save(dateData);
				} else {
					dateData.setSabtu_minggu(Constanta.sabtu_minggu_WEEKDAY);
					dateData.setStatus_get_data(Constanta.status_get_data_FAIL);
					dateData.setHari_libur(Constanta.hari_libur_WORKDAY);
					int status = GetDataFromInternet(Day);
					if (status == 0) {
						dateData.setStatus_get_data(Constanta.status_get_data_SUCCESS);
					} else if (status == 1) {
						dateData.setStatus_get_data(Constanta.status_get_data_NULL);
						dateData.setHari_libur(Constanta.hari_libur_HOLYDAY);
					}
					stockdate.save(dateData);
				}
				System.out.println(Day);
				System.out.println(getDayofweek(Day));

			} else {
				return;
			}
		}

	}

	private int getDayNormal() {
		StockDate date = stockdate.QueryGetLastDate();
		if (date == null) {
			return Constanta.START_DATE;
		}
		LocalDate now = LocalDate.from(getdate(date.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
				.plusDays(1);
		Date dateNow = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return Integer.parseInt(originalFormat.format(dateNow));
	}

	private int getDayError() {
		StockDate date = stockdate.QueryGetFirstError();
		if (date==null) {
			return Constanta.END_DATE;
		}else {
			return date.getDate();
		}
	}

	public int GetDataFromInternet(int day) {
		String data;
		Stocks strocks = null;
		try {
			String Url = Constanta.URL_STOCK + day;
			System.out.println(Url);
			data = ChromeDrivergrab.getInstance().getUrl(Url);
			ChromeDrivergrab.getInstance().close();
			data = data.trim();
			try {
				// Files.write(Paths.get("c:\\temp\\data.json"), data.getBytes());
			} catch (Exception e) {
			}
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
			strocks = gson.fromJson(data, Stocks.class);
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		}

		List<Stock> stocks = strocks.getData();
		if (stocks.size() < 2) {
			return 1;
		}
		repo.saveAll(stocks);
		return 0;
	}

	public String getDayofweek(int dateInt) {
		Date date = getdate(dateInt);
		LocalDate local = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return local.getDayOfWeek().toString();
	}

	public Date getdate(int dateInt) {
		Date date = null;
		try {
			date = originalFormat.parse(Integer.toString(dateInt));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	public int getToday() {
		String formatedDate = originalFormat.format(new Date());
		return Integer.parseInt(formatedDate);
	}

}
