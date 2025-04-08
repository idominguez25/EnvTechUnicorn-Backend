package com.tsystems.coe.techunicorn.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.tsystems.coe.techunicorn.domain.Candidate;
import com.tsystems.coe.techunicorn.dto.CandidateDTO;

/**
 * 
 * Candidate mapper interface.
 *
 */
@Mapper(config = BaseMapperConfig.class, uses = { AssessmentMapperImpl.class })
public interface CandidateMapper extends BaseMapper<Candidate, CandidateDTO> {

	@Override
	Candidate dtoToDomain(CandidateDTO dto);

	@Override
	@InheritInverseConfiguration
	CandidateDTO domainToDto(Candidate entidad);

}
