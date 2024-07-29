package com.pragma.mutant.mutantapp.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatsResponseDTO {

    @JsonProperty("count_mutant_dna")
    private int countMutantDna;

    @JsonProperty("count_human_dna")
    private int countHumanDna;

    @JsonProperty("ratio")
    private double ratio;

    public StatsResponseDTO() {
    }

    public StatsResponseDTO(int countMutantDna, int countHumanDna, double ratio) {
        this.countMutantDna = countMutantDna;
        this.countHumanDna = countHumanDna;
        this.ratio = ratio;
    }

    public int getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(int countMutantDna) {
        this.countMutantDna = countMutantDna;
    }

    public int getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(int countHumanDna) {
        this.countHumanDna = countHumanDna;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "StatsResponse{" +
                "countMutantDna='" + countMutantDna + '\'' +
                ", countHumanDna='" + countHumanDna + '\'' +
                ", ratio=" + ratio +
                '}';
    }
}
