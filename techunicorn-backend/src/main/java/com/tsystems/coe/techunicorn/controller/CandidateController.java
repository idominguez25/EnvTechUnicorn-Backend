package com.tsystems.coe.techunicorn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.coe.techunicorn.dto.CandidateDTO;
import com.tsystems.coe.techunicorn.dto.InviteCandidateDTO;
import com.tsystems.coe.techunicorn.dto.SkillDTO;
import com.tsystems.coe.techunicorn.service.CandidateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

/**
 * Candidate REST Controller.
 */
@RestController
@RequiredArgsConstructor
@Api(value = "Controller for Candidates management.")
@RequestMapping("/candidates")
public class CandidateController extends AbstractCrudController<CandidateDTO, Long> {

	@Autowired
	private CandidateService candidateService;

	@PostMapping("/invite")
	@ApiOperation(value = "Invites a candidate to perform a test.", code = 200)
	public ResponseEntity<Void> inviteCandidate(final @RequestBody InviteCandidateDTO inviteCandidateDTO) {
		this.candidateService.inviteCandidate(inviteCandidateDTO.getCandidate(), inviteCandidateDTO.getTest().getId());
		return ResponseEntity.ok().build();
	}

	@PostMapping("/invite-by-skill")
	@ApiOperation(value = "Invites a candidate to perform a test by a given skill description or id.", code = 200)
	public ResponseEntity<Void> inviteCandidateBySkill(final @RequestBody InviteCandidateDTO inviteCandidateDTO) {
		List<SkillDTO> list = inviteCandidateDTO.getTest().getSkills();

		if (list != null && list.size() > 0) {
			this.candidateService.inviteCandidateBySkill(inviteCandidateDTO.getCandidate(), list.get(0));
		}
		return ResponseEntity.ok().build();
	}
}
