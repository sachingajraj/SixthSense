package com.seqhack.teamoc.sixthsense.controllers;

import com.seqhack.teamoc.sixthsense.reponse.BaseApiResponse;
import com.seqhack.teamoc.sixthsense.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by sachin.gajraj on 9/10/16.
 */

@Controller
@ControllerAdvice
@RequestMapping("/beacon")
public class BaseController {

    @RequestMapping(value = "/{currentLocation}/{finalLocation}", method = RequestMethod.GET)
    public
    @ResponseBody
    BaseApiResponse getJobStatus(@PathVariable String currentLocation, @PathVariable String finalLocation) {
        String message;
        HttpStatus httpStatus;
        if (currentLocation == null || currentLocation.isEmpty() || finalLocation == null || finalLocation.isEmpty()) {
            message = "Beacon id absent in request.";
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            Integer current = Integer.parseInt(currentLocation) + 1;
            message = current.toString();
            httpStatus = HttpStatus.OK;
        }
        return Utils.createResponse(httpStatus, message);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public BaseApiResponse handleException(Exception e) {
        return Utils.createResponse(HttpStatus.BAD_REQUEST, "Fail !!!!!");
    }
}
