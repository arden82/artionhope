package com.tha103.artion.activity.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tha103.artion.activity.model.ActivityVO;

@WebServlet("/GetOneActServlet")
public class GetOneActServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 獲取 AJAX 請求中的 actId 參數
        String actIdStr = request.getParameter("actId");

        if (actIdStr != null) {
            try {
                // 將 actId 字串轉換為整數
                int actId = Integer.parseInt(actIdStr);

                // 在這裡使用 actId 從資料庫或其他來源中獲取相應的資料
                // 這裡需要根據你的資料存取邏輯進行處理

                // 假設你有一個名為 activity 的物件，表示單一活動
                ActivityVO activity = new ActivityVO();

                if (activity != null) {
                    // 使用 Gson 將物件轉換為 JSON 字串
                    Gson gson = new Gson();
                    String json = gson.toJson(activity);

                    // 設定回應的內容類型為 JSON
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    // 將 JSON 資料寫入回應
                    PrintWriter out = response.getWriter();
                    out.print(json);
                    out.flush();
                } else {
                    // 若未找到資料，回傳 404 Not Found
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // 若 actId 參數無效，回傳 400 Bad Request
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            } catch (Exception e) {
                e.printStackTrace();
                // 其他錯誤情況，回傳 500 Internal Server Error
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            // 若未提供 actId 參數，回傳 400 Bad Request
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}

