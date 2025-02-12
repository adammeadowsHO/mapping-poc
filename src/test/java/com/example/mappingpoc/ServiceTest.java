package com.example.mappingpoc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ServiceTest {
    private final static ImsMapper INSTANCE = Mappers.getMapper(ImsMapper.class);
    private final CaseCreationService underTest = new CaseCreationService(INSTANCE, new ObjectMapper());

    @Test
    void createCase() {

        var actual = underTest.createCase(new CrimestoppersDto(UUID.randomUUID(), "123456", "John"));

        assertThat(actual.getCaseNumberReference(), is("123456"));
        assertThat(actual.getPersonName(), is("John"));

    }
}