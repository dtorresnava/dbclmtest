package com.example.dbclmtest.application.service;

import com.example.dbclmtest.domain.model.Nace;
import com.example.dbclmtest.domain.repository.NaceRepository;
import com.example.dbclmtest.domain.service.NaceService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NaceServiceImpl implements NaceService {

    private final NaceRepository naceRepository;

    @Override
    public Nace putNaceDetails(Long order, Nace nace) {
        nace.setOrder(order);
        return naceRepository.putNaceDetails(nace);
    }

    @Override
    public Nace getNaceDetails(Long order) {
        return naceRepository.getNaceDetails(order);
    }
}
