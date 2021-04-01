package com.nextivr.model;

/**
 * This is a single step of the test
 */
public class Step {
    private String name;
    private String next;
    private String listenForVoice;
    private String respondWithDtmf;
    private String respondWithVoice;
    private String recoTimeout;
    private String completeTimeout;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getListenForVoice() {
        return listenForVoice;
    }

    public void setListenForVoice(String listenForVoice) {
        this.listenForVoice = listenForVoice;
    }

    public String getRespondWithDtmf() {
        return respondWithDtmf;
    }

    public void setRespondWithDtmf(String respondWithDtmf) {
        this.respondWithDtmf = respondWithDtmf;
    }

    public String getRespondWithVoice() {
        return respondWithVoice;
    }

    public void setRespondWithVoice(String respondWithVoice) {
        this.respondWithVoice = respondWithVoice;
    }

    public String getRecoTimeout() {
        return recoTimeout;
    }

    public void setRecoTimeout(String recoTimeout) {
        this.recoTimeout = recoTimeout;
    }

    public String getCompleteTimeout() {
        return completeTimeout;
    }

    public void setCompleteTimeout(String completeTimeout) {
        this.completeTimeout = completeTimeout;
    }

    public Step(String name, String next, String listenForVoice, String respondWithDtmf, String respondWithVoice,
            String recoTimeout, String completeTimeout) {
        this.name = name;
        this.next = next;
        this.listenForVoice = listenForVoice;
        this.respondWithDtmf = respondWithDtmf;
        this.respondWithVoice = respondWithVoice;
        this.recoTimeout = recoTimeout;
        this.completeTimeout = completeTimeout;
    }

}
