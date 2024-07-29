package com.pragma.mutant.mutantapp.model.request;

import java.util.Arrays;

public class DnaRequestDTO {

    public String[] dna;

    public DnaRequestDTO() {
    }

    public DnaRequestDTO(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    @Override
    public String toString() {
        return "DnaRequest{" +
                "dna=" + Arrays.toString(dna) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DnaRequestDTO that = (DnaRequestDTO) o;
        return Arrays.equals(dna, that.dna);
    }

}
