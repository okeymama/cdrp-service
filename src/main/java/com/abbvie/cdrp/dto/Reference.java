package com.abbvie.cdrp.dto;

public class Reference {
	
	private String theraputicArea;
	public String compound;
	public String indication;
	public String fullProtocaltitle;
	public String studyStatus;
	public String studyPhase;
	public String studyType;
	
	public Reference()
	{
		this.theraputicArea = "TA1, TA2,..";
		this.compound = "compound1,compound2";
		this.indication = "Indication1, Indication2";
		this.fullProtocaltitle = "A Phase Ib, Open-Label Study Evaluating the"
				+ " Safety and Pharmacokinetics of GDC-0199 (ABT-199) in Combination"
				+ " With Bendamustine/Rituximab (BR) or Bendamustine + Obinutuzumab (BG) "
				+ "in Patients With Relapsed/Refractory or Previously Untreated Chronic"
				+ " Lymphocytic Leukemia";
		this.studyPhase = "Auto populated";
		this.studyStatus = "Auto populated";
		this.studyType = "Auto populated";
	}
	
	public Reference(String t, String c, String i, String f, String ss, String sp, String st)
	{
		this.theraputicArea = t;
		this.compound = c;
		this.indication = i;
		this.fullProtocaltitle = f;
		this.studyPhase = sp;
		this.studyStatus = ss;
		this.studyType = st;
	}
	
	

	@Override
	public String toString() {
		return "Reference [theraputicArea=" + theraputicArea + ", compound=" + compound + ", indication=" + indication
				+ ", fullProtocaltitle=" + fullProtocaltitle + ", studyStatus=" + studyStatus + ", studyPhase="
				+ studyPhase + ", studyType=" + studyType + "]";
	}



	public String getTheraputicArea() {
		return theraputicArea;
	}



	public void setTheraputicArea(String theraputicArea) {
		this.theraputicArea = theraputicArea;
	}



	public String getCompound() {
		return compound;
	}



	public void setCompound(String compound) {
		this.compound = compound;
	}



	public String getIndication() {
		return indication;
	}



	public void setIndication(String indication) {
		this.indication = indication;
	}



	public String getFullProtocaltitle() {
		return fullProtocaltitle;
	}



	public void setFullProtocaltitle(String fullProtocaltitle) {
		this.fullProtocaltitle = fullProtocaltitle;
	}



	public String getStudyStatus() {
		return studyStatus;
	}



	public void setStudyStatus(String studyStatus) {
		this.studyStatus = studyStatus;
	}



	public String getStudyPhase() {
		return studyPhase;
	}



	public void setStudyPhase(String studyPhase) {
		this.studyPhase = studyPhase;
	}



	public String getStudyType() {
		return studyType;
	}



	public void setStudyType(String studyType) {
		this.studyType = studyType;
	}
	
	
}
