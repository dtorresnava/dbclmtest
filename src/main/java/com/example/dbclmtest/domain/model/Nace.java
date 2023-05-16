package com.example.dbclmtest.domain.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Nace {
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
