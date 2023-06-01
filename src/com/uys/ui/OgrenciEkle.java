package com.uys.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDayChooser;
import com.uys.bll.OgrenciBLL;
import com.uys.model.Ogrenci;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.awt.event.ActionEvent;

public class OgrenciEkle extends JFrame {

	private JPanel contentPane;
	private JTextField txtOkulNo;
	private JTextField txtAd;
	private JTextField txtIkinciAd;
	private JTextField txtSoyad;
	private OgrenciBLL bll = new OgrenciBLL();
	/**
	 * Create the frame.
	 */
	public OgrenciEkle(OgrenciYonetimPaneli pnl) {
		setTitle("Öğrenci Yönetim Paneli");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ad");
		lblNewLabel.setBounds(25, 61, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIkinciAd = new JLabel("İkinci Ad");
		lblIkinciAd.setBounds(25, 96, 46, 14);
		contentPane.add(lblIkinciAd);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setBounds(25, 134, 46, 14);
		contentPane.add(lblSoyad);
		
		JLabel lblOkulNo = new JLabel("Okul No");
		lblOkulNo.setBounds(25, 25, 46, 14);
		contentPane.add(lblOkulNo);
		
		JLabel lblKaytTarihi = new JLabel("Kayıt Tarihi");
		lblKaytTarihi.setBounds(25, 169, 67, 14);
		contentPane.add(lblKaytTarihi);
		
		txtOkulNo = new JTextField();
		txtOkulNo.setBounds(100, 22, 86, 20);
		contentPane.add(txtOkulNo);
		txtOkulNo.setColumns(10);
		
		txtAd = new JTextField();
		txtAd.setColumns(10);
		txtAd.setBounds(100, 58, 86, 20);
		contentPane.add(txtAd);
		
		txtIkinciAd = new JTextField();
		txtIkinciAd.setColumns(10);
		txtIkinciAd.setBounds(100, 93, 86, 20);
		contentPane.add(txtIkinciAd);
		
		txtSoyad = new JTextField();
		txtSoyad.setBounds(100, 131, 86, 20);
		contentPane.add(txtSoyad);
		txtSoyad.setColumns(10);
		
		JDateChooser dtKayitTarihi = new JDateChooser();
		dtKayitTarihi.setDateFormatString("dd.MM.yyyy");
		dtKayitTarihi.setBounds(102, 169, 106, 20);
		contentPane.add(dtKayitTarihi);
		
		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ogrenci yeniOgrenci = new Ogrenci();
				yeniOgrenci.setAd(txtAd.getText());
				yeniOgrenci.setIkinciAd(txtIkinciAd.getText());
				yeniOgrenci.setKayitTarihi(dtKayitTarihi.getDate()
						.toInstant()
						.atZone(ZoneId.systemDefault())
						.toLocalDate());
				yeniOgrenci.setOkulNo(txtOkulNo.getText());
				yeniOgrenci.setSoyad(txtSoyad.getText());
				
				bll.ekle(yeniOgrenci);
				
				pnl.ogrencilistele();
			}
		});
		btnKaydet.setBounds(97, 211, 89, 23);
		contentPane.add(btnKaydet);
	}
}
