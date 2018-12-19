package com.deloitte.model;

import java.util.List;

public class StudyInfo {
	
	private String studyId;
	private Reference reference;
	private List<Keyevent> key;
	private PersonalAssignment personalAssign;
	private IdrpPlan idrp;
	
	public StudyInfo()
	{
		this.studyId = "MZ-123076";
		this.reference = new Reference();
		this.personalAssign = new PersonalAssignment();
		this.idrp = new IdrpPlan();
		
		
	}
	
	public StudyInfo(String studyId, Reference r, List<Keyevent> k, PersonalAssignment p, IdrpPlan ip)
	{
		this.studyId = studyId;
		this.reference = r;
		this.key = k;
		this.personalAssign = p;
		this.idrp = ip;
		
	}

	public String getStudyId() {
		return studyId;
	}

	public void setStudyId(String studyId) {
		this.studyId = studyId;
	}

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	public List<Keyevent> getKey() {
		return key;
	}

	public void setKey(List<Keyevent> key) {
		this.key = key;
	}

	public PersonalAssignment getPersonalAssign() {
		return personalAssign;
	}

	public void setPersonalAssign(PersonalAssignment personalAssign) {
		this.personalAssign = personalAssign;
	}
	

	public IdrpPlan getIdrp() {
		return idrp;
	}

	public void setIdrp(IdrpPlan idrp) {
		this.idrp = idrp;
	}

	@Override
	public String toString() {
		return "Data [studyId=" + studyId + ", reference=" + reference + ", key=" + key + ", personalAssign="
				+ personalAssign + ", idrp=" + idrp + "]";
	}

	

	
	
}
