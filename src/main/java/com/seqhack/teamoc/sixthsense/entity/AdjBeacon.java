package com.seqhack.teamoc.sixthsense.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sachin.gajraj on 9/11/16.
 */
@Entity
@Table(name = "adj_beacons")
public class AdjBeacon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "bid")
    int bid;
    @Column(name = "next_bid")
    int adjBid;
    @Column(name = "trans_msg")
    String transitionMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getAdjBid() {
        return adjBid;
    }

    public void setAdjBid(int adjBid) {
        this.adjBid = adjBid;
    }

    public String getTransitionMessage() {
        return transitionMessage;
    }

    public void setTransitionMessage(String transitionMessage) {
        this.transitionMessage = transitionMessage;
    }
}
