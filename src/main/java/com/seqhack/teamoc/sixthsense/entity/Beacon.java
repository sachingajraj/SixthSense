package com.seqhack.teamoc.sixthsense.entity;

/**
 * Created by sachin.gajraj on 9/10/16.
 */
public class Beacon {
    String id;
    String uuid;
    String major;
    String minor;
    String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
