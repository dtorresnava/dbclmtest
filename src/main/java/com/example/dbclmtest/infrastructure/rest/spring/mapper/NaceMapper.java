package com.example.dbclmtest.infrastructure.rest.spring.mapper;

import com.example.dbclmtest.domain.model.Nace;
import com.example.dbclmtest.infrastructure.rest.spring.dto.NaceRequest;
import com.example.dbclmtest.infrastructure.rest.spring.dto.NaceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NaceMapper {
    NaceResponse naceResponseToNace(Nace nace);

    Nace naceToNaceRequest(NaceRequest naceRequest);
}
