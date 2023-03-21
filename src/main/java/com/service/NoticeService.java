package com.service;

import com.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeService {

    List<Notice> getIndexNotices();

    List<Notice> getNotices(int pageIndex);

    Notice getNoticeByNoticeId(int noticeId);

    int getNoticeCounts();

    int addNotice(String noticeTitle, int noticeAdminId, String noticeLongContent);

    int deleteNotice(int noticeId);

    int updateNotice(int noticeId, String noticeTitle, String noticeLongContent);

    int noticeHitsUp(int noticeId);

}
