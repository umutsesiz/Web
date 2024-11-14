package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="urun_adi")
	private String urunAdi;
	private int kategori;
	private String fiyat;
	
	@Column(columnDefinition = "TEXT")
	private String urun_aciklama;
	private String urun_image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrun_adi() {
		return urunAdi;
	}
	public void setUrun_adi(String urun_adi) {
		this.urunAdi = urun_adi;
	}
	public int getKategori() {
		return kategori;
	}
	public void setKategori(int kategori) {
		this.kategori = kategori;
	}
	public String getFiyat() {
		return fiyat;
	}
	public void setFiyat(String fiyat) {
		this.fiyat = fiyat;
	}
	public String getUrun_aciklama() {
		return urun_aciklama;
	}
	public void setUrun_aciklama(String urun_aciklama) {
		this.urun_aciklama = urun_aciklama;
	}
	public String getUrun_image() {
		return urun_image;
	}
	public void setUrun_image(String urun_image) {
		this.urun_image = urun_image;
	}
}
