package com.airsystem.pos.rumba.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Entity
@Table(name = "item", catalog = "rumba")
public class Item implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "kode")
	private String kode;

	@Column(name = "nama")
	private String nama;

	@Column(name = "jenis")
	private String jenis;

	@Column(name = "harga")
	private long harga;

	@Column(name = "stok")
	private int stok;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private Set<Order> order = new HashSet<Order>();

	public Item() {
		/* Default constructor */
	}

	public Item(long id, String kode, String nama, String jenis, long harga, int stok) {
		this.id = id;
		this.kode  = kode;
		this.nama  = nama;
		this.jenis = jenis;
		this.harga = harga;
		this.stok  = stok;
	}

	public Item(long id, String kode, String nama, String jenis, long harga, int stok, Set<Order> order) {
		this.id = id;
		this.kode  = kode;
		this.nama  = nama;
		this.jenis = jenis;
		this.harga = harga;
		this.stok  = stok;
		this.order = order;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getHarga() {
		return harga;
	}

	public void setHarga(long harga) {
		this.harga = harga;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}
}