package com.pragma.mutant.mutantapp.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "mutant")
public class MutantEntity {

    @DynamoDBHashKey
    private String id;

    @DynamoDBAttribute
    private String dna;

    @DynamoDBAttribute
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
    private boolean isMutant;

    public MutantEntity() {
    }

    public MutantEntity(String id, String dna, boolean isMutant) {
        this.id = id;
        this.dna = dna;
        this.isMutant = isMutant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        return isMutant;
    }

    public void setMutant(boolean mutant) {
        isMutant = mutant;
    }

    @Override
    public String toString() {
        return "MutantEntity{" +
                "id='" + id + '\'' +
                ", dna='" + dna + '\'' +
                ", isMutant=" + isMutant +
                '}';
    }
}
