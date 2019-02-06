package com.abbvie.cdrp.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class StudyInfoDTO {
	
	private String studyId;
	
	private ReferenceDTO referenceDTO;
	
	private List<KeyEventsDTO> keyEventsDTO;
	
	private Map<String,List<String>> personalAssignmentMap;
	
	private IDRPPlanDetailDTO idrpPlanDetailDTO;
}
