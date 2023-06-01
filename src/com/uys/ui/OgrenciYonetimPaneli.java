package com.uys.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.uys.bll.OgrenciBLL;
import com.uys.model.Ogrenci;

import javax.swing.JScrollPane;

public class OgrenciYonetimPaneli extends JFrame {

	private JPanel contentPane;
	private JTable table;

	OgrenciBLL bll = new OgrenciBLL();
	/**
	 * Create the frame.
	 */
	public OgrenciYonetimPaneli() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnYeniOgrenci = new JButton("Yeni Öğrenci");
		btnYeniOgrenci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ogrenciEklePaneliAc();
				
			}
		});
		btnYeniOgrenci.setBounds(40, 23, 134, 23);
		contentPane.add(btnYeniOgrenci);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setBounds(51, 144, 466, 190);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 144, 466, 190);
	
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		JButton btnSil = new JButton("Seçilen Kaydı Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilenIndex = table.getSelectedRow();
				int secilenId = ogrenciListesi.get(secilenIndex).getId();
				
				bll.sil(secilenId);
				ogrencilistele();
			}
		});
		btnSil.setBounds(192, 23, 134, 23);
		contentPane.add(btnSil);
		
		ogrencilistele();
	}
	
	private void ogrenciEklePaneliAc() {
		OgrenciEkle ekle = new OgrenciEkle(this);
		ekle.setVisible(true);
	}
	
	private List<Ogrenci> ogrenciListesi;
	
	void ogrencilistele() {
		
		ogrenciListesi = bll.liste();
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Sıra No");
		model.addColumn("Okul No");
		model.addColumn("Ad");
		model.addColumn("İkinci Ad");
		model.addColumn("Soyad");
		model.addColumn("Kayıt Tarihi");

		Object[] row = new Object[6]; 

		int rowCount = ogrenciListesi.size();

		int i = 1;

		for (Ogrenci o : ogrenciListesi) {
			row[0] = i++;
			row[1] = o.getAd();
			row[2] = o.getIkinciAd();
			row[3] = o.getSoyad(); 
			row[4] = o.getOkulNo();
			row[5] = o.getKayitTarihi();
			model.addRow(row);
		}

		table.setModel(model);
	}
}
