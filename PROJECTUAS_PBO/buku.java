package com.perpus;

public class buku {
	private String kode_buku;
	private String judul_buku;
	private String kategori_buku;
	private String pengarang;
	private String penerbit;
	private String tahun_terbit;
	private String lokasi_rak_buku;
	
	public String getkode_buku() {
		return kode_buku;
	}
	
	public void setkode_buku(String kode_buku) {
		this.kode_buku = kode_buku;
	}
	
	public String getjudul_buku() {
		return judul_buku;
	}
	
	public void setjudul_buku(String judul_buku) {
		this.judul_buku = judul_buku;
	}
	
	public String getkategori_buku() {
		return kategori_buku;
	}
	
	public void setkategori_buku(String kategori_buku) {
		this.kategori_buku = kategori_buku;
	}
	
	public String getpengarang() {
		return pengarang;
	}
	
	public void setpengarang(String pengarang) {
		this.pengarang = pengarang;
	}
	
	public String getpenerbit() {
		return penerbit;
	}
	
	public void setpenerbit(String penerbit) {
		this.penerbit = penerbit;
	}
	
	public String gettahun_terbit() {
		return tahun_terbit;
	}
	
	public void settahun_terbit(String tahun_terbit) {
		this.tahun_terbit = tahun_terbit;
	}
	
	public String getlokasi_rak_buku() {
		return lokasi_rak_buku;
	}
	
	public void setlokasi_rak_buku(String lokasi_rak_buku) {
		this.lokasi_rak_buku = lokasi_rak_buku;
	}
}
