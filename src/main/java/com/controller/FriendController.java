package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Friend;
import com.entity.Post;
import com.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class FriendController {

    @Autowired
    private FriendService friendService;


    @RequestMapping("/followSomeone")
    public void followSomeone(@RequestParam(value = "friendsUserId") String friendsUserId,
                              @RequestParam(value = "friendsFollowedId") String friendsFollowedId,
                              HttpServletResponse response)throws IOException{

        int friendsuserid = Integer.parseInt(friendsUserId);
        int friendsfollowedid = Integer.parseInt(friendsFollowedId);
        int count = friendService.addFriend(friendsuserid,friendsfollowedid);
        if (count == 1){
            //插入成功
            response.getWriter().println(1);
        }else {
            response.getWriter().println(0);
        }
    }

    @RequestMapping("/deleteFollow")
    public void deleteFollow(@RequestParam(value = "friendsUserId") String friendsUserId,
                              @RequestParam(value = "friendsFollowedId") String friendsFollowedId,
                              HttpServletResponse response)throws IOException{

        int friendsuserid = Integer.parseInt(friendsUserId);
        int friendsfollowedid = Integer.parseInt(friendsFollowedId);
        int count = friendService.deleteFriend(friendsuserid,friendsfollowedid);
        if (count == 1){
            //删除成功
            response.getWriter().println(1);
        }else {
            response.getWriter().println(0);
        }
    }

    @RequestMapping("/insureFollow")
    public void insureFollow(@RequestParam(value = "friendsUserId") String friendsUserId,
                              @RequestParam(value = "friendsFollowedId") String friendsFollowedId,
                              HttpServletResponse response)throws IOException{

        int friendsuserid = Integer.parseInt(friendsUserId);
        int friendsfollowedid = Integer.parseInt(friendsFollowedId);
        int count = friendService.insureFollow(friendsuserid,friendsfollowedid);
        if (count == 1){
            //确认存在关注
            response.getWriter().println(1);
        }else {
            response.getWriter().println(0);
        }
    }

    private void jsonForFriends(HttpServletResponse response, List<Friend> Friends, JSONArray jsonArray) throws IOException {
        for (int i=0;i<=Friends.size()-1;i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("friendsId", Friends.get(i).getFriendsId());
            jsonObject.put("friendsUserId", Friends.get(i).getFriendsUserId());
            jsonObject.put("friendsFollowedId", Friends.get(i).getFriendsFollowedId());
            jsonArray.add(jsonObject);
        }
        response.setContentType("text/json;charest=utf-8");
        response.getWriter().println(jsonArray.toJSONString());
    }

    @RequestMapping("/getFollow")
    public void getFollow(@RequestParam(value = "friendsUserId") String friendsUserId,
                                        HttpServletResponse response)throws IOException{
        int friendsuserid = Integer.parseInt(friendsUserId);
        List<Friend> Follows = friendService.findFollow(friendsuserid);
        JSONArray jsonArray = new JSONArray();
        if (Follows != null){
            jsonForFriends(response, Follows, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    @RequestMapping("/getFans")
    public void getFans(@RequestParam(value = "friendsFollowedId") String friendsFollowedId,
                          HttpServletResponse response)throws IOException{
        int friendsfollowedid = Integer.parseInt(friendsFollowedId);
        List<Friend> Fans = friendService.findFan(friendsfollowedid);
        JSONArray jsonArray = new JSONArray();
        if (Fans != null){
            jsonForFriends(response, Fans, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

}
