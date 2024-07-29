package com.pragma.mutant.mutantapp.service;


import com.pragma.mutant.mutantapp.model.request.DnaRequestDTO;
import com.pragma.mutant.mutantapp.model.response.StatsResponseDTO;

/**
 * Mutant Service
 */
public interface IMutantService {

    /**
     * Validates DNA sequence to determine wether the subject is a mutant or human, and saves the DNA sequence into
     * the database
     *
     * @param request the DNA sequence to validate and add into the database
     * @return true if the inserted sequence corresponds to mutant dna, false otherwise
     */
    boolean validateDNA(DnaRequestDTO request);
    StatsResponseDTO getMutantStats();

}
