package com.abbvie.cdrp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abbvie.cdrp.dto.Details;
import com.abbvie.cdrp.dto.Study;


@RestController
public class Controller1 {

	List<Study> studies = new ArrayList<Study>();
	Study s1= new Study("MZ-070","Days until Lorem IpsumIpsum loerem ips Lorem IpsumIpsum loerem ips","2","19th Oct 2018","10","45","IDRP V2 Approved");
	Study s3= new Study("MZ-080","","","","","","");
	Study s2= new Study("MZ-060","Days until Lorem IpsumIpsum loerem ips ","3","19th Oct 2018","5","12","IDRP V1 Approved");
	Study s4= new Study("MZ-090","","","","","","");
	
	
	List<Details> details = new ArrayList<Details>();
	Details d1= new Details("6","4","7","55","8","15","250","150","2","7");
	Details d2= new Details("2","8","9","15","4","10","400","100","5","9");
	Details d3= new Details("--","--","--","--","--","--","","","",""); 
	public Controller1() {
		
		 add();

	}
	
	public void add()
	{
		studies.add(s1);
		studies.add(s2);
		studies.add(s3);
		studies.add(s4);
		details.add(d1);
		details.add(d2);
		details.add(d3);
		details.add(d3);
	}
	
	@CrossOrigin(value="*")
	@RequestMapping(value = "/getstudy", method = RequestMethod.GET)
		public List<Study> getNotes() {
		System.out.println("HEREEEEEEEEEEEEEEEEEEE");
		System.out.println(studies);
				System.out.println(studies.size());
		return studies;
}
	
	@CrossOrigin(value="*")
	@RequestMapping(value = "/getdetails", method = RequestMethod.GET)
		public List<Details> getdetail() {
				System.out.println(details.size());
		return details;
}
	
}
