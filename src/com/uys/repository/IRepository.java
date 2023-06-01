package com.uys.repository;

import java.util.List;

public interface IRepository<T> {
	
	List<T> liste();
	T idIleGetir();
	void ekle(T obj);
	void guncelle(T obj);
	void sil(int id);

}
