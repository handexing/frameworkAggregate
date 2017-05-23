package org.handx.constructor;

public class Disc extends Product {

	private int capacity;

	public Disc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Disc(int capacity) {
		super();
		this.capacity = capacity;
	}

	public Disc(String name, Double price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Disc [capacity=" + capacity + ", getName()=" + getName() + ", getPrice()=" + getPrice() + "]";
	}


}
