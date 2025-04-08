package com.tsystems.coe.techunicorn.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tsystems.coe.techunicorn.client.dto.AssessmentVO;
import com.tsystems.coe.techunicorn.domain.Assessment;

/**
 * 
 * Assessment feign mapper interface.
 *
 */
@Mapper(config = BaseMapperConfig.class)
public interface AssessmentFeignMapper extends BaseMapper<Assessment, AssessmentVO> {

	@Override
	@Mapping(source = "id", target = "providerId")
	@Mapping(target = "id", ignore = true)
	@Mapping(source = "score.scoredPoints", target = "scoredPoints")
	@Mapping(source = "score.maxPoints", target = "maxPoints")
	@Mapping(source = "score.percentage", target = "percentage")
	Assessment dtoToDomain(AssessmentVO dto);

	@Override
	@InheritInverseConfiguration
	AssessmentVO domainToDto(Assessment entidad);

}
