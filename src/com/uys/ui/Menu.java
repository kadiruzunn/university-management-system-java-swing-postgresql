package com.uys.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frmniversitemetimSistemi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmniversitemetimSistemi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmniversitemetimSistemi = new JFrame();
		frmniversitemetimSistemi.setTitle("Üniversite Yönetim Sistemi - Menu Ekranı");
		frmniversitemetimSistemi.setBounds(100, 100, 450, 282);
		frmniversitemetimSistemi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmniversitemetimSistemi.getContentPane().setLayout(null); // absolute layout
		
		JButton btnOgrenci = new JButton("Öğrenci Yönetim Paneli");
		btnOgrenci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OgrenciYonetimPaneli ogrenciYonetimPaneli = new OgrenciYonetimPaneli();
				ogrenciYonetimPaneli.setVisible(true);
			}
		});
		btnOgrenci.setBounds(126, 31, 192, 35);
		frmniversitemetimSistemi.getContentPane().add(btnOgrenci);
		
		JButton btnDers = new JButton("Ders Yönetim Paneli");
		btnDers.setBounds(126, 95, 192, 35);
		frmniversitemetimSistemi.getContentPane().add(btnDers);
		
		JButton btnDersKayit = new JButton("Ders Kayıtları Yönetim Paneli");
		btnDersKayit.setBounds(126, 161, 192, 35);
		frmniversitemetimSistemi.getContentPane().add(btnDersKayit);
	}
}
