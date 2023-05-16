package com.example.dbclmtest;

import com.example.dbclmtest.application.service.NaceServiceImpl;
import com.example.dbclmtest.data.NaceData;
import com.example.dbclmtest.domain.model.Nace;
import com.example.dbclmtest.domain.repository.NaceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class NaceDetailServiceTest {

    NaceServiceImpl naceService;

    @Mock
    private NaceRepository naceRepository;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        naceService = new NaceServiceImpl(naceRepository);
    }

    @Tag("Get Nace details by order id")
    @Test
    void getAllProductPriceTest() {
        Nace naceData = NaceData.getNaceDetails(0);
        Mockito.when(naceRepository.getNaceDetails(398481L)).thenReturn(naceData);
        Nace priceResultList = naceService.getNaceDetails(398481L);

        Assertions.assertEquals(priceResultList.getDescription(), naceData.getDescription());
        Assertions.assertEquals(priceResultList.getOrder(), naceData.getOrder());
    }
}
