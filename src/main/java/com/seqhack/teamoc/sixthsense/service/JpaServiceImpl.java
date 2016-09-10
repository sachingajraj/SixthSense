package com.seqhack.teamoc.sixthsense.service;

import com.seqhack.teamoc.sixthsense.entity.AdjBeacon;
import com.seqhack.teamoc.sixthsense.entity.Beacon;
import com.seqhack.teamoc.sixthsense.repository.AdjBeaconRepository;
import com.seqhack.teamoc.sixthsense.repository.BeaconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sachin.gajraj on 9/11/16.
 */

@Service
@Transactional
public class JpaServiceImpl implements JpaService {

    @Autowired
    BeaconRepository beaconRepository;

    @Autowired
    AdjBeaconRepository adjBeaconRepository;

    @Override
    public Beacon getBeaconById(int id) {
        return beaconRepository.getBeaconById(id);
    }

    @Override
    public List<AdjBeacon> getBeaconAdjList() {
        return adjBeaconRepository.getBeaconAdjList();
    }
}
