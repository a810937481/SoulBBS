package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Notice;
import com.entity.Post;
import com.service.AdminService;
import com.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private AdminService adminService;

    private void jsonForNotices(HttpServletResponse response, List<Notice> notices, JSONArray jsonArray) throws IOException {
        for (int i=0;i<=notices.size()-1;i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("noticeId", notices.get(i).getNoticeId());
            jsonObject.put("noticeTitle", notices.get(i).getNoticeTitle());
            jsonObject.put("noticeAdminId", notices.get(i).getNoticeAdminId());
            jsonObject.put("noticeAdminName", adminService.getAdminById(notices.get(i).getNoticeAdminId()).getAdminName());
            jsonObject.put("noticeCreateTime", notices.get(i).getNoticeCreateTime());
            jsonObject.put("noticeHits", notices.get(i).getNoticeHits());
            jsonArray.add(jsonObject);
        }
        response.setContentType("text/json;charest=utf-8");
        response.getWriter().println(jsonArray.toJSONString());
    }

    @RequestMapping("/getIndexNotices")
    public void getIndexNotices(HttpServletResponse response)throws IOException {
        List<Notice> notices = noticeService.getIndexNotices();
        JSONArray jsonArray = new JSONArray();
        if (notices != null){
            jsonForNotices(response, notices, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    @RequestMapping("/getNotices")
    public void getNotices(@RequestParam(value = "pageIndex") String pageIndex,
                                HttpServletResponse response)throws IOException{
        int pageindex = Integer.parseInt(pageIndex) * 10;
        List<Notice> notices = noticeService.getNotices(pageindex);
        JSONArray jsonArray = new JSONArray();
        if (notices != null){
            jsonForNotices(response, notices, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    @RequestMapping("/getNoticeByNoticeId")
    public void getNoticeByNoticeId(@RequestParam(value = "noticeId") String noticeId,
                        HttpServletResponse response)throws IOException{
        int noticeid = Integer.parseInt(noticeId);
        Notice notice = noticeService.getNoticeByNoticeId(noticeid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("noticeId", notice.getNoticeId());
        jsonObject.put("noticeTitle", notice.getNoticeTitle());
        jsonObject.put("noticeAdminId", notice.getNoticeAdminId());
        jsonObject.put("noticeCreateTime", notice.getNoticeCreateTime());
        jsonObject.put("noticeHits", notice.getNoticeHits());
        jsonObject.put("noticeLongContent",notice.getNoticeLongContent());
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonObject.toJSONString());
    }

    @RequestMapping("/getNoticeCounts")
    public void getNoticeCounts(HttpServletResponse response)throws IOException{
        int noticeCount = noticeService.getNoticeCounts();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("noticeCount",noticeCount);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonObject.toJSONString());
    }

    //添加公告
    @RequestMapping("/addNotice")
    public void addNotice(@RequestParam(value = "noticeTitle") String noticeTitle,
                               @RequestParam(value = "noticeAdminId") String noticeAdminId,
                               @RequestParam(value = "noticeLongContent") String noticeLongContent,
                               HttpServletResponse response)throws IOException{
        if (noticeTitle == "" ||noticeAdminId == "" ||noticeLongContent == ""){
            //再次检查空值情况
            response.getWriter().println(2);
        }else{
            //调用注册方法
            int noticeAdminid = Integer.parseInt(noticeAdminId);
            Integer i = noticeService.addNotice(noticeTitle,noticeAdminid,noticeLongContent);
            response.getWriter().println(i);
        }
    }

    //删除公告
    @RequestMapping("/deleteNotice")
    public @ResponseBody
    Boolean deleteNotice(@RequestParam(value = "noticeId") String noticeId,
                       HttpSession httpSession){
        int noticeid = Integer.parseInt(noticeId);
        System.out.println(noticeid);
        int i = noticeService.deleteNotice(noticeid);
        if (i==1){
            //修改成功
            return true;
        }else {
            return false;
        }
    }

    //修改公告
    @RequestMapping("/updateNotice")
    public @ResponseBody Boolean updateNotice(@RequestParam(value = "noticeId") String noticeId,
                                            @RequestParam(value = "noticeTitle") String noticeTitle,
                                            @RequestParam(value = "noticeLongContent") String noticeLongContent,
                                            HttpSession httpSession){
        int noticeid = Integer.parseInt(noticeId);
        System.out.println(noticeid);
        int i = noticeService.updateNotice(noticeid,noticeTitle,noticeLongContent);
        if (i==1){
            //修改成功
            return true;
        }else {
            return false;
        }
    }

    //点击公告增加点击量
    @RequestMapping("/noticeHitsUp")
    public @ResponseBody Boolean noticeHitsUp(@RequestParam(value = "noticeId") String noticeId,
                                            HttpSession httpSession){
        int noticeid = Integer.parseInt(noticeId);
        System.out.println(noticeid);
        int i = noticeService.noticeHitsUp(noticeid);
        if (i==1){
            //修改成功
            return true;
        }else {
            return false;
        }
    }

}
