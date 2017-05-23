package org.handx.scanning;

public class Sequence {

	private String id;
	private String prefix;
	private String suffix;

	public Sequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sequence(String id, String prefix, String suffix) {
		super();
		this.id = id;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public String getId() {
		return id;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString() {
		return "Sequence [id=" + id + ", prefix=" + prefix + ", suffix=" + suffix + "]";
	}

}
