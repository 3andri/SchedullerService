package com.andri.service.lelang.Model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class bri_rumah {
	@Id
	private String url;
	@Column
	private long harga;
	@Column
	private String contact_person;
	@Column
	private int luas_tanah;
	@Column
	private int luas_bangunan;
	@Column
	private String arah_hadap_bangunan;
	@Column
	private int jumlah_lantai;
	@Column
	private int jumal_kamar_tidur;
	@Column
	private String jenis_sertifikasi;
	@Column
	private String furnished;
	@Column
	private int daya_listrik;
	@Column
	private String alamat;
	@Column
	private String akses;
	@Column
	private String fasilitas;
	@Column
	private String kpknl;
	@Column
	private String lokasi_lelang;
	@Column
	private String tanggal_lelang;
}
