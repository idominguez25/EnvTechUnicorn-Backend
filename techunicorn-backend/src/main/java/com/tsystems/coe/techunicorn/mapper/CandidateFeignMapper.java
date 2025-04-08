package com.tsystems.coe.techunicorn.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tsystems.coe.techunicorn.client.dto.CandidateVO;
import com.tsystems.coe.techunicorn.domain.Candidate;

/**
 * 
 * Candidate feign mapper interface.
 *
 */
@Mapper(config = BaseMapperConfig.class)
public interface CandidateFeignMapper extends BaseMapper<Candidate, CandidateVO> {

	@Override
	@Mapping(source = "id", target = "providerId")
	@Mapping(target = "id", ignore = true)
	Candidate dtoToDomain(CandidateVO dto);

	@Override
	@InheritInverseConfiguration
	CandidateVO domainToDto(Candidate entidad);

}
