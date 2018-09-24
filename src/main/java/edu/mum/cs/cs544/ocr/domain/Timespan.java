package edu.mum.cs.cs544.ocr.domain;

import javax.persistence.*;

@Entity
public class Timespan {
	@Id
	@GeneratedValue
	@Column(name = "TIMESPAN_ID")
	private int id;
	
	@Column(name = "START")
	private String start;
	
	@Column(name = "END")
	private String end;
	
	@Transient
	private String value;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartTime() {
		return start;
	}

	public void setStart(String startTime) {
		this.start = startTime;
	}

	public String getEndTime() {
		return end;
	}

	public void setEndTime(String endTime) {
		this.end = endTime;
	}
	
	public String getValue() {
		return start + " - " + end;
	}

	@Override
	public String toString() {
		return getValue();
	}
	
	@Transient
	private boolean available = true;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean isAvailable) {
		this.available = isAvailable;
	}
	
}
