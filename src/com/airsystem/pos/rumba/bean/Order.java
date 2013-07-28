package com.airsystem.pos.rumba.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Entity
@Table(name = "order", catalog = "rumba")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "kode", unique = true, nullable = false)
	private Long kode;

	@Temporal(TemporalType.DATE)
	@Column(name = "tanggal", length = 10, nullable = false)
	private Date tanggal;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.order", cascade = CascadeType.ALL)
	@ForeignKey(name = "FK_Order")
	private Set<Detail> details = new HashSet<Detail>(0);

	public Order() {
	}

	public Order(Long kode, Date tanggal) {
		this.kode 	 = kode;
		this.tanggal = tanggal;
	}

	public Order(Long kode, Date tanggal, Set<Detail> details) {
		this.kode 	 = kode;
		this.tanggal = tanggal;
		this.details = details;
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

	public Set<Detail> getDetails() {
		return details;
	}

	public void setDetails(Set<Detail> details) {
		this.details = details;
	}
}