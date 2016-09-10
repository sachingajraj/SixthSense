package com.seqhack.teamoc.sixthsense.reponse;

import com.seqhack.teamoc.sixthsense.entity.Step;

import java.util.List;

/**
 * Created by sachin.gajraj on 9/10/16.
 */
public class RouteApiResponse extends BaseApiResponse {
    List<Step> route;

    public RouteApiResponse(String status, String code, String message, List<Step> route) {
        super(status, code, message);
        this.route = route;
    }
}
