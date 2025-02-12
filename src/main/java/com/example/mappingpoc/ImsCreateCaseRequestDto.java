package com.example.mappingpoc;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ImsCreateCaseRequestDto {

    String personName;
    @JsonProperty("ims-case-number-reference")
    String caseNumberReference; // using JsonProperty when serializing for IMS
}
