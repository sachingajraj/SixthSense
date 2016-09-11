package com.seqhack.teamoc.sixthsense.controllers;

import com.seqhack.teamoc.sixthsense.data.BeaconDataHelper;
import com.seqhack.teamoc.sixthsense.data.RouteHelper;
import com.seqhack.teamoc.sixthsense.entity.Beacon;
import com.seqhack.teamoc.sixthsense.entity.Step;
import com.seqhack.teamoc.sixthsense.reponse.BaseApiResponse;
import com.seqhack.teamoc.sixthsense.reponse.RouteApiResponse;
import com.seqhack.teamoc.sixthsense.service.JpaService;
import com.seqhack.teamoc.sixthsense.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by sachin.gajraj on 9/10/16.
 */

@Controller
@ControllerAdvice
@RequestMapping("/route")
public class RouteController {

    @Autowired
    JpaService jpaService;

    @RequestMapping("/user")
    public
    @ResponseBody
    RouteApiResponse getRouteInfo(@RequestParam String sourceBeaconUuid, @RequestParam String minor, @RequestParam String major,
                                  @RequestParam String destinationBeaconId) {
        String message;
        HttpStatus httpStatus;
        List<Step> routeSteps = null;
        if (sourceBeaconUuid == null || sourceBeaconUuid.isEmpty() || destinationBeaconId == null || destinationBeaconId.isEmpty()) {
            message = "Beacon(s) id absent in request.";
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            
            Beacon source = jpaService.getBeaconByUuidMM(sourceBeaconUuid, Integer.parseInt(major), Integer.parseInt(minor));
            Beacon destination = BeaconDataHelper.getBeaconById(Integer.parseInt(destinationBeaconId));

            routeSteps = RouteHelper.getRoute(source, destination);
            message = "Best route to destination.";
            httpStatus = HttpStatus.OK;
        }
        return Utils.createRouteResponse(httpStatus, message, routeSteps);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public BaseApiResponse handleException(Exception e) {
        return Utils.createResponse(HttpStatus.BAD_REQUEST, "Fail !!!!!");
    }
}
