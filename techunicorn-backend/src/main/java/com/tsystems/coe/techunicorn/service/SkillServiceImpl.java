package com.tsystems.coe.techunicorn.service;

import org.springframework.stereotype.Service;

import com.tsystems.coe.techunicorn.domain.Skill;
import com.tsystems.coe.techunicorn.dto.SkillDTO;
import com.tsystems.coe.techunicorn.repository.SkillRepository;

/**
 * Skill Service implementation.
 */
@Service
public class SkillServiceImpl extends AbstractCrudService<Skill, Long, SkillRepository, SkillDTO>
		implements SkillService {

}
