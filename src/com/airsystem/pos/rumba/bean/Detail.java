package com.airsystem.pos.rumba.bean;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Entity
@Table(name = "detail", catalog = "rumba")
@AssociationOverrides({
		@AssociationOverride(name = "pk.item",  joinColumns = @JoinColumn(name = "kode_item")),
		@AssociationOverride(name = "pk.order", joinColumns = @JoinColumn(name = "kode_order")) })
public class Detail implements Serializable {

	@EmbeddedId
	private DetailId pk = new DetailId();

	@Column(name = "jumlah")
	private int jumlah;

	@Column(name = "total")
	private long total;

	public Detail() {
	}

	public DetailId getPk() {
		return pk;
	}

	public void setPk(DetailId pk) {
		this.pk = pk;
	}

	@Transient
	public Item getItem() {
		return getPk().getItem();
	}

	public void setItem(Item item) {
		getPk().setItem(item);
	}

	@Transient
	public Order getOrder() {
		return getPk().getOrder();
	}

	public void setOrder(Order order) {
		getPk().setOrder(order);
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

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (object == null || getClass() != object.getClass()) {
			return false;
		}

		Detail that = (Detail) object;

		if (getPk() != null ? !getPk().equals(that.getPk())	: that.getPk() != null) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}