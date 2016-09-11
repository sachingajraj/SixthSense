package com.seqhack.teamoc.sixthsense.data;

import com.seqhack.teamoc.sixthsense.entity.AdjBeacon;
import com.seqhack.teamoc.sixthsense.entity.Beacon;
import com.seqhack.teamoc.sixthsense.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sachin.gajraj on 9/11/16.
 */
@Component
public class BeaconDataHelper {

    private static volatile Map<Integer, Beacon> beaconIdToBeaconMap = new HashMap<>();
    private static volatile List<AdjBeacon> beaconAdjacencyList = new ArrayList<>();

    private static JpaService staticJpaService;

    @Autowired
    JpaService jpaService;

    @PostConstruct
    public void initStaticService() {
        staticJpaService = this.jpaService;
    }

    public static void init() {

        List<Beacon> allBeacons = staticJpaService.getAllBeacons();
        if (allBeacons == null) {
            allBeacons = new ArrayList<>();
        }

        Map<Integer, Beacon> newBeaconIdToBeaconMap = new HashMap<>();
        for (Beacon beacon : allBeacons) {
            newBeaconIdToBeaconMap.put(beacon.getId(), beacon);
        }
        beaconIdToBeaconMap = newBeaconIdToBeaconMap;


        List<AdjBeacon> newBeaconAdjacencyList = staticJpaService.getBeaconAdjList();
        if (newBeaconAdjacencyList == null) {
            newBeaconAdjacencyList = new ArrayList<>();
        }
        beaconAdjacencyList = newBeaconAdjacencyList;
    }

    public static List<AdjBeacon> getBeaconAdjacencyList() {
        return beaconAdjacencyList;
    }

    public static Beacon getBeaconById(int id) {
        return beaconIdToBeaconMap.get(id);
    }
}
