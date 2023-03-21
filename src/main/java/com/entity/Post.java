package com.entity;

public class Post {

    private int postId;
    private String postTitle;
    private int postUserId;
    private String postCreateTime;
    private int postHits;
    private int postType;
    private String postContent;
    private String postChat;
    private String postImage;
    private String postVideo;
    private int postState;

    public Post(){}

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public int getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(int postUserId) {
        this.postUserId = postUserId;
    }

    public String getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(String postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    public int getPostHits() {
        return postHits;
    }

    public void setPostHits(int postHits) {
        this.postHits = postHits;
    }

    public int getPostType() {
        return postType;
    }

    public void setPostType(int postType) {
        this.postType = postType;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostChat() {
        return postChat;
    }

    public void setPostChat(String postChat) {
        this.postChat = postChat;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public String getPostVideo() {
        return postVideo;
    }

    public void setPostVideo(String postVideo) {
        this.postVideo = postVideo;
    }

    public int getPostState() {
        return postState;
    }

    public void setPostState(int postState) {
        this.postState = postState;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postUserId=" + postUserId +
                ", postCreateTime='" + postCreateTime + '\'' +
                ", postHits=" + postHits +
                ", postType=" + postType +
                ", postContent=" + postContent +
                ", postChat='" + postChat + '\'' +
                ", postImage='" + postImage + '\'' +
                ", postVideo='" + postVideo + '\'' +
                ", postState=" + postState +
                '}';
    }
}
