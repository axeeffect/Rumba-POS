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

import org.hibernate.annotations.DynamicUpdate;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Entity
@Table(name = "stok", catalog = "rumba")
@DynamicUpdate(value = true)
public class Stok implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "kode", unique = true, nullable = false)
	private Long kode;

	@Temporal(TemporalType.DATE)
	@Column(name = "tanggal", length = 10, nullable = false)
	private Date tanggal;

	@Column(name = "jumlah", nullable = false)
	private Integer jumlah;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "kode_item", nullable = false)
	private Item item;

	public Stok() {
	}

	public Stok(Long kode, Item item) {
		this.kode = kode;
		this.item = item;
	}

	public Stok(Long kode, Date tanggal, Integer jumlah, Item item) {
		this.kode 	 = kode;
		this.tanggal = tanggal;
		this.jumlah  = jumlah;
		this.item 	 = item;
	}

	public Long getKode() {
		return kode;
	}

	public void setKode(Long kode) {
		this.kode = kode;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public Integer getJumlah() {
		return jumlah;
	}

	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}