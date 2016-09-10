package com.seqhack.teamoc.sixthsense.repository;

import com.seqhack.teamoc.sixthsense.entity.AdjBeacon;
import com.seqhack.teamoc.sixthsense.entity.Beacon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sachin.gajraj on 9/11/16.
 */
@Repository
public interface AdjBeaconRepository extends PagingAndSortingRepository<AdjBeacon, String> {
    @Query(value = "select b from AdjBeacon b")
    public List<AdjBeacon> getBeaconAdjList();
}
