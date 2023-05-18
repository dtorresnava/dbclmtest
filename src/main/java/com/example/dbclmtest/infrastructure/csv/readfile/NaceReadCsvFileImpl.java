package com.example.dbclmtest.infrastructure.csv.readfile;

import com.example.dbclmtest.domain.csv.NaceReadCsvFile;
import com.example.dbclmtest.domain.model.Nace;
import com.example.dbclmtest.infrastructure.csv.dbo.NaceCsvEntity;
import com.example.dbclmtest.infrastructure.csv.mapper.NaceCsvMapper;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class NaceReadCsvFileImpl implements NaceReadCsvFile {

    private final NaceCsvMapper naceCsvMapper;

    @Override
    public List<Nace> readNaceCsvFile() {
        log.info("Start reading csv file");
        List<NaceCsvEntity> naceCsvEntityList = new ArrayList<>();
        ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
        strat.setType(NaceCsvEntity.class);
        String[] columns = new String[]{"order", "level", "code", "parent", "description", "thisItemIncludes", "thisItemAlsoIncludes", "rulings", "thisItemExcludes", "referenceToIsicRev"};
        strat.setColumnMapping(columns);
        CsvToBean csv = new CsvToBean();

        String csvFilename = "C:\\projects\\dbclmtest\\src\\main\\resources\\NACE_REV2_20230515_123609.csv";

        try {
            CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
            List list = csv.parse(strat, csvReader);
            for (Object object : list) {
                NaceCsvEntity naceCsv = (NaceCsvEntity) object;
                naceCsvEntityList.add(naceCsv);
            }
            log.info("Return csv file data into list object");
            return naceCsvEntityList.stream().map(naceCsvMapper::naceToNaceCsvEntity).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            log.error("Error reading csv file");
            throw new RuntimeException(e);
        }

    }
}
