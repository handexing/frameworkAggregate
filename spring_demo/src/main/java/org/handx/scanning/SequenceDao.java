package org.handx.scanning;

public interface SequenceDao {

	public int getNextValue(String id);

	public Sequence getSequence(String id);
}
