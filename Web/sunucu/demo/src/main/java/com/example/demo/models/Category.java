package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int kategoriID;
	
	@Column(name = "kategori_adi")
	private String kategoriAdi;

	public int getId() {
		return kategoriID;
	}

	public void setId(int id) {
		this.kategoriID = id;
	}

	public String getKategoriAdi() {
		return kategoriAdi;
	}

	public void setKategoriAdi(String kategoriAdi) {
		this.kategoriAdi = kategoriAdi;
	}
	
}
