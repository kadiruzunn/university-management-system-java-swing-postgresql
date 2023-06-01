package com.uys.model;

public class DersKayit {
	
	private int ogrenciId;
	private int dersId;
	private float notu;
	
	public DersKayit() {}

	public DersKayit(int ogrenciId, int dersId, float notu) {
		this.ogrenciId = ogrenciId;
		this.dersId = dersId;
		this.notu = notu;
	}
	

	public int getOgrenciId() {
		return ogrenciId;
	}

	public void setOgrenciId(int ogrenciId) {
		this.ogrenciId = ogrenciId;
	}

	public int getDersId() {
		return dersId;
	}

	public void setDersId(int dersId) {
		this.dersId = dersId;
	}

	public float getNotu() {
		return notu;
	}

	public void setNotu(float notu) {
		this.notu = notu;
	}	

}
