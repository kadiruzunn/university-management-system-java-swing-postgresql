package com.uys.repository;

import java.sql.Timestamp;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uys.model.Ogrenci;

public class OgrenciRepo implements IRepository<Ogrenci> {

	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/universite_yonetim_vt" ;
	private static final String DB_USERNAME = "postgres";
	private static final String DB_PASSWORD = "123";
	private static final String INSERT_STATEMENT = "INSERT INTO public.ogrenciler(" +
			"okul_no,ad,ikinci_ad, soyad, kayit_tarihi ) VALUES (?, ?, ?, ?, ?) ";
	private static final String SELECT_ALL_STATEMENT = "SELECT id, okul_no, ad, ikinci_ad, soyad, kayit_tarihi 	FROM public.ogrenciler";
	private static final String DELETE_STATEMENT = "DELETE FROM ogrenciler WHERE id = ?";
	
	private OgrenciRepo() {
		// TODO Auto-generated constructor stub
	}
	
	private static OgrenciRepo obj = null;
	
	public static OgrenciRepo getInstance() {
		if(obj == null) {
			obj = new OgrenciRepo();
		}
		return obj;
	}
	
	@Override
	public List<Ogrenci> liste() {
		List<Ogrenci> ogrenciList = new ArrayList<>();
		
		try {
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
			
			PreparedStatement selectStatement = conn.prepareStatement(SELECT_ALL_STATEMENT);
			
			ResultSet result = selectStatement.executeQuery();
			
			while(result.next()) {
				
				Ogrenci ogrenci = new Ogrenci();
//				ogrenci.setId(result.getInt(1));
//				ogrenci.setAd(result.getString(2));
				ogrenci.setId(result.getInt("id"));
				ogrenci.setAd(result.getString("ad"));
				ogrenci.setIkinciAd(result.getString("ikinci_ad"));
				ogrenci.setSoyad(result.getString("soyad"));
				ogrenci.setOkulNo(result.getString("okul_no"));
				ogrenci.setKayitTarihi(result.getDate("kayit_tarihi").toLocalDate());
				
				ogrenciList.add(ogrenci);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ogrenciList;
	}

	@Override
	public Ogrenci idIleGetir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ekle(Ogrenci obj) {
		try {
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
			
			PreparedStatement insertStatement = conn.prepareStatement(INSERT_STATEMENT);
			insertStatement.setString(1, obj.getOkulNo());
			insertStatement.setString(2, obj.getAd());
			insertStatement.setString(3, obj.getIkinciAd());
			insertStatement.setString(4, obj.getSoyad());
			insertStatement.setTimestamp(5, Timestamp.valueOf(obj.getKayitTarihi().atStartOfDay()));
			insertStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void guncelle(Ogrenci obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sil(int id) {
		try {
			Connection conn = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
			
			PreparedStatement insertStatement = conn.prepareStatement(DELETE_STATEMENT);
			insertStatement.setInt(1, id);

			insertStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
