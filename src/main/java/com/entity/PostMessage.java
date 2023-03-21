package com.entity;

public class PostMessage {

    private int pmId;
    private int pmUserId;
    private int pmPostId;
    private int pmPostState;

    public int getPmId() {
        return pmId;
    }

    public void setPmId(int pmId) {
        this.pmId = pmId;
    }

    public int getPmUserId() {
        return pmUserId;
    }

    public void setPmUserId(int pmUserId) {
        this.pmUserId = pmUserId;
    }

    public int getPmPostId() {
        return pmPostId;
    }

    public void setPmPostId(int pmPostId) {
        this.pmPostId = pmPostId;
    }

    public int getPmPostState() {
        return pmPostState;
    }

    public void setPmPostState(int pmPostState) {
        this.pmPostState = pmPostState;
    }
}
