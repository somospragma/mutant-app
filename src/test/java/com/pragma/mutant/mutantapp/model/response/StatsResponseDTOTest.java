package com.pragma.mutant.mutantapp.model.response;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;

public class StatsResponseDTOTest {

    @Test
    public void testContructorArgs(){

        StatsResponseDTO statsResponseDTO = new StatsResponseDTO(15,10,1.5);

        BDDAssertions.then(statsResponseDTO).isNotNull();
        BDDAssertions.then(statsResponseDTO.getCountMutantDna()).isEqualTo(15);
        BDDAssertions.then(statsResponseDTO.getCountHumanDna()).isEqualTo(10);
        BDDAssertions.then(statsResponseDTO.getRatio()).isEqualTo(1.5);
    }

    @Test
    public void testContructorNoArgs(){

        StatsResponseDTO statsResponseDTO = new StatsResponseDTO();

        statsResponseDTO.setCountHumanDna(10);
        statsResponseDTO.setCountMutantDna(15);
        statsResponseDTO.setRatio(1.5);

        BDDAssertions.then(statsResponseDTO).isNotNull();
        BDDAssertions.then(statsResponseDTO.getCountMutantDna()).isEqualTo(15);
        BDDAssertions.then(statsResponseDTO.getCountHumanDna()).isEqualTo(10);
        BDDAssertions.then(statsResponseDTO.getRatio()).isEqualTo(1.5);

    }

    @Test
    public void testToString(){

        StatsResponseDTO statsResponseDTO = new StatsResponseDTO(15,10,1.5);

        BDDAssertions.then(statsResponseDTO).isNotNull();
        BDDAssertions.then(statsResponseDTO.toString()).isNotNull();

    }
}
