package com.example.hps.response;

import java.time.LocalTime;



public class SessionResponse {
	
	private long idsession;
	private String nomsession;
	private LocalTime heureD;
	private LocalTime heureF;
	
	public long getIdsession() {
		return idsession;
	}
	public void setIdsession(long idsession) {
		this.idsession = idsession;
	}
	public String getNomsession() {
		return nomsession;
	}
	public void setNomsession(String nomsession) {
		this.nomsession = nomsession;
	}
	public LocalTime getHeureD() {
		return heureD;
	}
	public void setHeureD(LocalTime heureD) {
		this.heureD = heureD;
	}
	public LocalTime getHeureF() {
		return heureF;
	}
	public void setHeureF(LocalTime heureF) {
		this.heureF = heureF;
	}


	
}
