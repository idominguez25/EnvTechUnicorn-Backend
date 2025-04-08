package com.tsystems.coe.techunicorn.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.tsystems.coe.techunicorn.domain.Skill;
import com.tsystems.coe.techunicorn.dto.SkillDTO;

/**
 * Skill mapper interface.
 */
@Mapper(config = BaseMapperConfig.class)
public interface SkillMapper extends BaseMapper<Skill, SkillDTO> {

	@Override
	Skill dtoToDomain(SkillDTO dto);

	@Override
	@InheritInverseConfiguration
	SkillDTO domainToDto(Skill entidad);

}
