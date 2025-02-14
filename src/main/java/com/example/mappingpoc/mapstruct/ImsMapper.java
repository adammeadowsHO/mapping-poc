package com.example.mappingpoc.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImsMapper {

    ImsMapper INSTANCE = Mappers.getMapper(ImsMapper.class);

    @Mapping(target = "caseNumberReference", source = "caseNumber")
    @Mapping(target = "personName", source = "name")
    ImsCreateCaseRequestDto map(CrimestoppersDto crimestoppersDto);
}
