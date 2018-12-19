package com.abbvie.cdrp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abbvie.cdrp.dto.IdrpPlan;
import com.abbvie.cdrp.dto.Keyevent;
import com.abbvie.cdrp.dto.PersonalAssignment;
import com.abbvie.cdrp.dto.Reference;
import com.abbvie.cdrp.dto.StudyInfo;


@CrossOrigin(value="*")
@RestController
@Component
public class Controller {

	Reference r1 = new Reference("TA1, TA2,..","compound1,compound2","Indication1, Indication2",
			"A Phase Ib, Open-Label Study Evaluating the " + 
			"Safety and Pharmacokinetics of GDC-0199 (ABT-199) in Combination " + 
			"With Bendamustine/Rituximab (BR) or Bendamustine + Obinutuzumab (BG) " + 
			"in Patients With Relapsed/Refractory or Previously Untreated Chronicn " + 
			"Lymphocytic Leukemia","Auto populated","Auto populated","Auto populated");
	
	Reference r2 = new Reference("TB1, TB2,..","compound-A1,compound-A2","Indication-A1, Indication-A2",
			"A Phase Ib, Open-Label Study Evaluating the " + 
			"Safety and Pharmacokinetics of GDC-0199 (ABT-199) in Combination " + 
			"With Bendamustine/Rituximab (BR) or Bendamustine + Obinutuzumab (BG) " + 
			"in Patients With Relapsed/Refractory or Previously Untreated Chronic " + 
			"Lymphocytic Leukemia","Auto populated second","Auto populated second","Auto populated second");
	
	
	Keyevent k1 = new Keyevent("FSS", "auto populated", "auto populated");
	Keyevent k2 = new Keyevent("FSFV", "auto populated", "auto populated");
	Keyevent k3 = new Keyevent("LSLV", "auto populated", "auto populated");
	Keyevent k4 = new Keyevent("Database Lock", "auto populated", "auto populated");
	Keyevent k5 = new Keyevent("CSR", "auto populated", "auto populated");
	
	PersonalAssignment p1 = new PersonalAssignment("auto populated","auto populated","auto populated","auto populated",
			"auto populated","auto populated","auto populated","auto populated");
	
	IdrpPlan i1 = new IdrpPlan("John Smith", "Version 2: Approved", "John Smith, 25-Jun-2018","John Smith, 25-Jun-2018","John Smith, 25-Jun-2018");

	List<Keyevent> li = new ArrayList();
	

	Map<String, StudyInfo> map = new HashMap<>();
	
	
	public Controller()
	{
		add();
		StudyInfo d1 = new StudyInfo("MZ-123076", r1,li,p1,i1);
		StudyInfo d2 = new StudyInfo("MZ-123080", r2,li,p1,i1);
		
		map.put(d1.getStudyId(),d1 );
		map.put(d2.getStudyId(), d2);
	}
	
	public void add()
	{
		li.add(k1);
		li.add(k2);
		li.add(k3);
		li.add(k4);
		li.add(k5);
	
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/data")
	public StudyInfo getData()
	{
		StudyInfo d = new StudyInfo();
		System.out.println(d.getStudyId());
		System.out.println(d.getReference());
		return d;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getdata")
	public StudyInfo getData1(@RequestParam String id)
	{
		StudyInfo d;
		d = map.get(id);
		System.out.println(d);
		return d;
	}
	
}