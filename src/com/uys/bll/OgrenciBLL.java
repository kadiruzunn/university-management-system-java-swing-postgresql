package com.uys.bll;

import java.util.List;

import com.uys.model.Ogrenci;
import com.uys.repository.IRepository;
import com.uys.repository.RepositoryFactory;

public class OgrenciBLL implements IBusiness<Ogrenci>{

	IRepository<Ogrenci> repo = RepositoryFactory.create();
	
	@Override
	public List<Ogrenci> liste() {


		
		return repo.liste();
	}

	@Override
	public Ogrenci idIleGetir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ekle(Ogrenci obj) {
		repo.ekle(obj);
	}

	@Override
	public void guncelle(Ogrenci obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sil(int id) {
		repo.sil(id);
		
	}

}
