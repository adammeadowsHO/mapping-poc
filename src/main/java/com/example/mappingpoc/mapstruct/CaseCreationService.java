package com.example.mappingpoc.mapstruct;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@RequiredArgsConstructor
@Log
public class CaseCreationService {
    private final ObjectMapper objectMapper;

    public ImsCreateCaseRequestDto createCase(CrimestoppersDto crimestoppersDto) {

        log.info("Crimestoppers to java object: " + crimestoppersDto.toString());
        log.info("Crimestoppers to json: " + objectMapper.valueToTree(crimestoppersDto));

        var mapped = ImsMapper.INSTANCE.map(crimestoppersDto);

        log.info("Mapped to java object: " + mapped.toString());
        log.info("Mapped to json: " + objectMapper.valueToTree(mapped));

        return mapped;
    }
}
