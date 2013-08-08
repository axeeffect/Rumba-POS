package com.airsystem.pos.rumba.controller.model;

public class ItemDispatcher {
	
	private String tanggal;
	private String kode;
	private String nama;
	private String harga;
	private String pesan;
	private long total;
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ItemDispatcher) ) {
			return super.equals(obj);
		}
		
		ItemDispatcher temp = (ItemDispatcher) obj;
		
		boolean isEqual = this.kode.equals(temp.getKode() ) &&
						  this.nama.equals(temp.getNama() ) &&
						  this.harga.equals(temp.getHarga() );
		
		return isEqual;
	}
	
	public String getTanggal() {
		return tanggal;
	}
	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getHarga() {
		return harga;
	}
	public void setHarga(String harga) {
		this.harga = harga;
	}
	public String getPesan() {
		return pesan;
	}
	public int getPesanInt() {
		return Integer.parseInt(pesan);
	}
	public void setPesan(String pesan) {
		this.pesan = pesan;
	}
	public long getTotal() {
		int hargaItem = Integer.parseInt(harga);
		int pesanItem = Integer.parseInt(pesan);
		total = hargaItem * pesanItem;
		
		return total;
	}
	
	
}
