package com.example.mappingpoc.mapstruct;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceTest {
    private final CaseCreationService underTest = new CaseCreationService(new ObjectMapper());

    @Test
    void createCase() {

        var actual = underTest.createCase(new CrimestoppersDto(UUID.randomUUID(), "123456", "John"));

        assertEquals("123456", actual.getCaseNumberReference());
        assertEquals("John", actual.getPersonName());

    }
}