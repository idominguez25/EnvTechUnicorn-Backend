package com.tsystems.coe.techunicorn.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import com.tsystems.coe.techunicorn.client.dto.AssessmentVO;
import com.tsystems.coe.techunicorn.client.dto.ScoreVO;
import com.tsystems.coe.techunicorn.client.dto.enums.AssessmentStatus;
import com.tsystems.coe.techunicorn.domain.Assessment;
import com.tsystems.coe.techunicorn.domain.Candidate;

public class AssessmentData {

	public final static long ASSESSMENT_ID = 10L;
	public final static long CANDIDATE_ID = 20L;
	public final static String ASSESSMENT_PROVIDER_ID = "1111-abcd-efgh-ijkl-1111";
	public final static String CANDIDATE_PROVIDER_ID = "2222-abcd-efgh-ijkl-2222";
	public final static String CANDIDATE_EMAIL = "cristian.requena@t-systems.com";

	// Provider assessment data.
	public final static ZonedDateTime ASSESSMENT_START_DATE = ZonedDateTime.now();
	public final static ZonedDateTime ASSESSMENT_FINISH_DATE = ZonedDateTime.now();
	public final static int ASSESSMENT_TIME_LIMIT = 120;
	public final static int ASSESSMENT_TIME_TAKEN = 110;
	public final static int ASSESSMENT_SCORE_POINTS = 25;
	public final static int ASSESSMENT_SCORE_MAX_POINTS = 50;
	public final static int ASSESSMENT_SCORE_MAX_PERCENTAGE = 50;

	@Bean
	@Qualifier("newAssessmentList")
	public List<Assessment> assessmentsList1() {
		List<Assessment> assessments = new ArrayList<>();
		Assessment assessment = new Assessment();
		assessments.add(assessment);
		assessment.setCandidate(this.candidate());
		assessment.setId(ASSESSMENT_ID);
		assessment.setProviderId(ASSESSMENT_PROVIDER_ID);
		assessment.setStatus(AssessmentStatus.NEW);

		return assessments;
	}

	@Bean
	public Candidate candidate() {
		Candidate candidate = new Candidate();
		candidate.setId(CANDIDATE_ID);
		candidate.setProviderId(CANDIDATE_PROVIDER_ID);
		candidate.setEmail(CANDIDATE_EMAIL);
		return candidate;
	}

	/**
	 * Used as return value from the provider WS.
	 * 
	 * @return Instance of AssessmentVO.
	 */
	@Bean
	@Qualifier("updatedAssessment")
	public AssessmentVO updatedAssessment() {
		AssessmentVO assessmentVo = new AssessmentVO();
		assessmentVo.setId(ASSESSMENT_PROVIDER_ID);
		assessmentVo.setScore(
				new ScoreVO(ASSESSMENT_SCORE_POINTS, ASSESSMENT_SCORE_MAX_POINTS, ASSESSMENT_SCORE_MAX_PERCENTAGE));
		assessmentVo.setStatus(AssessmentStatus.ASSESSMENT_COMPLETED);

		assessmentVo.setStartDate(ASSESSMENT_START_DATE);
		assessmentVo.setFinishDate(ASSESSMENT_FINISH_DATE);

		assessmentVo.setTimeLimitInSeconds(ASSESSMENT_TIME_LIMIT);
		assessmentVo.setTimeTakenInSeconds(ASSESSMENT_TIME_TAKEN);
		return assessmentVo;
	}

	/**
	 * Used as instance to be persisted with updated information from the provider.
	 * 
	 * @return Instance of Assessment.
	 */
	@Bean
	@Qualifier("persistedAssessment")
	public Assessment persistedAssessment() {
		Assessment assessment = new Assessment();
		assessment.setId(ASSESSMENT_ID);
		assessment.setProviderId(ASSESSMENT_PROVIDER_ID);
		assessment.setScoredPoints(ASSESSMENT_SCORE_POINTS);
		assessment.setMaxPoints(ASSESSMENT_SCORE_MAX_POINTS);
		assessment.setPercentage(ASSESSMENT_SCORE_MAX_PERCENTAGE);

		assessment.setStatus(AssessmentStatus.ASSESSMENT_COMPLETED);

		assessment.setStartDate(ASSESSMENT_START_DATE);
		assessment.setFinishDate(ASSESSMENT_FINISH_DATE);

		assessment.setTimeLimitInSeconds(ASSESSMENT_TIME_LIMIT);
		assessment.setTimeTakenInSeconds(ASSESSMENT_TIME_TAKEN);

		assessment.setCandidate(this.candidate());
		return assessment;
	}

}
