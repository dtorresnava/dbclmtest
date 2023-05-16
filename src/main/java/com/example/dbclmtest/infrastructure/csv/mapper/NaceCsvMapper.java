package com.example.dbclmtest.infrastructure.csv.mapper;

import com.example.dbclmtest.domain.model.Nace;
import com.example.dbclmtest.infrastructure.csv.dbo.NaceCsvEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NaceCsvMapper {
    Nace naceToNaceCsvEntity(NaceCsvEntity naceCsvEntity);
}
