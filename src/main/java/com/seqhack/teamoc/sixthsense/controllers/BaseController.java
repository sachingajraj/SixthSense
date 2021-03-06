package com.seqhack.teamoc.sixthsense.controllers;

import com.seqhack.teamoc.sixthsense.data.RouteHelper;
import com.seqhack.teamoc.sixthsense.entity.AdjBeacon;
import com.seqhack.teamoc.sixthsense.entity.Beacon;
import com.seqhack.teamoc.sixthsense.reponse.BaseApiResponse;
import com.seqhack.teamoc.sixthsense.reponse.BeaconApiResponse;
import com.seqhack.teamoc.sixthsense.service.JpaService;
import com.seqhack.teamoc.sixthsense.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/beacon")
public class BaseController {

    @Autowired
    JpaService jpaService;

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
            try {
                Beacon beacon = jpaService.getBeaconById(1);
                List<AdjBeacon> adjBeacons = jpaService.getBeaconAdjList();
                System.out.printf(beacon.getLocation());
            } catch (Exception e) {
                e.printStackTrace();
            }
            Integer current = Integer.parseInt(currentLocation) + 1;
            message = current.toString();
            httpStatus = HttpStatus.OK;
        }
        return Utils.createResponse(httpStatus, message);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public
    @ResponseBody
    BaseApiResponse getRouteInfo(@RequestParam String beaconId, @RequestParam String currentLocation,
                                 @RequestParam String finalLocation) {
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

    @RequestMapping(value = "/destinations", method = RequestMethod.GET)
    public
    @ResponseBody
    BeaconApiResponse getDestinationsFromBeacon(@RequestParam String sourceBeaconUuid, @RequestParam String minor,
                                                @RequestParam String major) {
        String message;
        HttpStatus httpStatus;
        List<Beacon> destinationBeaconList = new ArrayList<>();
        Beacon sourceBeacon = null;
        if (sourceBeaconUuid == null || sourceBeaconUuid.isEmpty()) {
            message = "Beacon id absent in request.";
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            sourceBeacon = jpaService.getBeaconByUuidMM(sourceBeaconUuid, Integer.parseInt(major), Integer.parseInt(minor));
            destinationBeaconList = RouteHelper.getPossibleDestinations(sourceBeacon);
            message = "Possible Destinations.";
            httpStatus = HttpStatus.OK;
        }
        return Utils.createBeaconResponse(httpStatus, message, sourceBeacon, destinationBeaconList);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public BaseApiResponse handleException(Exception e) {
        return Utils.createResponse(HttpStatus.BAD_REQUEST, "Fail !!!!!");
    }
}
