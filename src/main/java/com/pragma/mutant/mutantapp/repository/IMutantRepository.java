package com.pragma.mutant.mutantapp.repository;

import com.pragma.mutant.mutantapp.entity.MutantEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface IMutantRepository extends CrudRepository<MutantEntity,String > {
}
