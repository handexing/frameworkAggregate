package org.handx.scanning;

import java.util.HashMap;
import java.util.Map;

public class SequenceDaoImpl implements SequenceDao {

	private Map<String, Sequence> sequences;
	private Map<String, Integer> values;

	public SequenceDaoImpl() {
		sequences = new HashMap<String, Sequence>();
		sequences.put("IT", new Sequence("IT", "30", "a"));
		values = new HashMap<String, Integer>();
		values.put("IT", 1000);
	}

	public int getNextValue(String id) {
		int value = values.get(id);
		values.put(id, value + 1);
		return value;
	}

	public Sequence getSequence(String id) {
		return sequences.get(id);
	}

}
