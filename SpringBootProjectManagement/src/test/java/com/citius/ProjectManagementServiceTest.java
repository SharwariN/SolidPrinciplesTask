package com.citius;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.dao.ProjectManagementRepo;
import com.cts.domain.ProjectDetailsDO;
import com.cts.exception.ProjectManagementException;
import com.cts.service.ProjectMangementService;

@SpringBootTest
class ProjectManagementServiceTest {

	@Autowired
	private ProjectMangementService mangementService;

	@MockBean
	private ProjectManagementRepo managementRepo;

	@Test
	void testSaveOrUpdateProjectDetails() throws ProjectManagementException {
		ProjectDetailsDO detailsDO = new ProjectDetailsDO(1, "Project1", 300000.0, 8, 200, new Date(), "Abhishek");
		when(managementRepo.save(detailsDO)).thenReturn(detailsDO);
		assertThat(mangementService.saveOrUpdateProjectDetails(detailsDO), is(equalTo(detailsDO)));
	}

	@Test
	void testGetProjectById() {
		Optional<ProjectDetailsDO> detailsDO = Optional.of(new ProjectDetailsDO(1, "Project1", 300000.0, 8, 200, new Date(), "Abhishek"));
		when(managementRepo.findById(1)).thenReturn(detailsDO);
		assertThat(mangementService.findById(1), is(equalTo(detailsDO)));
	}

	@Test
	void testGetAllProjects() {
		ProjectDetailsDO detailsDO = new ProjectDetailsDO(1, "Project1", 300000.0, 8, 200, new Date(), "Abhishek");
		ProjectDetailsDO detailsDO2 = new ProjectDetailsDO(2, "CT_Project", 200000.0, 10, 210, new Date(), "Atanu");

		List<ProjectDetailsDO> detailsDOs = new LinkedList<>();
		detailsDOs.add(detailsDO2);
		detailsDOs.add(detailsDO);

		when(managementRepo.findAll()).thenReturn(detailsDOs);
		assertThat(mangementService.listProjectDetails(), is(equalTo(detailsDOs)));
	}

	@Test
	void testDeleteProject() {
		Optional<ProjectDetailsDO> detailsDO = Optional
				.of(new ProjectDetailsDO(1, "Project1", 300000.0, 8, 200, new Date(), "Abhishek"));
		when(managementRepo.findById(1)).thenReturn(detailsDO);
		when(managementRepo.existsById(detailsDO.get().getProjectId())).thenReturn(false);
		assertFalse(managementRepo.existsById(detailsDO.get().getProjectId()));

	}

	@Test
	void testUpdateProject() throws ProjectManagementException {
		Optional<ProjectDetailsDO> detailsDO = Optional
				.of(new ProjectDetailsDO(1, "Project1", 300000.0, 8, 200, new Date(), "Abhishek"));
		when(managementRepo.findById(1)).thenReturn(detailsDO);

		detailsDO.get().setBudget(25000.0);
		ProjectDetailsDO detailsDO2 = detailsDO.get();
		when(managementRepo.save(detailsDO.get())).thenReturn(detailsDO2);

		assertThat(mangementService.saveOrUpdateProjectDetails(detailsDO.get()), is(equalTo(detailsDO2)));
	}
}
