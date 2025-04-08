package com.tsystems.coe.techunicorn.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import com.tsystems.coe.techunicorn.client.DevSkillerClient;
import com.tsystems.coe.techunicorn.client.dto.AssessmentVO;
import com.tsystems.coe.techunicorn.domain.Assessment;
import com.tsystems.coe.techunicorn.repository.AssessmentRepository;

@ExtendWith(MockitoExtension.class)
@Import({ AssessmentData.class })
@SpringBootTest
public class AssessmentServiceTest {

	@Autowired
	private AssessmentService assessmentService;

	@MockBean
	private AssessmentRepository assessmentRepository;

	@MockBean
	private DevSkillerClient devSkillerClient;

	@Autowired
	@Qualifier("newAssessmentList")
	private List<Assessment> newAssessmentList;

	@Autowired
	@Qualifier("updatedAssessment")
	private AssessmentVO updatedAssessment;

	@Autowired
	@Qualifier("persistedAssessment")
	private Assessment persistedAssessment;

	@Test
	public void testCheckPending() {

		// Mocks setup.
		// The repository returns an assessment with NEW status.
		when(assessmentRepository.findByStatusIn(ArgumentMatchers.anyList())).thenReturn(newAssessmentList);
		// The provider feign client returns the same assessment, with a new status.
		when(devSkillerClient.getAssessment(ArgumentMatchers.eq(AssessmentData.CANDIDATE_PROVIDER_ID),
				ArgumentMatchers.eq(AssessmentData.ASSESSMENT_PROVIDER_ID))).thenReturn(updatedAssessment);

		// Invoke the business method.
		this.assessmentService.checkPending();

		// Assertions.
		verify(this.assessmentRepository, times(1)).save(persistedAssessment, persistedAssessment.getVersion());

	}
}
