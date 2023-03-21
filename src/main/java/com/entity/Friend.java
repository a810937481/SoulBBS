package com.entity;

public class Friend {

    private int friendsId;
    private int friendsUserId;
    private int friendsFollowedId;

    public int getFriendsId() {
        return friendsId;
    }

    public void setFriendsId(int friendsId) {
        this.friendsId = friendsId;
    }

    public int getFriendsUserId() {
        return friendsUserId;
    }

    public void setFriendsUserId(int friendsUserId) {
        this.friendsUserId = friendsUserId;
    }

    public int getFriendsFollowedId() {
        return friendsFollowedId;
    }

    public void setFriendsFollowedId(int friendsFollowedId) {
        this.friendsFollowedId = friendsFollowedId;
    }
}
