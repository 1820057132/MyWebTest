package com.neusoft.servletTest.common;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by xhbg on 2018/8/15.
 */

@WebServlet("/headupload")
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //判断存储目的路径是否存在
        try {
            String savePath = this.getServletContext().getRealPath("/upload");
            File file = new File(savePath);
            if (!file.exists() && !file.isDirectory()) {//判断文件是否存在并且是否为一个文件夹
                file.mkdir();
            }

            //Apach文件上传流程
            //创建DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();

            //传建一个文件解析器ServletFileUpload
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置编码
            upload.setHeaderEncoding("UTF-8");
//        判断数据是否是表单数据
            if (!upload.isMultipartContent(req)) {//那传统方式的提交
                return;
                //res.getWr……
            }

            //ServletFileUpload  parseRequest 处理为list<fileItem >
            List<FileItem> list = upload.parseRequest(req);
            for (FileItem item : list) {
                if (!item.isFormField()) {
                    //获取文件名字
                    String filename = item.getName();
                    //保存老名字
                    String oldname = filename.substring(filename.lastIndexOf("\\") + 1);


                    if (filename == null || filename.isEmpty()) {
                        continue;
                    }
                    //为文件按照时间取新名字；
                    filename = new Date().getTime() + filename.substring(filename.lastIndexOf("."));
                    //获取文件输入流
                    InputStream in = item.getInputStream();
                    //开启一个输出流
                    FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);

                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer))>0){
                        out.write(buffer, 0 ,len);
                    }
                    in.close();
                    out.close();
                    item.delete();

                    resp.getWriter().print(req.getContextPath()+"/upload/"+filename);
                    //
                }
            }


        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }
}
