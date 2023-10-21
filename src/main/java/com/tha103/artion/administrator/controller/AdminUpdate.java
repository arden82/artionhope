package com.tha103.artion.administrator.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.administrator.service.AdministratorService;

@WebServlet("/updateadmin")
public class AdminUpdate extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");
        res.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = res.getWriter();

        String str = req.getParameter("admId");
        // 这里应该根据 admId 从数据库或其他数据源中检索管理员详细信息
        // 假设您有一个方法 getAdminDetailsById 来获取管理员详细信息
        
        try {
            Integer admId = Integer.valueOf(str);
            
            AdministratorService admSvc = new AdministratorService();
            AdministratorVO adminVO = admSvc.getAdminByAdmId(admId);

            if (adminVO != null) {
                // 存储管理员详细信息
                HttpSession session = req.getSession();
                session.setAttribute("adminDetails", adminVO);

                // 返回成功信息
                Map<String, Object> adminDetails = new HashMap<>();
                adminDetails.put("adminId", adminVO.getAdmId());
                adminDetails.put("adminName", adminVO.getAdmName());
                adminDetails.put("adminIdentity", adminVO.getAdmIdentity());
                adminDetails.put("adminStatus", adminVO.getAdmStatus());
                adminDetails.put("adminEmailInput", adminVO.getAdmMail());
                adminDetails.put("adminPasswordInput", adminVO.getAdmPassword());
                adminDetails.put("adminBirthdayInput", adminVO.getAdmBirthday());
                adminDetails.put("adminPhoneNumberInput", adminVO.getAdmMobile());
                adminDetails.put("adminCreateTime", adminVO.getAdmAddTime());
                adminDetails.put("adminLastModifiedTime", adminVO.getAdmLastModifiedTime());
                out.write(new Gson().toJson(adminDetails));
            } else {
                // 如果未找到管理员详细信息，返回错误信息
                Map<String, Object> response = new HashMap<>();
                response.put("status", "error");
                response.put("message", "未找到管理员详细信息。");
                out.write(new Gson().toJson(response));
            }
        } catch (NumberFormatException e) {
            // 处理无效的 admId 参数
            Map<String, Object> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "无效的管理员 ID 参数。");
            out.write(new Gson().toJson(response));
        }
    }
    
    
}
