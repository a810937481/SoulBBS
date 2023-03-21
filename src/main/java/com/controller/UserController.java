package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Notice;
import com.entity.Post;
import com.entity.User;
import com.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender javaMailSender;

    //登录功能
    @RequestMapping("/Login")
    public void Login(String userUid,
                      String userPassword,
                      HttpServletResponse response) throws IOException{
        User user = userService.getUserByUid(userUid);
        if (user == null){
            //不存在该账号
            response.getWriter().println(0);
        }else {
            if (userPassword.equals(user.getUserPassword())){
                //账号密码正确
                Cookie cookie = new Cookie("userId",String.valueOf(user.getUserId()));
                Cookie cookie1 = new Cookie("userUid",user.getUserUid());
                Cookie cookie2 = new Cookie("userName",user.getUserName());
                Cookie cookie3 = new Cookie("userState",String.valueOf(user.getUserState()));
                cookie.setMaxAge(36000);
                cookie1.setMaxAge(36000);
                cookie2.setMaxAge(36000);
                cookie3.setMaxAge(36000);
                response.addCookie(cookie);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
                response.addCookie(cookie3);
                response.getWriter().println(1);
            } else {
                //账号密码错误
                response.getWriter().println(2);
            }
        }
    };

    //获取指定用户
    @RequestMapping("/getUser")
    public void getUser(@RequestParam(value = "userId")String userId,HttpServletResponse response)throws IOException{
        int userid = Integer.parseInt(userId);
        User user = userService.getUserById(userid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", user.getUserId());
        jsonObject.put("userName", user.getUserName());
        jsonObject.put("userCreateTime", user.getUserCreateTime());
        jsonObject.put("userAvatar", user.getUserAvatar());
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonObject.toJSONString());
    }

    //检查注册用户名Uid是否重复
    @RequestMapping("/checkUserUid")
    public void checkUserUid(@RequestParam(value = "userUid")String Uid,HttpServletResponse response)throws IOException{
        String userUid = userService.getUserUidByUid(Uid);
        if (userUid != null){
            //用户名已存在，不能创建
            response.getWriter().println(0);
        }else{
            //用户名不存在，可以创建该用户名
            response.getWriter().println(1);
        }
    };

    //检查注册用户名Name是否重复
    @RequestMapping("/checkUserName")
    public void checkUserName(@RequestParam(value = "userName")String Name,HttpServletResponse response)throws IOException{
        String userName = userService.getUserNameByName(Name);
        if (userName != null){
            //昵称已存在，不能创建
            response.getWriter().println(0);
        }else{
            //昵称不存在，可以创建该昵称
            response.getWriter().println(1);
        }
    };

    //注册用户
    @RequestMapping("/registerUser")
    public void registerUser(@RequestParam(value = "userUid") String userUid,
                        @RequestParam(value = "userPassword") String userPassword,
                        @RequestParam(value = "userName") String userName,
                        @RequestParam(value = "userEmail") String userEmail,
                        HttpServletResponse response)throws IOException{
        if (userUid == "" ||userPassword == "" ||userName == "" ||userEmail == ""){
            //再次检查空值情况
            response.getWriter().println("2");
        }else{
            //调用注册方法
            Integer i = userService.addUser(userUid,userPassword,userName,userEmail);
            response.getWriter().println(i);
        }
    };

    //修改密码时，检测用户名绑定邮箱是否对应
    @RequestMapping("/checkUserEmail")
    public void checkUserEmail(@RequestParam(value = "userUid") String userUid,
                               HttpServletResponse response)throws IOException{
        String userEmail = userService.getUserEmailByUid(userUid);
        if (userEmail != null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userUid",userUid);
            jsonObject.put("userEmail",userEmail);
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().println(jsonObject.toJSONString());
        }else {
            //因为邮箱是必填项，所以只有一种情况会找不到：用户名不存在
            response.getWriter().println("0");
        }
    };

    //发送六位数验证码邮件
    @RequestMapping("/sendMail")
    public @ResponseBody Boolean sendMail(HttpSession httpSession,
                                           @RequestParam(value = "userEmail") String userEmail){
        //生成六位数验证码
        String code = String.valueOf(new Random().nextInt(899999)+100000);
        httpSession.setAttribute("code",code);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //默认发件人地址
        mailMessage.setFrom("810937481@qq.com");
        //收件人（用户）地址
        mailMessage.setTo(userEmail);
        //邮件主题
        mailMessage.setSubject("找回souljourney用户密码");
        //邮件内容
        mailMessage.setText("请在找回密码界面输入六位验证码："+code);
        //发送邮件
        javaMailSender.send(mailMessage);
        return true;
    };

    //验证验证码
    @RequestMapping("/checkCode")
    public @ResponseBody Boolean checkCode(HttpSession httpSession,
                                           @RequestParam(value = "code") String code,
                                           @RequestParam(value = "userUid") String userUid)throws IOException{
        String trueCode = (String)httpSession.getAttribute("code");
        httpSession.setAttribute("userUid",userUid);
        if (code.equals(trueCode)){
            return true;
        }else {
            return false;
        }
    };

    //删除验证码
    @RequestMapping("/deleteCode")
    public @ResponseBody void deleteCode(HttpSession httpSession){
        httpSession.removeAttribute("code");
    }

    //修改密码
    @RequestMapping("/updateNewPassword")
    public @ResponseBody Boolean updatePassword(@RequestParam(value = "userPassword") String userPassword,
                                                HttpSession httpSession){
        String userUid = (String)httpSession.getAttribute("userUid");
        System.out.println(userUid);
        int i = userService.updateUserPassword(userPassword,userUid);
        if (i==1){
            //修改成功
            httpSession.removeAttribute("userUid");
            return true;
        }else {
            return false;
        }
    }

    //获取个人中心信息：创建时间、关注数、粉丝数、发帖量
    @RequestMapping("/getAllCountMessage")
    public void getAllCountMessage(@CookieValue("userId") String userId,
                                   HttpServletResponse response)throws IOException{
        int userid = Integer.parseInt(userId);
        String userCreateTime = userService.getUserCreateTimeById(userid);
        int userFollowCount = userService.getUserFollowsCountById(userid);
        int userFansCount = userService.getUserFansCountById(userid);
        int userPostsCount = userService.getUserPostsCountById(userid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userCreateTime",userCreateTime);
        jsonObject.put("userFollowCount",userFollowCount);
        jsonObject.put("userFansCount",userFansCount);
        jsonObject.put("userPostsCount",userPostsCount);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonObject.toJSONString());
    }

    private void jsonForUsers(HttpServletResponse response, List<User> userlist, JSONArray jsonArray) throws IOException {
        for (int i=0;i<=userlist.size()-1;i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId", userlist.get(i).getUserId());
            jsonObject.put("userUid", userlist.get(i).getUserUid());
            jsonObject.put("userName", userlist.get(i).getUserName());
            jsonObject.put("userEmail", userlist.get(i).getUserEmail());
            jsonObject.put("userCreateTime", userlist.get(i).getUserCreateTime());
            jsonObject.put("userState", userlist.get(i).getUserState());
            jsonArray.add(jsonObject);
        }
        response.setContentType("text/json;charest=utf-8");
        response.getWriter().println(jsonArray.toJSONString());
    }

    //获取所有用户列表
    @RequestMapping("/getUserList")
    public void getUserList(@RequestParam(value = "pageIndex") String pageIndex,
                            HttpServletResponse response)throws IOException{
        int pageindex = Integer.parseInt(pageIndex) * 5;
        List<User> userlist = userService.getAllUser(pageindex);
        JSONArray jsonArray = new JSONArray();
        if (userlist != null){
            jsonForUsers(response, userlist, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    //修改用户状态
    @RequestMapping("/updateUserState")
    public @ResponseBody Boolean updateUserState(@RequestParam(value = "userId") String userId,
                                            @RequestParam(value = "userState") String userState,
                                            HttpSession httpSession){
        int userid = Integer.parseInt(userId);
        int userstate = Integer.parseInt(userState);
        int i = userService.updateUserState(userid,userstate);
        if (i==1){
            //修改成功
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/userCount")
    public void userCount(HttpServletResponse response)throws IOException{
        int usercount = userService.userCount();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userCount",usercount);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonObject.toJSONString());
    }

}
