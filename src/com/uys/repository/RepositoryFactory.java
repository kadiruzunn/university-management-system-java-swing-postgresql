package com.uys.repository;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import com.uys.model.Ogrenci;

public class RepositoryFactory {
	
	public static IRepository<Ogrenci> create(){
		
		Properties props = new Properties();
		
		
		try(Reader reader = Files.newBufferedReader(Paths.get("application.properties"))) { 
			props.load(reader);
		} catch (Exception e) {
			System.out.println("application.peropeties dosyası okunurken hata oluştu!");
		}
		
		String veriKaynakAdi = props.getProperty("veri_kaynak");
		
		switch (veriKaynakAdi) {
		case "oracle":{ 
			return OgrenciOracleRepo.getInstance();
		}
		case "postgres":{ 
			return OgrenciRepo.getInstance();
		}
		default:
			throw new IllegalArgumentException();
		}
	}
}
