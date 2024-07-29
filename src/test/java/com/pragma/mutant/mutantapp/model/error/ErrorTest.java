package com.pragma.mutant.mutantapp.model.error;

import com.pragma.mutant.mutantapp.util.Constants;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;

public class ErrorTest {

    @Test
    public void testContructorArgs(){

        Error error = new Error(Constants.GENERAL_ERROR_CODE,"Internal Service Error");

        BDDAssertions.then(error).isNotNull();
        BDDAssertions.then(error.getMsgError()).isEqualTo("Internal Service Error");
        BDDAssertions.then(error.getCodError()).isEqualTo(Constants.GENERAL_ERROR_CODE);
    }

    @Test
    public void testContructorNoArgs(){

        Error error = new Error();

        error.setCodError(Constants.GENERAL_ERROR_CODE);
        error.setMsgError("Internal Service Error");

        BDDAssertions.then(error).isNotNull();
        BDDAssertions.then(error.getMsgError()).isEqualTo("Internal Service Error");
        BDDAssertions.then(error.getCodError()).isEqualTo(Constants.GENERAL_ERROR_CODE);

    }

    @Test
    public void testToString(){

        Error error = new Error(Constants.GENERAL_ERROR_CODE,"Internal Service Error");

        BDDAssertions.then(error).isNotNull();
        BDDAssertions.then(error.toString()).isNotNull();

    }

}
