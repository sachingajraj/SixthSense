package com.seqhack.teamoc.sixthsense.controllers;

import com.seqhack.teamoc.sixthsense.entity.Beacon;
import com.seqhack.teamoc.sixthsense.entity.Step;
import com.seqhack.teamoc.sixthsense.reponse.BaseApiResponse;
import com.seqhack.teamoc.sixthsense.reponse.RouteApiResponse;
import com.seqhack.teamoc.sixthsense.utils.Utils;
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

/**
 * Created by sachin.gajraj on 9/10/16.
 */

@Controller
@ControllerAdvice
@RequestMapping("/route")
public class RouteController {

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
            Step step1 = new Step();
            step1.setStep(1);

            Beacon source = new Beacon();
            source.setId("1");
            source.setUuid("111111");
            source.setMajor("11");
            source.setMinor("12");
            source.setLocation("Location 1");
            step1.setSource(source);

            Beacon destination = new Beacon();
            destination.setId("2");
            destination.setUuid("222222");
            destination.setMajor("21");
            destination.setMinor("22");
            destination.setLocation("Location 2");
            step1.setDestination(destination);

            step1.setVoiceText("Move 10 steps forward.");

            Step step2 = new Step();
            step2.setStep(2);

            source = new Beacon();
            source.setId("2");
            source.setUuid("222222");
            source.setMajor("21");
            source.setMinor("22");
            source.setLocation("Location 2");
            step2.setSource(source);

            destination = new Beacon();
            destination.setId("3");
            destination.setUuid("333333");
            destination.setMajor("31");
            destination.setMinor("32");
            destination.setLocation("Location 3");
            step2.setDestination(destination);
            step2.setVoiceText("Take 14 more steps to reach Location 3");

            routeSteps = new ArrayList<>();
            routeSteps.add(step1);
            routeSteps.add(step2);

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
