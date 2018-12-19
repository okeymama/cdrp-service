package com.abbvie.cdrp.dto;

public class Details {

	private String todo;
	private String follow;
	private String answered;
	private String open1;
	private String open2;
	private String action;
	private String critical;
	private String noncritical;
	private String due;
	private String overdue; 
	
	public Details(String to , String follow , String ans , String op1 ,String op2 , String action,String noncritical,String critical,String due,String overdue){
		this.todo =to;
		this.follow =follow;
		this.answered =ans;
		this.open1=op1;
		this.open2=op2;
		this.action=action;
		this.critical=critical;
		this.noncritical=noncritical;
		this.due=due;
		this.overdue=overdue; 
		
	}
	
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}
	public String getAnswered() {
		return answered;
	}
	public void setAnswered(String answered) {
		this.answered = answered;
	}
	public String getOpen1() {
		return open1;
	}
	public void setOpen1(String open1) {
		this.open1 = open1;
	}
	public String getOpen2() {
		return open2;
	}
	public void setOpen2(String open2) {
		this.open2 = open2;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	public String getCritical() {
		return critical;
	}

	public void setCritical(String critical) {
		this.critical = critical;
	}

	public String getNoncritical() {
		return noncritical;
	}

	public void setNoncritical(String noncritical) {
		this.noncritical = noncritical;
	}

	public String getDue() {
		return due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	public String getOverdue() {
		return overdue;
	}

	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	
}
