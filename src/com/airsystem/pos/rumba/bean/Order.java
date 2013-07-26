package com.airsystem.pos.rumba.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Entity
@Table(name = "order", catalog = "rumba")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "kode")
	private long kode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kode_item")
	private Item item;

	@Temporal(TemporalType.DATE)
	@Column(name = "tanggal", length = 10)
	private Date tanggal;

	@Column(name = "jumlah")
	private int jumlah;

	@Column(name = "total")
	private long total;

	public Order() {
		/* Default constructor */
	}

	public Order(long kode, Item item) {
		this.kode = kode;
		this.item = item;
	}

	public Order(long kode, Item item, Date tanggal, int jumlah, long total) {
		this.kode 	 = kode;
		this.item 	 = item;
		this.tanggal = tanggal;
		this.jumlah  = jumlah;
		this.total 	 = total;
	}

	public long getKode() {
		return kode;
	}

	public void setKode(long kode) {
		this.kode = kode;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}