package com.example.dbclmtest.infrastructure.rest.spring.resources;

import com.example.dbclmtest.application.service.NaceCsvServiceImpl;
import com.example.dbclmtest.application.service.NaceServiceImpl;
import com.example.dbclmtest.domain.model.Nace;
import com.example.dbclmtest.infrastructure.rest.spring.dto.NaceRequest;
import com.example.dbclmtest.infrastructure.rest.spring.dto.NaceResponse;
import com.example.dbclmtest.infrastructure.rest.spring.mapper.NaceMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/nace")
@RestController
@AllArgsConstructor
public class NaceController {

    private final NaceCsvServiceImpl naceCsvService;
    private final NaceServiceImpl naceService;
    private final NaceMapper naceMapper;

    //TODO: add body to send the name of the file and type
    @Operation(summary = "Set csv data of nace details")
    @PostMapping("/csv")
    public ResponseEntity<List<NaceResponse>> setNaceDetails() {
        log.info("Endpoint to load CSV data from NACE");
        List<Nace> response = naceCsvService.setNaceDetails();

        if (response == null) {
            log.error("Error loading data into db");
            return new ResponseEntity<>(
                    new ArrayList<>(),
                    HttpStatus.NOT_FOUND);
        }
        log.info("Success loading data into db");
        return new ResponseEntity<>(
                response.stream().map(naceMapper::naceResponseToNace).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @Operation(summary = "Update Nace details")
    @PutMapping("/{order}")
    public ResponseEntity<NaceResponse> putNaceDetails(@PathVariable Long order, @RequestBody NaceRequest request) {
        log.info("Endpoint to update NACE details");
        Nace response = naceService.putNaceDetails(order, naceMapper.naceToNaceRequest(request));
        if (response == null) {
            log.error("Error update NACE details");
            return new ResponseEntity<>(
                    null,
                    HttpStatus.NOT_FOUND);
        }
        log.info("Success update NACE details");
        return new ResponseEntity<>(
                naceMapper.naceResponseToNace(response),
                HttpStatus.OK);
    }

    @Operation(summary = "Get nace detail with order id")
    @GetMapping("/{order}")
    public ResponseEntity<NaceResponse> getNaceDetails(@PathVariable Long order) {
        log.info("Endpoint to get NACE details with order id");
        Nace response = naceService.getNaceDetails(order);
        if (response == null) {
            log.error("Error searching NACE details with order id");
            return new ResponseEntity<>(
                    null,
                    HttpStatus.NOT_FOUND);
        }
        log.info("Success searching NACE details with order id");
        return new ResponseEntity<>(
                naceMapper.naceResponseToNace(response),
                HttpStatus.OK);
    }
}
