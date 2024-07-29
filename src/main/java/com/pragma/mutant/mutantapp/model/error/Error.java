package com.pragma.mutant.mutantapp.model.error;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Error {

    @JsonProperty("code_error")
    private String codError;

    @JsonProperty("desc_error")
    private String msgError;

    public Error() {
    }

    public Error(String codError, String msgError) {
        this.codError = codError;
        this.msgError = msgError;
    }

    public String getCodError() {
        return codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    @Override
    public String toString() {
        return "Error{" +
                "codError='" + codError + '\'' +
                ", msgError='" + msgError + '\'' +
                '}';
    }
}
