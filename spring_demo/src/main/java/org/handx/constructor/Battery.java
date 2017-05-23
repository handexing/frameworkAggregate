package org.handx.constructor;

public class Battery extends Product {

	private boolean rechargeable;

	public Battery() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Battery(boolean rechargeable) {
		super();
		this.rechargeable = rechargeable;
	}

	public Battery(String name, Double price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}

	public boolean isRechargeable() {
		return rechargeable;
	}

	public void setRechargeable(boolean rechargeable) {
		this.rechargeable = rechargeable;
	}

	@Override
	public String toString() {
		return "Battery [rechargeable=" + rechargeable + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ "]";
	}


}
