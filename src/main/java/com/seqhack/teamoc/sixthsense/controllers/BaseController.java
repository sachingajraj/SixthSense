package com.seqhack.teamoc.sixthsense.controllers;

import com.seqhack.teamoc.sixthsense.reponse.BaseApiResponse;
import com.seqhack.teamoc.sixthsense.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sachin.gajraj on 9/10/16.
 */

@Controller
@ControllerAdvice
@RequestMapping("/beacon")
public class BaseController {

    @RequestMapping(value = "/{beaconId}", method = RequestMethod.GET)
    public
    @ResponseBody
    BaseApiResponse getJobStatus(@PathVariable String beaconId) {

        String message;
        HttpStatus httpStatus;
        if (beaconId == null || beaconId.isEmpty()) {
            message = "Beacon id absent in request.";
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            message = "Coooollll !! Looking for your beacon.";
            httpStatus = HttpStatus.ACCEPTED;
        }
        return Utils.createResponse(httpStatus, message);
    }
}
