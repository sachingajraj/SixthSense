package com.seqhack.teamoc.sixthsense.service;

import com.seqhack.teamoc.sixthsense.entity.AdjBeacon;
import com.seqhack.teamoc.sixthsense.entity.Beacon;

import java.util.List;

/**
 * Created by sachin.gajraj on 9/11/16.
 */
public interface JpaService {
    Beacon getBeaconById(int id);

    List<AdjBeacon> getBeaconAdjList();
}
