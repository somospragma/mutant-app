package com.pragma.mutant.mutantapp.model.request;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DnaRequestDTOTest {

    private String[] dna;


    @BeforeEach
    public void setUp(){
        dna = getDna();
    }

    @Test
    public void testContructorArgs(){

        DnaRequestDTO dnaRequestDTO = new DnaRequestDTO(dna);

        BDDAssertions.then(dnaRequestDTO).isNotNull();
        BDDAssertions.then(dnaRequestDTO.getDna()).isEqualTo(dna);
    }

    @Test
    public void testContructorNoArgs(){

        DnaRequestDTO dnaRequestDTO = new DnaRequestDTO();
        dnaRequestDTO.setDna(dna);

        BDDAssertions.then(dnaRequestDTO).isNotNull();
        BDDAssertions.then(dnaRequestDTO.getDna()).isEqualTo(dna);

    }

    @Test
    public void testToString(){

        DnaRequestDTO dnaRequestDTO = new DnaRequestDTO(dna);

        BDDAssertions.then(dnaRequestDTO).isNotNull();
        BDDAssertions.then(dnaRequestDTO.toString()).isNotNull();

    }


    @Test
    public void testEquals(){

        DnaRequestDTO dnaRequestDTO = new DnaRequestDTO(dna);

        BDDAssertions.then(dnaRequestDTO).isNotNull();
        BDDAssertions.then(dnaRequestDTO.equals(dnaRequestDTO)).isEqualTo(true);

    }

    @Test
    public void testEqualsDifferentObj(){

        DnaRequestDTO dnaRequestDTO = new DnaRequestDTO(dna);

        BDDAssertions.then(dnaRequestDTO).isNotNull();
        BDDAssertions.then(dnaRequestDTO.equals(new Object())).isEqualTo(false);

    }

    @Test
    public void testEqualsDifferentInstance(){

        DnaRequestDTO dnaRequestDTO01 = new DnaRequestDTO(dna);
        DnaRequestDTO dnaRequestDTO02 = new DnaRequestDTO(new String[]{"ATTGCC","ATCGCC","ATCGCC","ATCGCC","ATCGCC","ATCGCC"});

        BDDAssertions.then(dnaRequestDTO01).isNotNull();
        BDDAssertions.then(dnaRequestDTO01.equals(dnaRequestDTO02)).isEqualTo(false);


    }


    private String[] getDna(){
        return new String[]{"ATCGCC","ATCGCC","ATCGCC","ATCGCC","ATCGCC","ATCGCC"};
    }

}
