package com.uys.model;


public class Ders {

	private int id;
	private String ad;
	private byte krediPuani;
	
	public Ders(int id, String ad, byte krediPuani) {
		this.id = id;
		this.ad = ad;
		this.krediPuani = krediPuani;
	}

	public int getId() {
		return id;
	}

	public String getAd() {
		return ad;
	}

	public byte getKrediPuani() {
		return krediPuani;
	}
}
