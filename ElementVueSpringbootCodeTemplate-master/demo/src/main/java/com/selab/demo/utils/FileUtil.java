package com.selab.demo.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.rmi.server.UID;

@Component
public class FileUtil {
    public static final String UPLOAD_FILEPATH = "D:\\selab\\file\\";
    @ResponseBody
    public String getUpload(@RequestPart(value = "file") MultipartFile mf,
    @RequestParam(value = "PID") Integer PID) throws IOException {

        System.out.println("文件上传信息:"+mf.getOriginalFilename());

        //将文件上传到指定文件夹
        if (!mf.isEmpty()){
            String fileName=mf.getOriginalFilename();
            //文件上传
            String finalPath = UPLOAD_FILEPATH + PID.toString() + "\\" + fileName;
            File finaFile = new File(finalPath);
            if (!finaFile.exists())
                finaFile.mkdirs();
            mf.transferTo(new File(finalPath));
            return finalPath;

        }

        return ""; // 文件不存在
    }
    @ResponseBody
    public  String uploadWithFileInfo(@RequestPart(value = "file") MultipartFile mf,
                                      @RequestParam(value = "PID") Integer PID,
                                      @RequestParam(value = "state") String state,
                                      @RequestParam(value = "fileType") String fileType) throws IOException {

        System.out.println("文件上传信息: "+mf.getOriginalFilename());

        //将文件上传到指定文件夹
        if (!mf.isEmpty()){
            String fileName=mf.getOriginalFilename();
            //文件上传
            String finalPath = UPLOAD_FILEPATH + PID.toString() + "\\" + state + fileType +  "_" + fileName ;
            File finalFile = new File(finalPath);
            if (!finalFile.exists())
                finalFile.mkdirs();
            mf.transferTo(new File(finalPath));
            return finalPath;

        }

        return ""; // 文件不存在
    }
    public String killProcess(Integer PID){
        String path = UPLOAD_FILEPATH + PID.toString();
        if (!path.endsWith(File.separator)) {
            path = path + File.separator;
        }
        File file = new File(path);

        if(!file.exists()) return "服务器中不存在该进程";
        if(deleteFile(file)) return "进程已终止";
        else return "文件删除失败,请检查文件是否存在以及文件路径是否正确";
    }
    public static Boolean deleteFile(File file) {
        //判断文件不为null或文件目录存在
        if (file == null || !file.exists()) {
            System.out.println("文件删除失败,请检查文件是否存在以及文件路径是否正确");
            return false;
        }
        //获取目录下子文件
        File[] files = file.listFiles();
        //遍历该目录下的文件对象
        for (File f : files) {
            //判断子目录是否存在子目录,如果是文件则删除
            if (f.isDirectory()) {
                //递归删除目录下的文件
                deleteFile(f);
            } else {
                //文件删除
                f.delete();
                //打印文件名
                System.out.println("文件名：" + f.getName());
            }
        }
        //文件夹删除
        file.delete();
        System.out.println("目录名：" + file.getName());
        return true;
    }
}