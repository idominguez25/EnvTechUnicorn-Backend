package com.tsystems.coe.techunicorn.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.tsystems.coe.techunicorn.domain.Test;
import com.tsystems.coe.techunicorn.dto.TestDTO;

/**
 * 
 * Test mapper interface.
 *
 */
@Mapper(config = BaseMapperConfig.class)
public interface TestMapper extends BaseMapper<Test, TestDTO> {

	@Override
	Test dtoToDomain(TestDTO dto);

	@Override
	@InheritInverseConfiguration
	TestDTO domainToDto(Test entidad);

}
