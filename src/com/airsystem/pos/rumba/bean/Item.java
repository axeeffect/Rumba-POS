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
	@Column(name = "kode", nullable = false)
	private String kode;

	@Column(name = "nama", nullable = false)
	private String nama;

	@Column(name = "jenis", nullable = false)
	private String jenis;

	@Column(name = "harga", nullable = false)
	private Long harga;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.ALL)
	@ForeignKey(name = "FK_Stok")
	private Set<Stok> stoks = new HashSet<Stok>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.item", cascade = CascadeType.ALL)
	@ForeignKey(name = "FK_Item")
	private Set<Detail> details = new HashSet<Detail>(0);

	public Item() {
	}

	public Item(String kode, String nama, String jenis, Long harga) {
		this.kode  = kode;
		this.nama  = nama;
		this.jenis = jenis;
		this.harga = harga;
	}

	public Item(String kode, String nama, String jenis, Long harga, Set<Stok> stoks) {
		this.kode  = kode;
		this.nama  = nama;
		this.jenis = jenis;
		this.harga = harga;
		this.stoks = stoks;
	}
	
	public Item(String kode, String nama, String jenis, Long harga, Set<Stok> stoks, Set<Detail> details) {
		this.kode  	 = kode;
		this.nama  	 = nama;
		this.jenis 	 = jenis;
		this.harga 	 = harga;
		this.stoks 	 = stoks;
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

	public Long getHarga() {
		return harga;
	}

	public void setHarga(Long harga) {
		this.harga = harga;
	}

	public Set<Stok> getStoks() {
		return stoks;
	}

	public void setStoks(Set<Stok> stoks) {
		this.stoks = stoks;
	}

	public Set<Detail> getDetails() {
		return details;
	}

	public void setDetails(Set<Detail> details) {
		this.details = details;
	}
}