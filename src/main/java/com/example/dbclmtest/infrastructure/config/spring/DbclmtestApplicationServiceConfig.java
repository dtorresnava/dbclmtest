package com.example.dbclmtest.infrastructure.config.spring;

import com.example.dbclmtest.application.service.NaceCsvServiceImpl;
import com.example.dbclmtest.application.service.NaceServiceImpl;
import com.example.dbclmtest.domain.csv.NaceReadCsvFile;
import com.example.dbclmtest.domain.repository.NaceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbclmtestApplicationServiceConfig {

    @Bean
    public NaceServiceImpl naceService(NaceRepository naceRepository) {
        return new NaceServiceImpl(naceRepository);
    }

    @Bean
    public NaceCsvServiceImpl naceCsvService(NaceReadCsvFile naceReadCsvFile, NaceRepository naceRepository) {
        return new NaceCsvServiceImpl(naceReadCsvFile, naceRepository);
    }
}
