package com.seqhack.teamoc.sixthsense.reponse;

import com.seqhack.teamoc.sixthsense.entity.Beacon;

import java.util.List;

/**
 * Created by sachin.gajraj on 9/10/16.
 */
public class BeaconApiResponse extends BaseApiResponse {
    Beacon source;
    List<Beacon> destinations;

    public BeaconApiResponse(String status, String code, String message, Beacon source,
                             List<Beacon> destinations) {
        super(status, code, message);
        this.source = source;
        this.destinations = destinations;
    }

    public Beacon getSourceBeacon() {
        return source;
    }

    public void setSourceBeacon(Beacon source) {
        this.source = source;
    }

    public List<Beacon> getBeacons() {
        return destinations;
    }

    public void setBeacons(List<Beacon> destinations) {
        this.destinations = destinations;
    }
}
