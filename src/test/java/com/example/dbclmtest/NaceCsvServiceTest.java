package com.example.dbclmtest;

import com.example.dbclmtest.application.service.NaceCsvServiceImpl;
import com.example.dbclmtest.data.NaceData;
import com.example.dbclmtest.domain.csv.NaceReadCsvFile;
import com.example.dbclmtest.domain.model.Nace;
import com.example.dbclmtest.domain.repository.NaceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

class NaceCsvServiceTest {
    NaceCsvServiceImpl naceCsvService;
    List<Nace> naceList;

    @Mock
    private NaceRepository naceRepository;

    @Mock
    private NaceReadCsvFile naceReadCsvFile;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        naceCsvService = new NaceCsvServiceImpl(naceReadCsvFile, naceRepository);

        naceList = NaceData.getListNaceDetails(20);

    }

    @Test
    void setDataFromCsv() {
        Mockito.when(naceReadCsvFile.readNaceCsvFile()).thenReturn(naceList);
        Mockito.when(naceRepository.setNaseDataDetails(naceList)).thenReturn(naceList);

        List<Nace> naceListResponse = naceCsvService.setNaceDetails();

        Assertions.assertFalse(naceListResponse.isEmpty());
        Assertions.assertEquals(20, naceListResponse.size());
    }
}
