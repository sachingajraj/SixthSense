package com.seqhack.teamoc.sixthsense.repository;

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
public interface BeaconRepository extends PagingAndSortingRepository<Beacon, String> {
    @Query(value = "select b from Beacon b where b.id = :id")
    public Beacon getBeaconById(@Param(value = "id") int id);

    @Query(value = "select b from Beacon b")
    public List<Beacon> getAllBeacons();
}
