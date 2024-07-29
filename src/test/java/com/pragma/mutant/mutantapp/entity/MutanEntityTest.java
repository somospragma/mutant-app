package com.pragma.mutant.mutantapp.entity;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;

public class MutanEntityTest {

    @Test
    public void testContructorArgs(){

        MutantEntity mutantEntity = new MutantEntity("AR22V8XRD3D9S","ATCGCC|TCGATC|TATTGC|AGGAGC|CCGCTA|TCTCTG",true);

        BDDAssertions.then(mutantEntity).isNotNull();
        BDDAssertions.then(mutantEntity.isMutant()).isEqualTo(true);
        BDDAssertions.then(mutantEntity.getDna()).isEqualTo("ATCGCC|TCGATC|TATTGC|AGGAGC|CCGCTA|TCTCTG");
        BDDAssertions.then(mutantEntity.getId()).isEqualTo("AR22V8XRD3D9S");
    }

    @Test
    public void testContructorNoArgs(){

        MutantEntity mutantEntity = new MutantEntity();

        mutantEntity.setMutant(true);
        mutantEntity.setDna("ATCGCC|TCGATC|TATTGC|AGGAGC|CCGCTA|TCTCTG");
        mutantEntity.setId("AR22V8XRD3D9S");

        BDDAssertions.then(mutantEntity).isNotNull();
        BDDAssertions.then(mutantEntity.isMutant()).isEqualTo(true);
        BDDAssertions.then(mutantEntity.getDna()).isEqualTo("ATCGCC|TCGATC|TATTGC|AGGAGC|CCGCTA|TCTCTG");
        BDDAssertions.then(mutantEntity.getId()).isEqualTo("AR22V8XRD3D9S");

    }

    @Test
    public void TestToString(){
        MutantEntity mutantEntity = new MutantEntity("AR22V8XRD3D9S","ATCGCC|TCGATC|TATTGC|AGGAGC|CCGCTA|TCTCTG",true);
        BDDAssertions.then(mutantEntity.toString()).isNotNull();

    }
}
