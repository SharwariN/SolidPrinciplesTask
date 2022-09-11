package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.domain.ProjectDetailsDO;

@Repository
public interface ProjectManagementRepo extends JpaRepository<ProjectDetailsDO, Integer> {

}
