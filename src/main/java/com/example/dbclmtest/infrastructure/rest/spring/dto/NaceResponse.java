package com.example.dbclmtest.infrastructure.rest.spring.dto;

import lombok.*;

@Data
public class NaceResponse {
    private Long order;
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
