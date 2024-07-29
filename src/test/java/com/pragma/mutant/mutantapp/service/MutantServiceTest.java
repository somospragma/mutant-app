package com.pragma.mutant.mutantapp.service;

import com.pragma.mutant.mutantapp.entity.MutantEntity;
import com.pragma.mutant.mutantapp.logger.ILoggerStrategy;
import com.pragma.mutant.mutantapp.model.request.DnaRequestDTO;
import com.pragma.mutant.mutantapp.model.response.StatsResponseDTO;
import com.pragma.mutant.mutantapp.repository.IMutantRepository;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

public class MutantServiceTest {

    private MutantService mutantService;

    @Mock
    private  MutantValidator mutantValidator;

    @Mock
    private IMutantRepository mutantRepository;

    @Mock
    private ILoggerStrategy logStrategy;

    @BeforeEach
    public void setUp(){

        MockitoAnnotations.openMocks(this);
        mutantService = new MutantService(mutantValidator,mutantRepository,logStrategy);


    }

    @Test
    public void testValidateDNANoDB() {

        String[] dna = new String[]{"ATTGCC","ATCGCC","ATCGCC","ATCGCC","ATCGCC","ATCGCC"};
        Optional<MutantEntity> mutant = Optional.empty() ;
        given(mutantRepository.findById("d4490fa59eb1608aa244b7295224aca0")).willReturn(mutant);
        given(mutantValidator.isMutant(dna)).willReturn(true);
        boolean response = mutantService.validateDNA(new DnaRequestDTO(dna));

        then(mutantValidator).should(times(1)).isMutant(dna);
        then(mutantRepository).should(times(1)).findById("d4490fa59eb1608aa244b7295224aca0");
        then(mutantRepository).should(times(1)).save(ArgumentMatchers.any(MutantEntity.class));
        BDDAssertions.then(response).isNotNull();
        BDDAssertions.then(response).isEqualTo(true);
    }

    @Test
    public void testValidateDNADB() {

        String[] dna = new String[]{"ATTGCC","ATCGCC","ATCGCC","ATCGCC","ATCGCC","ATCGCC"};
        Optional<MutantEntity> mutant = Optional.of(new MutantEntity("d4490fa59eb1608aa244b7295224aca0","ATTGCC|ATCGCC|ATCGCC|ATCGCC|ATCGCC|ATCGCC",false)) ;
        given(mutantRepository.findById("d4490fa59eb1608aa244b7295224aca0")).willReturn(mutant);
        boolean response = mutantService.validateDNA(new DnaRequestDTO(dna));

        then(mutantRepository).should(times(1)).findById("d4490fa59eb1608aa244b7295224aca0");

        BDDAssertions.then(response).isNotNull();
        BDDAssertions.then(response).isEqualTo(false);
    }

    @Test
    public void testValidateGetStats() {
        given(mutantRepository.findAll()).willReturn(getListDna());
        StatsResponseDTO stats = mutantService.getMutantStats();
        then(mutantRepository).should(times(1)).findAll();

        BDDAssertions.then(stats).isNotNull();
        BDDAssertions.then(stats.getCountMutantDna()).isEqualTo(2);
        BDDAssertions.then(stats.getCountHumanDna()).isEqualTo(1);
        BDDAssertions.then(stats.getRatio()).isEqualTo(2.0);

    }

    private List<MutantEntity> getListDna(){
        List<MutantEntity> mutantList = new ArrayList<>();
        mutantList.add(new MutantEntity("ASD849ADS19D8F","ATTGCC|ATCGCC|ATCGCC|ATCGCC|ATCGCC|ATCGCC",true));
        mutantList.add(new MutantEntity("ETGFD684GDR9FG","ATTGCC|ATCGTA|ATCTCC|CGTATT|ATCGCC|ATCGCC",true));
        mutantList.add(new MutantEntity("SDF6151SDF841S","ATCGCC|ATCTCC|ATCGCC|ATCGCC|CGTATT|ATCGCC",false));
        return mutantList;
    }


}
