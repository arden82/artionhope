package com.tha103.artion.activity.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tha103.artion.activity.model.*;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activity.service.*;

@WebServlet("/activity/ActivityServlet2.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024)
public class ActivityServlet2 extends HttpServlet {

		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		    
			String str = req.getParameter("actId");
		    Integer act_id = Integer.valueOf(str);

		    ActivityService activitySvc = new ActivityService();
		    ActivityVO activityVO = activitySvc.getOneActivity(act_id);

		    if (activityVO != null && activityVO.getActCoverPicture() != null) {
		        res.setContentType("image/jpeg");
		        InputStream in = new ByteArrayInputStream(activityVO.getActCoverPicture());
		        ServletOutputStream out = res.getOutputStream();
		        byte[] buf = new byte[4 * 1024]; // 4K buffer
		        int len;
		        while ((len = in.read(buf)) != -1) {
		            out.write(buf, 0, len);
		        }
		    } else {
		        // Handle the case where sellerVO or its profile picture is null.
		        // You can return an error message or perform other appropriate actions here.
		    }
		}

	}
		
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String str = req.getParameter("actId");
//        Integer act_id = Integer.valueOf(str);
//
//        ActivityService activitySvc = new ActivityService();
//        ActivityVO activityVO = activitySvc.getOneActivity(act_id);
//
//        if (activityVO != null) {
//            byte[] coverPicture = activityVO.getActCoverPicture();
//            byte[] picture1 = activityVO.getActPicture1();
//            byte[] picture2 = activityVO.getActPicture2();
//            byte[] picture3 = activityVO.getActPicture3();
//
//            if (coverPicture != null && picture1 != null && picture2 != null && picture3 != null) {
//                res.setContentType("image/jpeg");
//                ServletOutputStream out = res.getOutputStream();
//                out.write(coverPicture); 
//                out.write(picture1); 
//                out.write(picture2); 
//                out.write(picture3);
//            } else {
//                // 处理图片为null的情况，例如返回错误消息或执行其他适当操作
//            }
//        } else {
//            // 处理activityVO为null的情况，例如返回错误消息或执行其他适当操作
//        }
//    }
//}