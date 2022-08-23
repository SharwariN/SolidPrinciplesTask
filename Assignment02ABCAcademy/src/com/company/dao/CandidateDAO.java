package com.company.dao;

import java.util.LinkedList;
import java.util.List;

import com.company.model.CandidateReport;

public class CandidateDAO {

	private static List<CandidateReport> candidates = new LinkedList<>();
	
	public String addCandidate(CandidateReport candidate){
		try{
			candidates.add(candidate);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "Candidate details are successfully added.";
	}
	
	public List<CandidateReport> findAll(){
		return candidates;
	}
	
}
