package com.andri.service.lelang.Service;

import java.math.BigInteger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.andri.service.lelang.Model.bri_rumah;
import com.rumah.btn.OrmConnection;

public class getBRIData {
	public static void main(String[] args) {
		getBRIData bri = new getBRIData();
		bri.setdataBRI("https://rumahmurahbtn.co.id/btn/detail/37689/bks-220702");

	}

	bri_rumah setdataBRI(String url) {

		try {
			btn_rumah 
			System.out.println(btn_rumah.getBtn_url());
			Document doc = Jsoup.connect(btn_rumah.getBtn_url()).get();
			System.out.println(doc.select("section#quick-summary.clearfix dl dd").get(3).text());
			btn_rumah.setBtn_kode_aset(doc.select("section#quick-summary.clearfix dl dd").get(0).text());
			if (doc.select("section#quick-summary.clearfix dl dd span.tag").size() > 1) {
				System.out.println(doc.select("section#quick-summary.clearfix dl dd span.tag").get(0));
				btn_rumah.setBtn_harga_awal(new BigInteger(doc.select("section#quick-summary.clearfix dl dd span.tag")
						.get(0).text().replaceAll("[A-Za-z .]", "")));
				btn_rumah.setBtn_harga(new BigInteger(doc.select("section#quick-summary.clearfix dl dd span.tag").get(1)
						.text().replaceAll("[A-Za-z .]", "")));
			} else {
				btn_rumah.setBtn_harga(new BigInteger(
						doc.select("section#quick-summary.clearfix dl dd").get(1).text().replaceAll("[A-Za-z .]", "")));
			}
			btn_rumah.setBtn_lokasi(doc.select("section#quick-summary.clearfix dl dd").get(2).text());
			if (doc.select("section#quick-summary.clearfix dl dd").size() == 6) {
				btn_rumah.setBtn_lebar_jalan_depan(
						Integer.parseInt(doc.select("section#quick-summary.clearfix dl dd").get(3).text()));
				btn_rumah.setBtn_luas_tanah(Integer.parseInt(
						doc.select("section#quick-summary.clearfix dl dd").get(4).text().replaceAll("[.]", "")));
				btn_rumah.setBtn_luas_bangunan(Integer.parseInt(
						doc.select("section#quick-summary.clearfix dl dd").get(5).text().replaceAll("[.]", "")));
			} else {
				btn_rumah.setBtn_dokumen(doc.select("section#quick-summary.clearfix dl dd").get(3).text());
				btn_rumah.setBtn_lebar_jalan_depan(
						Integer.parseInt(doc.select("section#quick-summary.clearfix dl dd").get(4).text()));
				btn_rumah.setBtn_luas_tanah(Integer.parseInt(
						doc.select("section#quick-summary.clearfix dl dd").get(5).text().replaceAll("[.]", "")));
				btn_rumah.setBtn_luas_bangunan(Integer.parseInt(
						doc.select("section#quick-summary.clearfix dl dd").get(6).text().replaceAll("[.]", "")));
			}
			btn_rumah.setBtn_rencana_lokasi_penjualan(doc.select("section#quick-lelang.clearfix dl dd").get(0).text());

			try {
				btn_rumah.setBtn_keterangan_penjualan(doc.select("section#quick-lelang.clearfix dl dd").get(1).text());
				btn_rumah.setBtn_nomor_telp(doc.select("section#quick-lelang.clearfix dl dd").get(2).text());
			} catch (Exception e) {
				e.printStackTrace();
			}
			btn_rumah.setBtn_gambar_local(localpath + "\\" + btn_rumah.getBtn_kode_aset() + ".jpg");
			//getDownloadImage(btn_rumah.getBtn_gambar_url(), btn_rumah.getBtn_gambar_local());

			System.out.println(btn_rumah.toString());
			OrmConnection.getRumahBtn().update(btn_rumah);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
