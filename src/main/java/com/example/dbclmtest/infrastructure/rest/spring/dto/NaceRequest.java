package com.example.dbclmtest.infrastructure.rest.spring.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NaceRequest {
    private Integer level;
    private String code;
    private String parent;
    private String description;
    private String thisItemIncludes;
    private String thisItemAlsoIncludes;
    private String rulings;
    private String thisItemExcludes;
    private String referenceToIsicRev;
}
