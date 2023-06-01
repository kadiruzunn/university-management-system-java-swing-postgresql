package com.uys.bll;

import java.util.List;

public interface IBusiness<T> { 
	
	List<T> liste();
	T idIleGetir();
	void ekle(T obj);
	void guncelle(T obj);
	void sil(int id);
}
