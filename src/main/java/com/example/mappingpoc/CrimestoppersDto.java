package com.example.mappingpoc;

import lombok.Value;

import java.util.UUID;

@Value
public class CrimestoppersDto {

    UUID caseId;
    String caseNumber;
    String name;

}
