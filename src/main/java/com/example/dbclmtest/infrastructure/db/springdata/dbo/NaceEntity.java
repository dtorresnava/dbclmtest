package com.example.dbclmtest.infrastructure.db.springdata.dbo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "NACE")
@Getter
@Setter
@NoArgsConstructor
public class NaceEntity implements Serializable {
    @Id
    private Long naceOrder;
    private Integer level;
    private String code;
    private String parent;
    @Column(length = 20000)
    private String description;
    @Column(length = 20000)
    private String thisItemIncludes;
    @Column(length = 20000)
    private String thisItemAlsoIncludes;
    @Column(length = 20000)
    private String rulings;
    @Column(length = 20000)
    private String thisItemExcludes;
    private String referenceToIsicRev;
}
