package com.pragma.mutant.mutantapp.exception;

import com.pragma.mutant.mutantapp.model.error.Error;
import com.pragma.mutant.mutantapp.util.Constants;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MutantExceptionHandlerTest {

    private MutantExceptionHandler mutantExceptionHandler;

    @BeforeEach
    public void setUp(){
        mutantExceptionHandler = new MutantExceptionHandler();
    }

    @Test
    public void testGeneralError(){
        Exception exception = new Exception("Internal Server Error");
        ResponseEntity<Error> errorResponseEntity = mutantExceptionHandler.generalError(exception);

        BDDAssertions.then(errorResponseEntity).isNotNull();
        BDDAssertions.then(errorResponseEntity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        BDDAssertions.then(((Error) errorResponseEntity.getBody()).getCodError()).isEqualTo(Constants.GENERAL_ERROR_CODE);
        BDDAssertions.then(((Error) errorResponseEntity.getBody()).getMsgError()).isEqualTo("Internal Server Error");
    }
}
