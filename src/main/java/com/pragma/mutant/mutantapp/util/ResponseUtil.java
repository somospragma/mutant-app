package com.pragma.mutant.mutantapp.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity isMutantResponse(){ return new ResponseEntity(HttpStatus.OK); }

    public static ResponseEntity isNotMutant(){
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    public static ResponseEntity error(Object obj){
        return new ResponseEntity(obj,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity statsResponse(Object response){ return new ResponseEntity(response,HttpStatus.OK); }
}
