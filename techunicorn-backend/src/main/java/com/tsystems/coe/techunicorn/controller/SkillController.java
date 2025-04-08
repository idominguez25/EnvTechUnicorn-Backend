package com.tsystems.coe.techunicorn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.coe.techunicorn.dto.SkillDTO;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

/**
 * Skill REST Controller.
 */
@RestController
@RequiredArgsConstructor
@Api(value = "Controller for Skills management.")
@RequestMapping("/skills")
public class SkillController extends AbstractCrudController<SkillDTO, Long> {

}
