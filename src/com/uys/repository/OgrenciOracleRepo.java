package com.uys.repository;

import java.util.List;

import com.uys.model.Ogrenci;

public class OgrenciOracleRepo implements IRepository<Ogrenci> {

	
	private OgrenciOracleRepo() {
		// TODO Auto-generated constructor stub
	}

	
	private static OgrenciOracleRepo obj = null;

	
	public static OgrenciOracleRepo getInstance() {
		if (obj == null) {
			obj = new OgrenciOracleRepo();
		}
		return obj;
	}

	@Override
	public List<Ogrenci> liste() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ogrenci idIleGetir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ekle(Ogrenci obj) {
		System.out.println("veri oracle vt kaydedildi");
	}

	@Override
	public void guncelle(Ogrenci obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sil(int id) {
		// TODO Auto-generated method stub

	}

}
