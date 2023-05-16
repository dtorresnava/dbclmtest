package com.example.dbclmtest.application.service;

import com.example.dbclmtest.domain.csv.NaceReadCsvFile;
import com.example.dbclmtest.domain.model.Nace;
import com.example.dbclmtest.domain.repository.NaceRepository;
import com.example.dbclmtest.domain.service.NaceCsvService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NaceCsvServiceImpl implements NaceCsvService {

    private final NaceReadCsvFile naceReadCsvFile;
    private final NaceRepository naceRepository;
    @Override
    public List<Nace> setNaceDetails() {
        List<Nace> naceList = naceReadCsvFile.readNaceCsvFile();
        return naceRepository.setNaseDataDetails(naceList);
    }
}
