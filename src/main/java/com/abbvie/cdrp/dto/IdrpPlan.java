package com.abbvie.cdrp.dto;

public class IdrpPlan {

	private String planOwner; 
	private String planVersion;
	private String createdDate;
	private String lastModified;
	private String approvalDate;
	
	public IdrpPlan()
	{
		
	}
	
	public IdrpPlan(String po, String pv, String cd, String lm, String ad)
	{
		this.planOwner = po;
		this.planVersion = pv;
		this.createdDate = cd;
		this.lastModified = lm;
		this.approvalDate = ad;
	}
	
	public String getPlanOwner() {
		return planOwner;
	}
	public void setPlanOwner(String planOwner) {
		this.planOwner = planOwner;
	}
	public String getPlanVersion() {
		return planVersion;
	}
	public void setPlanVersion(String planVersion) {
		this.planVersion = planVersion;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public String getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	@Override
	public String toString() {
		return "IdrpPlan [planOwner=" + planOwner + ", planVersion=" + planVersion + ", createdDate=" + createdDate
				+ ", lastModified=" + lastModified + ", approvalDate=" + approvalDate + "]";
	}
	
	
}
