package com.tha103.artion.ticketOrder.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activity.service.ActivityService;
import com.tha103.artion.ticketOrder.util.JedisPoolUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;// 請將此替換為您自己的 Redis 相關設置

@WebServlet("/CartAddServlet")
public class CartAddServlet {

	private static JedisPool pool = JedisPoolUtil.getJedisPool(); // 請替換為您自己的 Redis 相關設置

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 獲取actId的值
		String actId = req.getParameter("actId");

		try {
			// 將actId轉換為整數
			Integer actToInt = Integer.parseInt(actId);

			// 使用您的ActivityService來獲取該筆資料
			ActivityService actSvc = new ActivityService();
			ActivityVO actVO = actSvc.getOneActivity(actToInt);
			System.out.println(actVO);
			if (actVO != null) {
				// 在此處執行您需要的操作，例如將該筆資料存儲到 Redis
				saveActId(actId, actVO);
				// 或將其返回給客戶端
				// 現在 actVO 包含所需的資料，您可以根據需要處理它
			} else {
				// 沒有找到匹配的資料，您可以處理異常情況
				System.out.println("找不到匹配的活動記錄");
			}
		} catch (NumberFormatException e) {
			// 如果無法將actId轉換為整數，請處理異常情況
			System.out.println("actId 不是有效的整數");
		}
	}

	private void saveActId(String actId, ActivityVO actVO) {
		String cartId = "7001"; // 購物車的鍵名，您可以根據需要更改
		Jedis jedis = pool.getResource();

		try {
			// 創建一個 JSON 字符串來表示活動信息
			String jsonAct = "{\"actId\": " + actId + ", \"actName\": \"" + actVO.getActName() + "\", \"actTicPrice\": "
					+ actVO.getActTicketPrice() + "}";

			// 使用 Redis 的 SET 命令將活動信息存儲到購物車
			jedis.sadd(cartId, jsonAct);
			System.out.println("成功將活動添加到購物車");
		} finally {
			jedis.close();
		}
	}
}
