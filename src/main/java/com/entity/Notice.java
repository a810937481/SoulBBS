package com.entity;

public class Notice {

    private int noticeId;
    private String noticeTitle;
    private int noticeAdminId;
    private String noticeCreateTime;
    private int noticeHits;
    private String noticeLongContent;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public int getNoticeAdminId() {
        return noticeAdminId;
    }

    public void setNoticeAdminId(int noticeAdminId) {
        this.noticeAdminId = noticeAdminId;
    }

    public String getNoticeCreateTime() {
        return noticeCreateTime;
    }

    public void setNoticeCreateTime(String noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
    }

    public int getNoticeHits() {
        return noticeHits;
    }

    public void setNoticeHits(int noticeHits) {
        this.noticeHits = noticeHits;
    }

    public String getNoticeLongContent() {
        return noticeLongContent;
    }

    public void setNoticeLongContent(String noticeLongContent) {
        this.noticeLongContent = noticeLongContent;
    }
}
