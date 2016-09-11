package com.seqhack.teamoc.sixthsense.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sachin.gajraj on 9/10/16.
 */
@Entity
@Table(name = "beacon")
public class Beacon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "uuid")
    String uuid;
    @Column(name = "major")
    int major;
    @Column(name = "minor")
    int minor;
    @Column(name = "beacon_location")
    String location;
    @Column(name = "beacon_type")
    String beaconType;
    @Column(name = "obs_type")
    String obsType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBeaconType() {
        return beaconType;
    }

    public void setBeaconType(String beaconType) {
        this.beaconType = beaconType;
    }

    public String getObsType() {
        return obsType;
    }

    public void setObsType(String obsType) {
        this.obsType = obsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beacon beacon = (Beacon) o;

        if (id != beacon.id) return false;
        if (major != beacon.major) return false;
        if (minor != beacon.minor) return false;
        if (uuid != null ? !uuid.equals(beacon.uuid) : beacon.uuid != null) return false;
        if (location != null ? !location.equals(beacon.location) : beacon.location != null) return false;
        if (beaconType != null ? !beaconType.equals(beacon.beaconType) : beacon.beaconType != null) return false;
        return obsType != null ? obsType.equals(beacon.obsType) : beacon.obsType == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + major;
        result = 31 * result + minor;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (beaconType != null ? beaconType.hashCode() : 0);
        result = 31 * result + (obsType != null ? obsType.hashCode() : 0);
        return result;
    }
}
