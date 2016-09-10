package com.seqhack.teamoc.sixthsense.utils;

import com.seqhack.teamoc.sixthsense.entity.Beacon;
import com.seqhack.teamoc.sixthsense.entity.Step;
import com.seqhack.teamoc.sixthsense.reponse.BaseApiResponse;
import com.seqhack.teamoc.sixthsense.reponse.BeaconApiResponse;
import com.seqhack.teamoc.sixthsense.reponse.RouteApiResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by sachin.gajraj on 9/10/16.
 */
public class Utils {
    public static BaseApiResponse createResponse(HttpStatus status, String message) {
        return new BaseApiResponse(status.getReasonPhrase(), status.toString(), message);
    }

    public static BeaconApiResponse createBeaconResponse(HttpStatus status, String message, Beacon sourceBeacon,
                                                         List<Beacon> possibleDestinations) {
        if (sourceBeacon != null && possibleDestinations != null) {
            return new BeaconApiResponse(status.getReasonPhrase(), status.toString(), message, sourceBeacon,
                    possibleDestinations);
        } else {
            return (BeaconApiResponse) Utils.createResponse(status, message);
        }
    }

    public static RouteApiResponse createRouteResponse(HttpStatus status, String message, List<Step> routeSteps) {
        return new RouteApiResponse(status.getReasonPhrase(), status.toString(), message, routeSteps);
    }
}


