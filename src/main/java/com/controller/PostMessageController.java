package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Post;
import com.entity.PostMessage;
import com.service.PostMessageService;
import com.service.PostService;
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
public class PostMessageController {

    @Autowired
    private PostMessageService postMessageService;

    @Autowired
    private PostService postService;

    private void jsonForpms(HttpServletResponse response, List<PostMessage> postMessage, JSONArray jsonArray) throws IOException {
        for (int i=0;i<=postMessage.size()-1;i++) {
            JSONObject jsonObject = new JSONObject();
            String finaltitle = postService.getPostBypostId(postMessage.get(i).getPmPostId()).getPostTitle();
            String finalstate = new String();
            if (postMessage.get(i).getPmPostState() == 0){
                finalstate = "审核未通过";
            }else {
                finalstate = "审核已通过";
            }
            String finalMessage = finaltitle + finalstate;
            jsonObject.put("finalMessage", finalMessage);
            jsonObject.put("pmId",postMessage.get(i).getPmId());
            jsonArray.add(jsonObject);
        }
        response.setContentType("text/json;charest=utf-8");
        response.getWriter().println(jsonArray.toJSONString());
    }

    //获取帖子审核消息
    @RequestMapping("/getPostMessage")
    public void getPostMessage(@RequestParam(value = "pmUserId") String pmUserId,
                        HttpServletResponse response)throws IOException {
        int pmuserId = Integer.parseInt(pmUserId);
        List<PostMessage> postMessage = postMessageService.getPostMessage(pmuserId);
        JSONArray jsonArray = new JSONArray();
        if (postMessage != null){
            jsonForpms(response, postMessage, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    //删除消息
    @RequestMapping("/deletePostMessage")
    public @ResponseBody
    Boolean deletePostMessage(@RequestParam(value = "pmId") String pmId,
                       HttpSession httpSession){
        int pmid = Integer.parseInt(pmId);
        System.out.println(pmid);
        int i = postMessageService.deletePostMessage(pmid);
        if (i==1){
            //修改成功
            return true;
        }else {
            return false;
        }
    }

}
