package com.tsystems.coe.techunicorn.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.tsystems.coe.techunicorn.domain.Assessment;
import com.tsystems.coe.techunicorn.dto.AssessmentDTO;

/**
 * 
 * Assessment mapper interface.
 *
 */
@Mapper(config = BaseMapperConfig.class)
public interface AssessmentMapper extends BaseMapper<Assessment, AssessmentDTO> {

	@Override
	Assessment dtoToDomain(AssessmentDTO dto);

	@Override
	@InheritInverseConfiguration
	AssessmentDTO domainToDto(Assessment entidad);

}
