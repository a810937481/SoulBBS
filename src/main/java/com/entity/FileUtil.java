package com.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtil {

    /**
     * 文件上传方法
     * @param uploadFile
     * @param dirPath
     */
    public String fileUp(MultipartFile uploadFile, String dirPath){
        String newFileName="";

        String originFileName = uploadFile.getOriginalFilename();
        //UUID唯一指定机器数
        newFileName = UUID.randomUUID()
                + originFileName.substring(originFileName.lastIndexOf("."));
        try {
            uploadFile.transferTo(new File(dirPath + newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "static/resource/"+newFileName;
    }


}
