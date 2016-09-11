package com.seqhack.teamoc.sixthsense.data;

import com.seqhack.teamoc.sixthsense.entity.AdjBeacon;
import com.seqhack.teamoc.sixthsense.entity.Beacon;
import com.seqhack.teamoc.sixthsense.entity.Step;

import java.util.*;

/**
 * Created by sachin.gajraj on 9/11/16.
 */
public class RouteHelper {

    static List<AdjBeacon> adjBeaconList;

    public static List<Step> getRoute(Beacon source, Beacon destination) {
        adjBeaconList = BeaconDataHelper.getBeaconAdjacencyList();
        ArrayList<Step> stepList = new ArrayList<>();
        ArrayList<Integer> pathIds = computePathIds(source, destination);
        for (int i = 0; i < pathIds.size() - 1; ++i) {
            Beacon stepSource = BeaconDataHelper.getBeaconById(pathIds.get(i));
            Beacon stepDest = BeaconDataHelper.getBeaconById(pathIds.get(i + 1));
            String stepMessage = getStepMessage(stepSource, stepDest);
            Step step = new Step(i, stepSource, stepDest, stepMessage);
            stepList.add(step);
        }

        return stepList;
    }

    public static List<Beacon> getPossibleDestinations(Beacon source) {
        List<Beacon> allBeacons = BeaconDataHelper.getAllBeaconsList();
        Set<Beacon> allBeaconSet = new HashSet<>(allBeacons);
        allBeaconSet.remove(source);
        return new ArrayList<>(allBeaconSet);
    }

    public static String getStepMessage(Beacon stepSource, Beacon stepDest) {
        for (int i = 0; i < adjBeaconList.size(); ++i) {
            if (stepSource.getId() == adjBeaconList.get(i).getBid() && stepDest.getId() == adjBeaconList.get(i).getAdjBid()) {
                return adjBeaconList.get(i).getTransitionMessage();
            }
        }
        return "";
    }

    public static ArrayList<Integer> computePathIds(Beacon startBeacon, Beacon endBeacon) {


        ArrayList<Integer> path = new ArrayList<>();
        Queue<Beacon> queue = new LinkedList<>();
        HashMap<Integer, Integer> parentMap = new HashMap<Integer, Integer>();
        parentMap.put(startBeacon.getId(), startBeacon.getId());
        queue.add(startBeacon);

        while (!queue.isEmpty()) {
            Beacon current = queue.remove();
            if (current.getId() == endBeacon.getId()) {
                int currentId = current.getId();
                while (currentId != parentMap.get(currentId)) {
                    path.add(currentId);
                    currentId = parentMap.get(currentId);
                }
                path.add(currentId);
                Collections.reverse(path);
                return path;
            } else {
                ArrayList<Beacon> neighbourBeacons = getNeigbourBeacons(current);
                if (neighbourBeacons.isEmpty())
                    return path;
                else {
                    for (Beacon beacon : neighbourBeacons) {
                        if (!(parentMap.containsKey(beacon.getId()))) {
                            queue.add(beacon);
                            parentMap.put(beacon.getId(), current.getId());

                        }

                    }
                }
            }
        }
        return path;
    }

    public static ArrayList<Beacon> getNeigbourBeacons(Beacon beacon) {
        ArrayList<Beacon> neighbourList = new ArrayList<>();
        for (AdjBeacon adjBeacon : adjBeaconList) {
            if (adjBeacon.getBid() == beacon.getId()) {
                neighbourList.add(BeaconDataHelper.getBeaconById(adjBeacon.getAdjBid()));
            }
        }
        return neighbourList;
    }

}
