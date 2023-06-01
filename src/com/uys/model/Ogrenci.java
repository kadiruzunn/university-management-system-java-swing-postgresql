package com.uys.model;

import java.time.LocalDate;

public class Ogrenci {
	
	private int id;
	private String okulNo;
	private String ad;
	private String ikinciAd;
	private String soyad;
	private LocalDate kayitTarihi; 
	
	public Ogrenci() {}

	public Ogrenci(int id, String okulNo, String ad, String ikinciAd, String soyad, LocalDate kayitTarihi) {
		this.id = id;
		this.okulNo = okulNo;
		this.ad = ad;
		this.ikinciAd = ikinciAd;
		this.soyad = soyad;
		this.kayitTarihi = kayitTarihi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOkulNo() {
		return okulNo;
	}

	public void setOkulNo(String okulNo) {
		this.okulNo = okulNo;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getIkinciAd() {
		return ikinciAd;
	}

	public void setIkinciAd(String ikinciAd) {
		this.ikinciAd = ikinciAd;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public LocalDate getKayitTarihi() {
		return kayitTarihi;
	}

	public void setKayitTarihi(LocalDate kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}

}
