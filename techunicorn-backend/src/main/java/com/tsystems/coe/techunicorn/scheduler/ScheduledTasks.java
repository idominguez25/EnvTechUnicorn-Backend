package com.tsystems.coe.techunicorn.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tsystems.coe.techunicorn.service.AssessmentService;
import com.tsystems.coe.techunicorn.service.CandidateService;

import lombok.extern.log4j.Log4j2;

/**
 * Class to create tasks that must be scheduled.
 */
@Component
@Log4j2
public class ScheduledTasks {

	@Autowired
	private AssessmentService assessmentService;

	@Autowired
	private CandidateService candidateService;

	/**
	 * Checks the pending assessments.
	 */
	@Scheduled(cron = "${assessments.sync.interval}")
	public void assessmentsCheck() {
		log.info("Checking pending assessments.");

		// Check the pending assessments, and update if needed.
		this.assessmentService.checkPending();

	}

	/**
	 * Prune the candidates older than a given value.
	 */
	@Scheduled(cron = "${assessments.prune.interval}")
	public void prune() {
		log.info("Pruning assessments.");

		this.assessmentService.prune();
		this.candidateService.prune();
	}

}
