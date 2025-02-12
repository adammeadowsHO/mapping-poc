package com.example.mappingpoc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class CaseCreationService {
    private final ImsMapper imsMapper;
    private final ObjectMapper objectMapper;

    public ImsCreateCaseRequestDto createCase(CrimestoppersDto crimestoppersDto) {

        log.info("Crimestoppers to java object: " + crimestoppersDto.toString());
        log.info("Crimestoppers to json: {}", objectMapper.valueToTree(crimestoppersDto));

        var mapped = imsMapper.map(crimestoppersDto);

        log.info("Mapped to java object: " + mapped.toString());
        log.info("Mapped to json: {}", objectMapper.valueToTree(mapped));

        return mapped;
    }
}
