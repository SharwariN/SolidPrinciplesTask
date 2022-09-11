package com.cts.dto;

import java.util.Date;

public class ProjectDetails {

	public ProjectDetails() {
	}

	public ProjectDetails(Integer projectId, String title, Double budget, Integer teamSize, Integer duration,
			Date endDate, String managerName) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.budget = budget;
		this.teamSize = teamSize;
		this.duration = duration;
		this.endDate = endDate;
		this.managerName = managerName;
	}

	private Integer projectId;

	private String title;

	private Double budget;

	private Integer teamSize;

	private Integer duration;

	private Date endDate;

	private String managerName;

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Integer getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Override
	public String toString() {
		return "ProjectDetailsDTO [projectId=" + projectId + ", title=" + title + ", budget=" + budget + ", teamSize="
				+ teamSize + ", duration=" + duration + ", endDate=" + endDate + ", managerName=" + managerName + "]";
	}

}
