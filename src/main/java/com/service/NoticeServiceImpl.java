package com.service;

import com.dao.NoticeMapper;
import com.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getIndexNotices() {
        return noticeMapper.getIndexNotices();
    }

    @Override
    public List<Notice> getNotices(int pageIndex) {
        return noticeMapper.getNotices(pageIndex);
    }

    @Override
    public Notice getNoticeByNoticeId(int noticeId) {
        return noticeMapper.getNoticeByNoticeId(noticeId);
    }

    @Override
    public int getNoticeCounts() {
        return noticeMapper.getNoticeCounts();
    }

    @Override
    public int addNotice(String noticeTitle, int noticeAdminId, String noticeLongContent) {
        return noticeMapper.addNotice(noticeTitle,noticeAdminId,noticeLongContent);
    }

    @Override
    public int deleteNotice(int noticeId) {
        return noticeMapper.deleteNotice(noticeId);
    }

    @Override
    public int updateNotice(int noticeId, String noticeTitle, String noticeLongContent) {
        return noticeMapper.updateNotice(noticeId, noticeTitle, noticeLongContent);
    }

    @Override
    public int noticeHitsUp(int noticeId) {
        return noticeMapper.noticeHitsUp(noticeId);
    }
}
