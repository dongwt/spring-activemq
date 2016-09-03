package com.dongwt.activemq;

import java.io.Serializable;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	Order(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Order() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Order{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
