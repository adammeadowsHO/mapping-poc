package com.example.mappingpoc.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" )
public interface ImsMapper {

    @Mapping(target = "caseNumberReference", source = "caseNumber")
    @Mapping(target = "personName", source = "name")
    ImsCreateCaseRequestDto map(CrimestoppersDto crimestoppersDto);
}
