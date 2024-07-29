package com.pragma.mutant.mutantapp.controller;

import com.pragma.mutant.mutantapp.logger.ILoggerStrategy;
import com.pragma.mutant.mutantapp.model.request.DnaRequestDTO;
import com.pragma.mutant.mutantapp.model.response.StatsResponseDTO;
import com.pragma.mutant.mutantapp.service.MutantService;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

public class MutantControllerTest {

    private MutantController mutantController;
    @Mock
    private MutantService mutantService;

    @Mock
    private ILoggerStrategy loggerStrategy;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mutantController = new MutantController(loggerStrategy, mutantService);
    }

    @Test
    public void testValidateDna_mutant() {
        DnaRequestDTO dnaRequestDTO = buildDnaRequest();
        given(mutantService.validateDNA(dnaRequestDTO)).willReturn(true);

        ResponseEntity response = mutantController.validateDna(dnaRequestDTO);

        then(mutantService).should(times(1)).validateDNA(dnaRequestDTO);
        BDDAssertions.then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void testValidateDna_human() {
        DnaRequestDTO dnaRequestDTO = buildDnaRequest();
        given(mutantService.validateDNA(dnaRequestDTO)).willReturn(false);

        ResponseEntity response = mutantController.validateDna(dnaRequestDTO);

        then(mutantService).should(times(1)).validateDNA(dnaRequestDTO);
        BDDAssertions.then(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
    }

    @Test
    public void testGetDnaStats() {
        StatsResponseDTO statsResponseDTO = buildStatsResponse();
        given(mutantService.getMutantStats()).willReturn(statsResponseDTO);

        ResponseEntity response = mutantController.getDnaStats();

        then(mutantService).should(times(1)).getMutantStats();
        BDDAssertions.then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        BDDAssertions.then(((StatsResponseDTO) response.getBody()).getCountHumanDna()).isEqualTo(10);
        BDDAssertions.then(((StatsResponseDTO) response.getBody()).getCountMutantDna()).isEqualTo(15);
        BDDAssertions.then(((StatsResponseDTO) response.getBody()).getRatio()).isEqualTo(1.5);
    }

    private DnaRequestDTO buildDnaRequest() {
        String[] dna = {"CTCTGT", "CACAAT", "CGAAAA", "AGCGCG", "TATTGA", "AGGGGC"};
        DnaRequestDTO dnaRequestDTO = new DnaRequestDTO();
        dnaRequestDTO.setDna(dna);
        return dnaRequestDTO;
    }

    private StatsResponseDTO buildStatsResponse() {
        StatsResponseDTO statsResponseDTO = new StatsResponseDTO(15,10,1.5);
        return statsResponseDTO;
    }
}
