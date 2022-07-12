package com.andri.service;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class test {
	public static void main(String[] args) {
		Map<String, String> header=new HashMap<String, String>();
		header.put("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.125 Safari/537.36");
		header.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8");
		header.put("Accept-Language", "en-US,en;q=0.5");
		header.put("Accept-Encoding", "gzip, deflate, br");
		header.put("DNT", "1");
		header.put("Upgrade-Insecure-Requests", "1");
		header.put("Sec-Fetch-Dest", "document");
		header.put("Sec-Fetch-Site", "none");
		header.put("Sec-Fetch-User", "?1");
		header.put("Pragma", "no-cache");
		header.put("Cache-Control", "no-cache");
		try {
			Document  doc= Jsoup.connect(
					"https://www.idx.co.id/umbraco/Surface/TradingSummary/GetStockSummary?Length=10000&date=20220609")
					.headers(header).timeout(60000).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
