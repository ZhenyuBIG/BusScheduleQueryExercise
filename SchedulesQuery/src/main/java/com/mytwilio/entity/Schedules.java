package com.mytwilio.entity;

public class Schedules {

	private byte id;
	private String route;
	private String stop;
	private String time;
	
	public Schedules(){}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getStop() {
		return stop;
	}

	public void setStop(String stop) {
		this.stop = stop;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Schedules [id=" + id + ", route=" + route + ", stop=" + stop + ", time=" + time + "]";
	}

}
