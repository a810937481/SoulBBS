package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.FileUtil;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class FlieController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserAvatar")
    public void getUserAvatar(@RequestParam(value = "userUid") String userUid,
                              HttpServletResponse response)throws IOException{
        String userAvatar = userService.getUserAvatarByUid(userUid);
        if (userAvatar!=null){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userAvatar",userAvatar);
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().println(jsonObject.toJSONString());
        }
    }

    @RequestMapping("/userAvatarUpload")
    public void userAvatarUpload(
            @RequestParam(value = "userUid") String userUid,
            @RequestParam(value = "filelist") MultipartFile filelist,
            HttpServletResponse response, HttpServletRequest request)throws Exception {
        if (!(filelist==null)) {

            String dirPath = request.getServletContext().getRealPath("static/resource/");

            File filePath = new File(dirPath);
            String imgPaths = new String();
            //如果文件路径不存在则创建
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            FileUtil fileUtil=new FileUtil();
            if(!(filelist==null)){
                imgPaths = fileUtil.fileUp(filelist,dirPath);
            }


            Integer d=userService.updateUsrAvatarByUid(imgPaths,userUid);
            if(d>0) {
                //图片上传成功
                response.getWriter().println("0");
            }else {
                response.getWriter().println("1");
            }
        }else {
            //没有图像输入的情况下
            response.getWriter().println("2");
        }
    }

}
