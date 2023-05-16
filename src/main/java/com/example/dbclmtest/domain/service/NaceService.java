package com.example.dbclmtest.domain.service;

import com.example.dbclmtest.domain.model.Nace;

public interface NaceService {

    Nace putNaceDetails(Long order, Nace nace);

    Nace getNaceDetails(Long order);
}
