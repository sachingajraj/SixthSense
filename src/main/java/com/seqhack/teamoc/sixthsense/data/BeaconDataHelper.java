package com.seqhack.teamoc.sixthsense.data;

import com.seqhack.teamoc.sixthsense.entity.AdjBeacon;
import com.seqhack.teamoc.sixthsense.entity.Beacon;
import com.seqhack.teamoc.sixthsense.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sachin.gajraj on 9/11/16.
 */
public class BeaconDataHelper {

    private static volatile Map<Integer, Beacon> beaconIdToBeaconMap = new HashMap<>();
    private static volatile List<AdjBeacon> beaconAdjacencyList = new ArrayList<>();

    @Autowired
    private static JpaService jpaService;

    public static void init() {
        try {
            List<Beacon> allBeacons = jpaService.getAllBeacons();

            if (allBeacons == null) {
                allBeacons = new ArrayList<>();
            }

            Map<Integer, Beacon> newBeaconIdToBeaconMap = new HashMap<>();
            for (Beacon beacon : allBeacons) {
                beaconIdToBeaconMap.put(beacon.getId(), beacon);
            }
            beaconIdToBeaconMap = newBeaconIdToBeaconMap;
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            List<AdjBeacon> newBeaconAdjacencyList = jpaService.getBeaconAdjList();

            if (newBeaconAdjacencyList == null) {
                newBeaconAdjacencyList = new ArrayList<>();
            }
            beaconAdjacencyList = newBeaconAdjacencyList;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static List<AdjBeacon> getBeaconAdjacencyList() {
        return beaconAdjacencyList;
    }

    public static Beacon getBeaconById(int id) {
        return beaconIdToBeaconMap.get(id);
    }
}
