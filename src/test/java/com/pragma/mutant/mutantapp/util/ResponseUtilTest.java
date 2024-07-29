package com.pragma.mutant.mutantapp.util;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtilTest {

    @Test
    public void TestIsMutantResponse(){

        ResponseEntity<Object> response= ResponseUtil.isMutantResponse();
        BDDAssertions.then(response).isNotNull();
        BDDAssertions.then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void TestIsNotMutant(){

        ResponseEntity<Object> response= ResponseUtil.isNotMutant();
        BDDAssertions.then(response).isNotNull();
        BDDAssertions.then(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

    }

    @Test
    public void TestError(){
        Object objectParameter = new Object();
        ResponseEntity<Object> response= ResponseUtil.error(objectParameter);
        BDDAssertions.then(response).isNotNull();
        BDDAssertions.then(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        BDDAssertions.then(((Object) response.getBody())).isEqualTo(objectParameter);

    }

    @Test
    public void TestStatsResponse(){
        Object objectParameter = new Object();
        ResponseEntity<Object> response= ResponseUtil.statsResponse(objectParameter);
        BDDAssertions.then(response).isNotNull();
        BDDAssertions.then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        BDDAssertions.then(((Object) response.getBody())).isEqualTo(objectParameter);
    }


}
