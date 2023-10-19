package com.tha103.artion.activity.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tha103.artion.activity.model.*;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activity.service.*;

public class ActivityServlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String str = req.getParameter("act_id");
        Integer act_id = Integer.valueOf(str);

        ActivityService activitySvc = new ActivityService();
        ActivityVO activityVO = activitySvc.getOneActivity(act_id);

        if (activityVO != null) {
            byte[] coverPicture = activityVO.getActCoverPicture();
            byte[] picture1 = activityVO.getActPicture1();
            byte[] picture2 = activityVO.getActPicture2();
            byte[] picture3 = activityVO.getActPicture3();

            if (coverPicture != null && picture1 != null && picture2 != null && picture3 != null) {
                res.setContentType("image/jpeg");
                ServletOutputStream out = res.getOutputStream();
                out.write(coverPicture); 
                out.write(picture1); 
                out.write(picture2); 
                out.write(picture3);
            } else {
                // 处理图片为null的情况，例如返回错误消息或执行其他适当操作
            }
        } else {
            // 处理activityVO为null的情况，例如返回错误消息或执行其他适当操作
        }
    }
}