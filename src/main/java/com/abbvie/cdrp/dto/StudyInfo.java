package com.abbvie.cdrp.dto;

import java.util.List;

public class StudyInfo {
	
	private String studyId;
	private Reference reference;
	private List<Keyevent> key;
	private PersonalAssignment personalAssign;
	private IDRPPlanDetailDTO idrpPlanDetailDTO;
	
	
	public StudyInfo(String studyId, Reference r, List<Keyevent> k, PersonalAssignment p, IDRPPlanDetailDTO ip)
	{
		this.studyId = studyId;
		this.reference = r;
		this.key = k;
		this.personalAssign = p;
		this.idrpPlanDetailDTO = ip;
		
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
	

	public IDRPPlanDetailDTO getIdrp() {
		return idrpPlanDetailDTO;
	}

	public void IDRPPlanDetailDTO(IDRPPlanDetailDTO idrp) {
		this.idrpPlanDetailDTO = idrp;
	}

	@Override
	public String toString() {
		return "Data [studyId=" + studyId + ", reference=" + reference + ", key=" + key + ", personalAssign="
				+ personalAssign + ", idrp=" + idrpPlanDetailDTO + "]";
	}

	

	
	
}
