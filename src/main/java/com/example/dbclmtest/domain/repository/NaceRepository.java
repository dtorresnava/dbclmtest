package com.example.dbclmtest.domain.repository;

import com.example.dbclmtest.domain.model.Nace;

import java.util.List;

public interface NaceRepository {

    Nace putNaceDetails(Nace nace);

    Nace getNaceDetails(Long order);

    List<Nace> setNaseDataDetails(List<Nace> naceList);


}
