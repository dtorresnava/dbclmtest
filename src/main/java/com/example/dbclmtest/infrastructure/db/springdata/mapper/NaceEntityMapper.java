package com.example.dbclmtest.infrastructure.db.springdata.mapper;

import com.example.dbclmtest.domain.model.Nace;
import com.example.dbclmtest.infrastructure.db.springdata.dbo.NaceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NaceEntityMapper {

    @Mapping(target = "naceOrder", source = "order")
    NaceEntity naceEntityToNace(Nace nace);

    @Mapping(target = "order", source = "naceOrder")
    Nace naceyToNaceEntity(NaceEntity naceEntity);
}
