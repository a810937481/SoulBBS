package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.entity.Comment;
import com.entity.Friend;
import com.entity.Post;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    private void jsonForComments(HttpServletResponse response, List<Comment> comments, JSONArray jsonArray) throws IOException {
        for (int i=0;i<=comments.size()-1;i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("commentId", comments.get(i).getCommentId());
            jsonObject.put("commentPostId", comments.get(i).getCommentPostId());
            jsonObject.put("commentUserId", comments.get(i).getCommentUserId());
            jsonObject.put("commentContent", comments.get(i).getCommentContent());
            jsonObject.put("commentCreateTime", comments.get(i).getCommentCreateTime());
            jsonArray.add(jsonObject);
        }
        response.setContentType("text/json;charest=utf-8");
        response.getWriter().println(jsonArray.toJSONString());
    }

    @RequestMapping("/getCommentsByPostId")
    public void getCommentsByPostId(@RequestParam(value = "commentPostId") String commentPostId,
                                 @RequestParam(value = "pageIndex") String pageIndex,
                                 HttpServletResponse response)throws IOException {
        int commentpostid = Integer.parseInt(commentPostId);
        int pageindex = Integer.parseInt(pageIndex) * 5;
        List<Comment> comments = commentService.getComment(commentpostid,pageindex);
        JSONArray jsonArray = new JSONArray();
        if (comments != null){
            jsonForComments(response, comments, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    @RequestMapping("/getCommentsCountByPostId")
    public void getCommentsCountByPostId(@RequestParam(value = "commentPostId") String  commentPostId,
                                        HttpServletResponse response)throws IOException{
        int commentpostId = Integer.parseInt(commentPostId);
        int commentsCount = commentService.getCommentsCountByPostId(commentpostId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("commentsCount",commentsCount);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonObject.toJSONString());
    }

    @RequestMapping("/addComment")
    public void addComment(@RequestParam(value = "commentPostId") String commentPostId,
                           @RequestParam(value = "commentUserId") String commentUserId,
                           @RequestParam(value = "commentContent") String commentContent,
                           HttpServletResponse response)throws IOException{

        if (commentPostId == null ||commentUserId == null ||commentContent == null){
            //再次检查空值情况
            response.getWriter().println("2");
        }else{
            int commentpostid = Integer.parseInt(commentPostId);
            int commentuserid = Integer.parseInt(commentUserId);
            int count = commentService.addComment(commentpostid,commentuserid,commentContent);
            response.getWriter().println(count);
        }
    }

    @RequestMapping("/deleteComment")
    public void deleteComment(@RequestParam(value = "commentId") String commentId,
                             HttpServletResponse response)throws IOException{

        int commentid = Integer.parseInt(commentId);
        int count = commentService.deleteComment(commentid);
        if (count == 1){
            //删除成功
            response.getWriter().println(1);
        }else {
            response.getWriter().println(0);
        }
    }

}
