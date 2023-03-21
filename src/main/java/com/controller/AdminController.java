package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Admin;
import com.entity.AdminRights;
import com.entity.User;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/adminIndex")
    public String adminIndex(){
        return "admin.html";
    }

    //登录功能
    @RequestMapping("/loginAdmin")
    public void loginAdmin(@RequestParam(value = "adminUid")String adminUid,
                        @RequestParam(value = "adminPassword")String adminPassword,
                      HttpServletResponse response) throws IOException {
        Admin admin = adminService.getAdminByUid(adminUid);
        if (admin == null){
            //不存在该账号
            response.getWriter().println(0);
        }else {
            if (adminPassword.equals(admin.getAdminPassword())){
                //账号密码正确
                AdminRights adminRights = adminService.getAdminRights(admin.getAdminId());
                Cookie cookie = new Cookie("adminId",String.valueOf(admin.getAdminId()));
                Cookie cookie1 = new Cookie("adminUid",admin.getAdminUid());
                Cookie cookie2 = new Cookie("adminName",admin.getAdminName());
                Cookie cookie3 = new Cookie("rightsNotice",String.valueOf(adminRights.getRightsNotice()));
                Cookie cookie4 = new Cookie("rightsPost",String.valueOf(adminRights.getRightsPost()));
                Cookie cookie5 = new Cookie("rightsUser",String.valueOf(adminRights.getRightsUser()));
                Cookie cookie6 = new Cookie("rightsBest",String.valueOf(adminRights.getRightsBest()));
                cookie.setMaxAge(36000);
                cookie1.setMaxAge(36000);
                cookie2.setMaxAge(36000);
                cookie3.setMaxAge(36000);
                cookie4.setMaxAge(36000);
                cookie5.setMaxAge(36000);
                cookie6.setMaxAge(36000);
                response.addCookie(cookie);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                response.addCookie(cookie3);
                response.addCookie(cookie4);
                response.addCookie(cookie5);
                response.addCookie(cookie6);
                response.getWriter().println(1);
            } else {
                //账号密码错误
                response.getWriter().println(2);
            }
        }
    }

    private void jsonForAdmins(HttpServletResponse response, List<Admin> admins, JSONArray jsonArray) throws IOException {
        for (int i=0;i<=admins.size()-1;i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("adminId", admins.get(i).getAdminId());
            jsonObject.put("adminUid", admins.get(i).getAdminUid());
            jsonObject.put("adminName", admins.get(i).getAdminName());
            jsonArray.add(jsonObject);
        }
        response.setContentType("text/json;charest=utf-8");
        response.getWriter().println(jsonArray.toJSONString());
    }

    //获取所有管理员列表
    @RequestMapping("/getAllAdmin")
    public void getAllAdmin(@RequestParam(value = "pageIndex") String pageIndex,
                           HttpServletResponse response)throws IOException{
        int pageindex = Integer.parseInt(pageIndex) * 5;
        List<Admin> admins = adminService.getAllAdmin(pageindex);
        JSONArray jsonArray = new JSONArray();
        if (admins != null){
            jsonForAdmins(response, admins, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    //开启权限
    @RequestMapping("/onAdminRights")
    public @ResponseBody
    Boolean onAdminRights(@RequestParam(value = "rightsAdminId") String rightsAdminId){
        int rightsadminId = Integer.parseInt(rightsAdminId);
        System.out.println(rightsadminId);
        int i = adminService.onAdminRights(rightsadminId);
        if (i==1){
            //修改成功
            return true;
        }else {
            return false;
        }
    }

    //关闭权限
    @RequestMapping("/offAdminRights")
    public @ResponseBody
    Boolean offAdminRights(@RequestParam(value = "rightsAdminId") String rightsAdminId){
        int rightsadminId = Integer.parseInt(rightsAdminId);
        System.out.println(rightsadminId);
        int i = adminService.offAdminRights(rightsadminId);
        if (i==1){
            //修改成功
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/getAdminCounts")
    public void getAdminCounts(HttpServletResponse response)throws IOException{
        int adminCounts = adminService.getAdminCounts();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("adminCounts",adminCounts);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonObject.toJSONString());
    }

    //注册用户
    @RequestMapping("/addAdmin")
    public void addAdmin(@RequestParam(value = "adminUid") String adminUid,
                             @RequestParam(value = "adminPassword") String adminPassword,
                             @RequestParam(value = "adminName") String adminName,
                             HttpServletResponse response)throws IOException{
        if (adminUid == null ||adminPassword == null ||adminName == null){
            //再次检查空值情况
            response.getWriter().println(2);
        }else{
            //调用注册方法
            Integer i = adminService.addAdmin(adminUid,adminPassword,adminName);
            response.getWriter().println(i);
            if (i == 1){
                adminService.addNewRights(adminService.getAdminByUid(adminUid).getAdminId());
            }
        }
    };

}
