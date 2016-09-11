package com.seqhack.teamoc.sixthsense.entity;

/**
 * Created by sachin.gajraj on 9/10/16.
 */
public class Step {
    int step;
    Beacon source;
    Beacon destination;
    String voiceText;

    public Step(int step, Beacon source, Beacon destination, String voiceText){
        this.step = step;
        this.source = source;
        this.destination = destination;
        this.voiceText = voiceText;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public Beacon getSource() {
        return source;
    }

    public void setSource(Beacon source) {
        this.source = source;
    }

    public Beacon getDestination() {
        return destination;
    }

    public void setDestination(Beacon destination) {
        this.destination = destination;
    }

    public String getVoiceText() {
        return voiceText;
    }

    public void setVoiceText(String voiceText) {
        this.voiceText = voiceText;
    }
}
