package com.deloitte.model;

public class Keyevent {
	private String event;
	private String planned;
	private String actual;
	
	public Keyevent(String e, String p, String a)
	{
		this.event = e;
		this.planned = p;
		this.actual = a;
	}
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getPlanned() {
		return planned;
	}
	public void setPlanned(String planned) {
		this.planned = planned;
	}
	public String getActual() {
		return actual;
	}
	public void setActual(String actual) {
		this.actual = actual;
	}
	@Override
	public String toString() {
		return "Keyevent [event=" + event + ", planned=" + planned + ", actual=" + actual + "]";
	}
	
	
}
