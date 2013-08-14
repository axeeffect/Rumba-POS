package com.airsystem.pos.rumba.controller.model;

/**
 * @author Fanny Irawan Sutawanir
 */
public class OrderDispatcher {

	private String tanggal;

	private String kode;

	private String nama;

	private String pesan;

	private String harga;

	private long total;

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof OrderDispatcher)) {
			return super.equals(object);
		}

		OrderDispatcher orderTemp = (OrderDispatcher) object;

		boolean isEqual = this.kode.equals(orderTemp.getKode())
					   && this.nama.equals(orderTemp.getNama())
					   && this.harga.equals(orderTemp.getHarga());

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

	public String getPesan() {
		return pesan;
	}

	public void setPesan(String pesan) {
		this.pesan = pesan;
	}

	public String getHarga() {
		return harga;
	}

	public void setHarga(String harga) {
		this.harga = harga;
	}

	public int getPesanItem() {
		return Integer.parseInt(getPesan());
	}

	public long getHargaItem() {
		return Long.valueOf(getHarga());
	}

	public long getTotal() {
		total = getPesanItem() * getHargaItem();

		return total;
	}
}