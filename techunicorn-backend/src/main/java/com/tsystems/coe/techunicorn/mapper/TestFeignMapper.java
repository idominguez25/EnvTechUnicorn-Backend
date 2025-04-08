package com.tsystems.coe.techunicorn.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tsystems.coe.techunicorn.client.dto.TestVO;
import com.tsystems.coe.techunicorn.domain.Skill;
import com.tsystems.coe.techunicorn.domain.Test;

/**
 * 
 * Test feign mapper interface.
 *
 */
@Mapper(config = BaseMapperConfig.class)
public interface TestFeignMapper extends BaseMapper<Test, TestVO> {

	@Override
	@Mapping(source = "id", target = "providerId")
	@Mapping(target = "id", ignore = true)
	Test dtoToDomain(TestVO dto);

	@Override
	TestVO domainToDto(Test entidad);

	default Skill fromStringToSkill(final String skill) {
		Skill skill1 = new Skill(null, skill);
		return skill1;
	}

	default String fromSkillToString(final Skill skill) {
		return skill == null ? null : skill.getName();
	}
}
