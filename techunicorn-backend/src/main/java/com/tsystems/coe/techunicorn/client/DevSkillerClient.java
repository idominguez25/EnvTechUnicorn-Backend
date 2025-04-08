package com.tsystems.coe.techunicorn.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsystems.coe.techunicorn.client.config.DevSkillerConfiguration;
import com.tsystems.coe.techunicorn.client.dto.AssessmentVO;
import com.tsystems.coe.techunicorn.client.dto.CandidateVO;
import com.tsystems.coe.techunicorn.client.dto.CreateAssessmentVO;
import com.tsystems.coe.techunicorn.client.dto.CreateCandidateVO;
import com.tsystems.coe.techunicorn.client.dto.CreateInvitationVO;
import com.tsystems.coe.techunicorn.client.dto.GetCandidatesVO;
import com.tsystems.coe.techunicorn.client.dto.GetTestsVO;
import com.tsystems.coe.techunicorn.client.dto.InvitationVO;

@FeignClient(name = "DevSkillerClient", configuration = DevSkillerConfiguration.class, url = "${devskiller.api.url}")
public interface DevSkillerClient {

	/**
	 * A GET request will list all candidates.
	 * 
	 * @param page The page to gather.
	 * @return a list of all candidates by page.
	 */
	@GetMapping("/candidates")
	GetCandidatesVO getCandidates(@RequestParam("page") final int page);

	/**
	 * A GET request will retrieve the details of a candidate.
	 * 
	 * @param id candidate id.
	 * @return the details of a candidate.
	 */
	@GetMapping("/candidates/{candidateId}")
	CandidateVO getCandidate(@PathVariable("candidateId") final String id);

	/**
	 * Gathers the candidates that match a given criteria.
	 * 
	 * @param query Criteria to filter the candidates. It will be compared against
	 *              all the fields of the candidate.
	 * @return Filtered list of candidates.
	 */
	@GetMapping("/candidates")
	GetCandidatesVO findCandidates(@RequestParam("query") final String query);

	/**
	 * A POST request is used to create a new candidate.
	 * 
	 * @param newCandidate new candidate information.
	 * @return a new candidate.
	 */
	@PostMapping("/candidates")
	CandidateVO createCandidate(final CreateCandidateVO newCandidate);

	/**
	 * A DELETE request will remove a candidate.
	 * 
	 * @param id candidate id.
	 * @return 200 OK.
	 */
	@DeleteMapping("/candidates/{id}")
	CandidateVO deleteCandidate(@PathVariable("id") final String id);

	/**
	 * A GET request will retrieve the results for a candidate.
	 * 
	 * @param candidateId  candidate id.
	 * @param assessmentId assessment id.
	 * 
	 * @return the results for a candidate.
	 */
	@GetMapping("/candidates/{candidateId}/assessments/{assessmentId}")
	AssessmentVO getAssessment(@PathVariable("candidateId") final String candidateId,
			@PathVariable("assessmentId") final String assessmentId);

	/**
	 * A POST request is used to create an assessment. After successfully creating a
	 * candidate, an email with the invitation will be send to the candidate.
	 * 
	 * @param id            candidate id.
	 * @param newAssessment new assessment.
	 * @return new assessment.
	 */
	@PostMapping("/candidates/{id}/assessments")
	AssessmentVO createAssessment(@PathVariable("id") final String id, final CreateAssessmentVO newAssessment);

	/**
	 * A DELETE request will remove an assessment.
	 * 
	 * @param id           candidate id.
	 * @param assessmentId assessment id.
	 * 
	 * @return 200 OK.
	 */
	@DeleteMapping("/candidates/{id}/assessments/{assessmentId}")
	AssessmentVO deleteAssessment(@PathVariable("id") final String id,
			@PathVariable("assessmentId") final String assessmentId);

	/**
	 * A POST request is used to create an assessment. After successfully creating a
	 * candidate, an email with the invitation will be send to the candidate.
	 * 
	 * @param newInvitation new invitation information.
	 * @return new invitation.
	 */
	@PostMapping("/invitations")
	InvitationVO createInvitation(final CreateInvitationVO newInvitation);

	/**
	 * A GET request will list all tests.
	 * 
	 * @return a list of all tests.
	 */
	@GetMapping("/tests")
	GetTestsVO getTests();
}
