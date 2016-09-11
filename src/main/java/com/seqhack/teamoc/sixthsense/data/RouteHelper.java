package com.seqhack.teamoc.sixthsense.data;

import com.seqhack.teamoc.sixthsense.entity.Beacon;
import com.seqhack.teamoc.sixthsense.entity.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sachin.gajraj on 9/11/16.
 */
public class RouteHelper {
    public static List<Step> getRoute(Beacon source, Beacon destination) {
        BeaconDataHelper.getBeaconAdjacencyList();
        return new ArrayList<>();
    }

    public static List<Beacon> getPossibleDestinations(Beacon source) {
        return new ArrayList<>();
    }
}
