package com.pragma.mutant.mutantapp.service;

/**
 * Validator for all DNA sequences
 */
public interface IMutantValidator {
    /**
     * @param dna an array of String values representing the DNA sequence to validate
     * @return true if the DNA sequences corresponds to that of a mutant, false otherwise
     */
    boolean isMutant(String[] dna);
}
