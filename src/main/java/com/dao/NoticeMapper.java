package com.dao;

import com.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<Notice> getIndexNotices();

    List<Notice> getNotices(@Param(value = "pageIndex") int pageIndex);

    Notice getNoticeByNoticeId(@Param(value = "noticeId") int noticeId);

    int getNoticeCounts();

    int addNotice(@Param(value = "noticeTitle") String noticeTitle,
                       @Param(value = "noticeAdminId") int noticeAdminId,
                       @Param(value = "noticeLongContent") String noticeLongContent);

    int deleteNotice(@Param(value = "noticeId") int noticeId);

    int updateNotice(@Param(value = "noticeId") int noticeId,
                   @Param(value = "noticeTitle") String noticeTitle,
                   @Param(value = "noticeLongContent") String noticeLongContent);

    int noticeHitsUp(@Param(value = "noticeId") int noticeId);

}
