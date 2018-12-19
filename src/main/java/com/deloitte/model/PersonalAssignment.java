package com.deloitte.model;

public class PersonalAssignment {

	private String clinicalDataReviewer ;
	private String clinicalSafetyAnalyst;
	private String remoteMonitor;
	private String stats;
	private String studyProjectManager;
	private String studyManagerAssociate;
	private String taMd;
	private String dataSciencesProjectLead;
	
	public PersonalAssignment()
	{
		
	}
	public PersonalAssignment(String cdr, String csa, String rm, String s, String spm, String sma, String t, String dspl )
	{
		this.clinicalDataReviewer = cdr;
		this.clinicalSafetyAnalyst = csa;
		this.remoteMonitor = rm;
		this.stats=s;
		this.studyProjectManager = spm;
		this.studyManagerAssociate = sma;
		this.taMd = t;
		this.dataSciencesProjectLead = dspl;
	}
	
	public String getClinicalDataReviewer() {
		return clinicalDataReviewer;
	}
	public void setClinicalDataReviewer(String clinicalDataReviewer) {
		this.clinicalDataReviewer = clinicalDataReviewer;
	}
	public String getClinicalSafetyAnalyst() {
		return clinicalSafetyAnalyst;
	}
	public void setClinicalSafetyAnalyst(String clinicalSafetyAnalyst) {
		this.clinicalSafetyAnalyst = clinicalSafetyAnalyst;
	}
	public String getRemoteMonitor() {
		return remoteMonitor;
	}
	public void setRemoteMonitor(String remoteMonitor) {
		this.remoteMonitor = remoteMonitor;
	}
	public String getStats() {
		return stats;
	}
	public void setStats(String stats) {
		this.stats = stats;
	}
	public String getStudyProjectManager() {
		return studyProjectManager;
	}
	public void setStudyProjectManager(String studyProjectManager) {
		this.studyProjectManager = studyProjectManager;
	}
	public String getStudyManagerAssociate() {
		return studyManagerAssociate;
	}
	public void setStudyManagerAssociate(String studyManagerAssociate) {
		this.studyManagerAssociate = studyManagerAssociate;
	}
	public String getTaMd() {
		return taMd;
	}
	public void setTaMd(String taMd) {
		this.taMd = taMd;
	}
	public String getDataSciencesProjectLead() {
		return dataSciencesProjectLead;
	}
	public void setDataSciencesProjectLead(String dataSciencesProjectLead) {
		this.dataSciencesProjectLead = dataSciencesProjectLead;
	}
	@Override
	public String toString() {
		return "PersonalAssignment [clinicalDataReviewer=" + clinicalDataReviewer + ", clinicalSafetyAnalyst="
				+ clinicalSafetyAnalyst + ", remoteMonitor=" + remoteMonitor + ", stats=" + stats
				+ ", studyProjectManager=" + studyProjectManager + ", studyManagerAssociate=" + studyManagerAssociate
				+ ", taMd=" + taMd + ", dataSciencesProjectLead=" + dataSciencesProjectLead + "]";
	}
	
	
}
