package com.airsystem.pos.rumba.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * @author Budi Oktaviyan Suryanto <budi.oktaviyan@icloud.com>
 */

@Embeddable
public class DetailId implements Serializable {

	@ManyToOne
	private Item item;

	@ManyToOne
	private Order order;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (object == null || getClass() != object.getClass()) {
			return false;
		}

		DetailId that = (DetailId) object;

		if (item != null ? !item.equals(that.item) : that.item != null) {
			return false;
		}

		if (order != null ? !order.equals(that.order) : that.order != null) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		int result;

		result = (item != null ? item.hashCode() : 0);
		result = 31 * result + (order != null ? order.hashCode() : 0);

		return result;
	}
}