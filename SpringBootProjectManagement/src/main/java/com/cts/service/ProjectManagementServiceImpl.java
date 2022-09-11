package com.cts.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dao.ProjectManagementRepo;
import com.cts.domain.ProjectDetailsDO;
import com.cts.exception.ProjectManagementException;

@Service
@Transactional
public class ProjectManagementServiceImpl implements ProjectMangementService {

	@Autowired private ProjectManagementRepo projectManagementRepo;

	@Override
	public ProjectDetailsDO saveOrUpdateProjectDetails(ProjectDetailsDO detailsDO) throws ProjectManagementException{
		return projectManagementRepo.save(detailsDO);
	}

	@Override
	public void deleteProjectDetails(Integer projectId) throws ProjectManagementException{
		projectManagementRepo.deleteById(projectId);
	}

	@Override
	public List<ProjectDetailsDO> listProjectDetails() {
		return projectManagementRepo.findAll();
	}

	@Override
	public Optional<ProjectDetailsDO> findById(Integer projectId) {
		return projectManagementRepo.findById(projectId);
	}
}
