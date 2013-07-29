package com.airsystem.pos.rumba.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Entity
@Table(name = "item", catalog = "rumba")
public class Item implements Serializable {

	@Id
	@Column(name = "kode")
	private String kode;

	@Column(name = "nama")
	private String nama;

	@Column(name = "jenis")
	private String jenis;

	@Column(name = "jumlah")
	private int jumlah;

	@Column(name = "harga")
	private long harga;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.item", cascade = CascadeType.ALL)
	@ForeignKey(name = "FK_Item")
	private Set<Detail> details = new HashSet<Detail>(0);

	public Item() {
	}

	public Item(String kode, String nama, String jenis, int jumlah, long harga) {
		this.kode 	= kode;
		this.nama 	= nama;
		this.jenis  = jenis;
		this.jumlah = jumlah;
		this.harga  = harga;
	}

	public Item(String kode, String nama, String jenis, int jumlah, long harga,	Set<Detail> details) {
		this.kode 	 = kode;
		this.nama 	 = nama;
		this.jenis 	 = jenis;
		this.jumlah  = jumlah;
		this.harga 	 = harga;
		this.details = details;
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

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public long getHarga() {
		return harga;
	}

	public void setHarga(long harga) {
		this.harga = harga;
	}

	public Set<Detail> getDetails() {
		return details;
	}

	public void setDetails(Set<Detail> details) {
		this.details = details;
	}
}