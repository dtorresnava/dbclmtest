package com.example.dbclmtest.infrastructure.csv.dbo;

import lombok.Data;

@Data
public class NaceCsvEntity {
    private String order;
    private String level;
    private String code;
    private String parent;
    private String description;
    private String thisItemIncludes;
    private String thisItemAlsoIncludes;
    private String rulings;
    private String thisItemExcludes;
    private String referenceToIsicRev;

}
