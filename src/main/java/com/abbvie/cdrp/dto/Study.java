package com.abbvie.cdrp.dto;

public class Study {
	
	private String Studyid;
	private String description;
	private String due;
	private String date;
	private String unreviewed;
	private String pending;
	private String idrp;
	
	public Study(String id , String desc , String due , String date ,String unreview , String pend , String idrp){
		this.Studyid =id;
		this.description =desc;
		this.due =due;
		this.date=date;
		this.unreviewed=unreview;
		this.pending=pend;
		this.idrp=idrp;
		
	}
	public String getStudyid() {
		return Studyid;
	}
	public void setStudyid(String studyid) {
		Studyid = studyid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDue() {
		return due;
	}
	public void setDue(String due) {
		this.due = due;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUnreviewed() {
		return unreviewed;
	}
	public void setUnreviewed(String unreviewed) {
		this.unreviewed = unreviewed;
	}
	public String getPending() {
		return pending;
	}
	public void setPending(String pending) {
		this.pending = pending;
	}
	public String getIdrp() {
		return idrp;
	}
	public void setIdrp(String idrp) {
		this.idrp = idrp;
	}
}
