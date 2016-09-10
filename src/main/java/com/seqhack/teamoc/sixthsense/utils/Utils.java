package com.seqhack.teamoc.sixthsense.utils;

import com.seqhack.teamoc.sixthsense.reponse.BaseApiResponse;
import org.springframework.http.HttpStatus;

/**
 * Created by sachin.gajraj on 9/10/16.
 */
public class Utils {
    public static BaseApiResponse createResponse(HttpStatus status, String message) {
        return new BaseApiResponse(status.getReasonPhrase(), status.toString(), message);
    }
}


