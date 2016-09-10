package com.seqhack.teamoc.sixthsense.reponse;

/**
 * Created by sachin.gajraj on 9/10/16.
 */
public class BaseApiResponse {
    String status;
    String code;
    String message;

    public BaseApiResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
