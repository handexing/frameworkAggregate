package org.handx.ioc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SequenceGenerator {

	private String prefix;
	private String suffix;
	private int inital;

	private List<Object> lists;
	private Object[] arrs;
	private Set<Object> sets;
	private Map<Object, Object> maps;
	private Properties properties;

	public SequenceGenerator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SequenceGenerator(String prefix, String suffix, int inital) {
		super();
		this.prefix = prefix;
		this.suffix = suffix;
		this.inital = inital;
	}

	public int getInital() {
		return inital;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setArrs(Object[] arrs) {
		this.arrs = arrs;
	}

	public void setInital(int inital) {
		this.inital = inital;
	}

	public void setLists(List<Object> lists) {
		this.lists = lists;
	}

	public void setMaps(Map<Object, Object> maps) {
		this.maps = maps;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public void setSets(Set<Object> sets) {
		this.sets = sets;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString() {
		return "SequenceGenerator [prefix=" + prefix + ", suffix=" + suffix + ", inital=" + inital + ", lists=" + lists
				+ ", arrs=" + Arrays.toString(arrs) + ", sets=" + sets + ", maps=" + maps + ", properties=" + properties
				+ "]";
	}




}
