package com.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.PostMessageMapper;
import com.entity.FileUtil;
import com.entity.Post;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.service.PostMessageService;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostMessageService postMessageService;

    private void jsonForPosts(HttpServletResponse response, List<Post> posts, JSONArray jsonArray) throws IOException {
        for (int i=0;i<=posts.size()-1;i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("postId", posts.get(i).getPostId());
            jsonObject.put("postTitle", posts.get(i).getPostTitle());
            jsonObject.put("postUserId", posts.get(i).getPostUserId());
            jsonObject.put("postCreateTime", posts.get(i).getPostCreateTime());
            jsonObject.put("postHits", posts.get(i).getPostHits());
            int typenumber = posts.get(i).getPostType();
            if (typenumber == 0){
                String type = "文章";
                jsonObject.put("postType", type);
                jsonObject.put("postContent", posts.get(i).getPostContent());
            }else if (typenumber == 1){
                String type = "闲聊";
                jsonObject.put("postType", type);
                jsonObject.put("postChat", posts.get(i).getPostChat());
            }else if (typenumber == 2){
                String type = "绘画";
                jsonObject.put("postType", type);
                jsonObject.put("postImage", posts.get(i).getPostImage());
            }else if (typenumber == 3){
                String type = "视频";
                jsonObject.put("postType", type);
                jsonObject.put("postVideo", posts.get(i).getPostVideo());
            }
            jsonObject.put("postState",posts.get(i).getPostState());
            jsonArray.add(jsonObject);
        }
        response.setContentType("text/json;charest=utf-8");
        response.getWriter().println(jsonArray.toJSONString());
    }

    @RequestMapping("/getPostsCountByPostType")
    public void getPostsCountByPostType(@RequestParam(value = "postType") String  postType,
                                        HttpServletResponse response)throws IOException{
        int posttype = Integer.parseInt(postType);
        int postsCount = postService.getPostsCountByPostType(posttype);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("postsCount",postsCount);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonObject.toJSONString());
    }

    @RequestMapping("/getPostsByUserId")
    public void getPostsByUserId(@RequestParam(value = "userId") String userId,
                                 @RequestParam(value = "pageIndex") String pageIndex,
                                 HttpServletResponse response)throws IOException {
        int userid = Integer.parseInt(userId);
        int pageindex = Integer.parseInt(pageIndex) * 5;
        List<Post> posts = postService.getPostsByUserId(userid,pageindex);
        JSONArray jsonArray = new JSONArray();
        if (posts != null){
            jsonForPosts(response, posts, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    //获取文章帖
    @RequestMapping("/getArticlePosts")
    public void getArticlePosts(@RequestParam(value = "pageIndex") String pageIndex,
                                HttpServletResponse response)throws IOException{
        int pageindex = Integer.parseInt(pageIndex) * 10;
        List<Post> posts = postService.getArticlePosts(pageindex);
        JSONArray jsonArray = new JSONArray();
        if (posts != null){
            jsonForPosts(response, posts, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    //获取闲聊帖
    @RequestMapping("/getChatPosts")
    public void getChatPosts(@RequestParam(value = "pageIndex") String pageIndex,
                                HttpServletResponse response)throws IOException{
        int pageindex = Integer.parseInt(pageIndex) * 10;
        List<Post> posts = postService.getChatPosts(pageindex);
        JSONArray jsonArray = new JSONArray();
        if (posts != null){
            jsonForPosts(response, posts, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    //获取绘画帖
    @RequestMapping("/getImagePosts")
    public void getImagePosts(@RequestParam(value = "pageIndex") String pageIndex,
                                HttpServletResponse response)throws IOException{
        int pageindex = Integer.parseInt(pageIndex) * 10;
        List<Post> posts = postService.getImagePosts(pageindex);
        JSONArray jsonArray = new JSONArray();
        if (posts != null){
            jsonForPosts(response, posts, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    //获取视频帖
    @RequestMapping("/getVideoPosts")
    public void getVideoPosts(@RequestParam(value = "pageIndex") String pageIndex,
                                HttpServletResponse response)throws IOException{
        int pageindex = Integer.parseInt(pageIndex) * 10;
        List<Post> posts = postService.getVideoPosts(pageindex);
        JSONArray jsonArray = new JSONArray();
        if (posts != null){
            jsonForPosts(response, posts, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    //添加文章帖
    @RequestMapping("/addArticlePost")
    public void addArticlePost(@RequestParam(value = "postTitle") String postTitle,
                               @RequestParam(value = "postUserId") String postUserId,
                               @RequestParam(value = "postContent") String postContent,
                               HttpServletResponse response)throws IOException{
        if (postTitle == "" ||postUserId == "" ||postContent == ""){
            //再次检查空值情况
            response.getWriter().println("2");
        }else{
            //调用注册方法
            int PostUserId = Integer.parseInt(postUserId);
            Integer i = postService.addArticlePost(postTitle,PostUserId,postContent);
            response.getWriter().println(i);
        }
    }

    //添加闲聊帖
    @RequestMapping("/addChatPost")
    public void addChatPost(@RequestParam(value = "postTitle") String postTitle,
                               @RequestParam(value = "postUserId") String postUserId,
                               @RequestParam(value = "postChat") String postChat,
                               HttpServletResponse response)throws IOException{
        if (postTitle == "" ||postUserId == "" ||postChat == ""){
            //再次检查空值情况
            response.getWriter().println("2");
        }else{
            //调用注册方法
            int PostUserId = Integer.parseInt(postUserId);
            Integer i = postService.addChatPost(postTitle,PostUserId,postChat);
            response.getWriter().println(i);
        }
    }

    //添加绘画帖
    @RequestMapping("/addImagePosts")
    public void addImagePosts(@RequestParam(value = "postTitle") String postTitle,
                              @RequestParam(value = "postUserId") String postUserId,
                              @RequestParam(value = "postContent") String postContent,
                              @RequestParam(value = "filelist") MultipartFile filelist,
                               HttpServletResponse response, HttpServletRequest request)throws Exception{
        if (postTitle == "" ||postUserId == "" ||postContent == "" ||filelist == null){
            //再次检查空值情况
            response.getWriter().println("2");
        }else{
            if (!(filelist==null)) {

                String dirPath = request.getServletContext().getRealPath("static/resource/");

                File filePath = new File(dirPath);
                String imgPaths = new String();
                //如果文件路径不存在则创建
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                FileUtil fileUtil = new FileUtil();
                if (!(filelist == null)) {
                    imgPaths = fileUtil.fileUp(filelist, dirPath);
                }

                //调用注册方法
                int PostUserId = Integer.parseInt(postUserId);
                Integer i = postService.addImagePosts(postTitle, PostUserId, postContent, imgPaths);
                response.getWriter().println(i);
            }
        }
    }

    //添加视频帖
    @RequestMapping("/addVideoPosts")
    public void addVideoPosts(@RequestParam(value = "postTitle") String postTitle,
                              @RequestParam(value = "postUserId") String postUserId,
                              @RequestParam(value = "postContent") String postContent,
                              @RequestParam(value = "postVideo") String postVideo,
                              HttpServletResponse response)throws IOException{
        if (postTitle == "" ||postUserId == "" ||postContent == "" ||postVideo == null){
            //再次检查空值情况
            response.getWriter().println("2");
        }else{
            //调用注册方法
            int PostUserId = Integer.parseInt(postUserId);
            Integer i = postService.addVideoPosts(postTitle,PostUserId,postContent,postVideo);
            response.getWriter().println(i);
        }
    }

    //获取指定帖子
    @RequestMapping("/getPost")
    public void getPost(@RequestParam(value = "postId") String postId,
                           HttpServletResponse response)throws IOException{
        int postid = Integer.parseInt(postId);
        Post post = postService.getPostBypostId(postid);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("postId", post.getPostId());
        jsonObject.put("postTitle", post.getPostTitle());
        jsonObject.put("postUserId", post.getPostUserId());
        jsonObject.put("postCreateTime", post.getPostCreateTime());
        jsonObject.put("postHits", post.getPostHits());
        jsonObject.put("postType", post.getPostType());
        jsonObject.put("postContent", post.getPostContent());
        jsonObject.put("postChat", post.getPostChat());
        jsonObject.put("postImage", post.getPostImage());
        jsonObject.put("postVideo", post.getPostVideo());
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonObject.toJSONString());
    }

    //获取所有帖子列表
    @RequestMapping("/getAllPosts")
    public void getAllPosts(@RequestParam(value = "pageIndex") String pageIndex,
                            HttpServletResponse response)throws IOException{
        int pageindex = Integer.parseInt(pageIndex) * 10;
        List<Post> posts = postService.getAllPosts(pageindex);
        JSONArray jsonArray = new JSONArray();
        if (posts != null){
            jsonForPosts(response, posts, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    //获取对应审核状态帖子列表
    @RequestMapping("/getPostsByPostState")
    public void getPostsByPostState(@RequestParam(value = "postState") String postState,
            @RequestParam(value = "pageIndex") String pageIndex,
                                HttpServletResponse response)throws IOException{
        int poststate = Integer.parseInt(postState);
        int pageindex = Integer.parseInt(pageIndex) * 10;
        List<Post> posts = postService.getPostsByPostState(poststate,pageindex);
        JSONArray jsonArray = new JSONArray();
        if (posts != null){
            jsonForPosts(response, posts, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    //修改帖子
    @RequestMapping("/updatePost")
    public @ResponseBody Boolean updatePost(@RequestParam(value = "postId") String postId,
                                            @RequestParam(value = "postTitle") String postTitle,
                                            @RequestParam(value = "postContent") String postContent,
                                            HttpSession httpSession){
        int postid = Integer.parseInt(postId);
        System.out.println(postid);
        int i = postService.updatePost(postid,postTitle,postContent);
        if (i==1){
            //修改成功
            return true;
        }else {
            return false;
        }
    }

    //修改闲聊帖子
    @RequestMapping("/updateChatPost")
    public @ResponseBody Boolean updateChatPost(@RequestParam(value = "postId") String postId,
                                            @RequestParam(value = "postTitle") String postTitle,
                                            @RequestParam(value = "postChat") String postChat,
                                            HttpSession httpSession){
        int postid = Integer.parseInt(postId);
        System.out.println(postid);
        int i = postService.updateChatPost(postid,postTitle,postChat);
        if (i==1){
            //修改成功
            return true;
        }else {
            return false;
        }
    }

    //审核帖子
    @RequestMapping("/updatePostState")
    public @ResponseBody Boolean updatePostState(@RequestParam(value = "postId") String postId,
                                                 @RequestParam(value = "postState") String postState,
                                                 HttpSession httpSession){
        int postid = Integer.parseInt(postId);
        int poststate = Integer.parseInt(postState);
        System.out.println(postid);
        int i = postService.updatePostState(postid,poststate);
        if (i==1){
            //修改成功
            int y = postMessageService.addPostMessage(postService.getPostBypostId(postid).getPostUserId(),postid,poststate);
            return true;
        }else {
            return false;
        }
    }

    //删除帖子
    @RequestMapping("/deletePost")
    public @ResponseBody Boolean deletePost(@RequestParam(value = "postId") String postId,
                                            HttpSession httpSession){
        int postid = Integer.parseInt(postId);
        System.out.println(postid);
        int i = postService.deletePost(postid);
        if (i==1){
            //修改成功
            return true;
        }else {
            return false;
        }
    }

    //尝试性图表
    @RequestMapping("/chartPost")
    public void chartPost(HttpServletResponse response)throws IOException{
        List<Post> posts = postService.getAllPostsWithoutPage();
        String postContent = "";
        for (int i=0;i<=posts.size()-1;i++){
            String str1 = posts.get(i).getPostContent().replace("，", "");
            String str2 = str1.replace(" ", "");
            String str3 = str2.replace("↵", "");
            String str4 = str3.replace("。\n" +
                    "↵\n" +
                    "↵", "");
            String str5 = str4.replace("\r", "");
            String str6 = str5.replace("\n", "");
            postContent = postContent + str6;
        }
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<String> words = segmenter.sentenceProcess(postContent);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length()==1){
                continue;
            }
            if (map.containsKey(words.get(i)) == false) {
                map.put(words.get(i), 1);
            } else {
                map.replace(words.get(i), map.get(words.get(i)) + 1);
            }
        }
        //进行排序
        List<Map.Entry<String, Integer>> lists = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());//用map的内部接口Entry赋值
        Collections.sort(lists, new Comparator<Map.Entry<String , Integer>>() {//通过实现Comparator接口的compare方法来完成自定义排序
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());//按照value值（即计数）逆序排序
            }

        });
        //频率最高的十五个单词
        JSONArray jsonArray = new JSONArray();
        for(int i=0;i<15;i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("word", lists.get(i).getKey());
            jsonObject.put("count",lists.get(i).getValue());
            System.out.println(lists.get(i).getKey() + "   " + lists.get(i).getValue());
            jsonArray.add(jsonObject);
        }
        response.setContentType("text/json;charest=utf-8");
        response.getWriter().println(jsonArray.toJSONString());
    }

    @RequestMapping("/getPostsCountByPostState")
    public void getPostsCountByPostState(@RequestParam(value = "postState") String  postState,
                                        HttpServletResponse response)throws IOException{
        int poststate = Integer.parseInt(postState);
        int postsStateCount = postService.getPostsCountByPostState(poststate);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("postsStateCount",postsStateCount);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonObject.toJSONString());
    }

    //获取搜索帖子列表
    @RequestMapping("/queryPost")
    public void searchPost(@RequestParam(value = "postTitle") String postTitle,
                           @RequestParam(value = "pageIndex") String pageIndex,
                           HttpServletResponse response)throws IOException{
        String posttitle = "%"+postTitle+"%";
        int pageindex = Integer.parseInt(pageIndex) * 10;
        List<Post> posts = postService.searchPost(posttitle,pageindex);
        JSONArray jsonArray = new JSONArray();
        if (posts != null){
            jsonForPosts(response, posts, jsonArray);
        }else {
            response.getWriter().println("failed");
        }
    }

    //搜索得到的帖子列表总数
    @RequestMapping("/searchPostCount")
    public void searchPostCount(@RequestParam(value = "postTitle") String  postTitle,
                                         HttpServletResponse response)throws IOException{
        int postsStateCount = postService.searchPostCount(postTitle);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("postTitleCount",postsStateCount);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(jsonObject.toJSONString());
    }

    //点击帖子增加点击量
    @RequestMapping("/postHitsUp")
    public @ResponseBody Boolean postHitsUp(@RequestParam(value = "postId") String postId,
                                            HttpSession httpSession){
        int postid = Integer.parseInt(postId);
        System.out.println(postid);
        int i = postService.postHitsUp(postid);
        if (i==1){
            //修改成功
            return true;
        }else {
            return false;
        }
    }

}
