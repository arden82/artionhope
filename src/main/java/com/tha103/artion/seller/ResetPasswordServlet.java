package com.tha103.artion.seller;

import java.io.IOException;

import com.tha103.artion.seller.controller.VerificationCodeGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tha103.artion.seller.model.*;

@WebServlet("/seller/selResetPassword")
public class ResetPasswordServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 当用户通过 GET 请求访问时，你可以在这里进行一些处理，如显示密码重置表单
        request.getRequestDispatcher("/seller/sel_resetPassword.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 只有当用户通过 POST 请求提交表单时才执行密码重置逻辑
        String source = request.getParameter("source"); // 获取source参数的值

        if ("email".equals(source)) {
			String selAccount = request.getParameter("selAccount");
			System.out.println(selAccount);
			// 生成验证码
			String generatedCode = request.getParameter("generatedCode");
			System.out.println(generatedCode);
			HttpSession session = request.getSession();
			// 将验证码存储在Session
			session.setAttribute("verificationCode", generatedCode);
			System.out.println(generatedCode);
			// 继续处理密码重置请求
			String verificationCode = request.getParameter("verificationCode");
			String newPassword = request.getParameter("selPassword");
			String confirmPassword = request.getParameter("selPassword2");

			if (verificationCode != null && verificationCode.equals(generatedCode)) {
				if (newPassword.equals(confirmPassword)) {

					String sel_passwordReg = "^[a-zA-Z0-9]{2,10}$";
					if (newPassword == null || newPassword.trim().length() == 0) {
						request.setAttribute("errorMsg", "密碼不能為空");
						request.getRequestDispatcher("/seller/sel_resetPassword.jsp").forward(request, response);

					} else if (!newPassword.trim().matches(sel_passwordReg)) {
						// 密码格式不符合要求，显示错误消息或重定向到错误页面
						request.setAttribute("errorMsg", "格式不符合,只能是英文字母、數字,且長度必需在2到10之間");
						response.sendRedirect(request.getContextPath() + "/seller/sel_resetPassword.jsp");
					} else {
						// 密码符合要求，进行密码重置逻辑
						SellerDAO sellerDAO = new SellerDAO();
						if (sellerDAO.doesSellerAccountExist(selAccount)) {

							// 更新密码
							sellerDAO.updatePassword(selAccount, newPassword);
							System.out.println("成功更新密碼");
							// 密码重置成功，清除验证码
							session.removeAttribute("verificationCode");

							// 你也可以发送密码重置成功的通知邮件给用户

							// 重定向用户到密码重置成功页面
							request.setAttribute("succesfulMsg", "新密碼已設置成功，請重新登入!");
							System.out.println("成功~請登入");
							response.sendRedirect(request.getContextPath() + "/seller/sel_login.jsp");
		
						} else {
							// 邮箱不存在，显示错误消息或重定向到错误页面
							request.setAttribute("errorMsg", "不存在此信箱!!");
							response.sendRedirect(request.getContextPath() + "/seller/sel_resetPassword.jsp");
							System.out.println("錯誤1");
						}
					}
				} else {
					// 密码不匹配，显示错误消息或重定向到错误页面
					request.setAttribute("errorMsg", "兩次輸入的密碼不同!");
					System.out.println("錯誤2");
					response.sendRedirect(request.getContextPath() + "/seller/sel_resetPassword.jsp");
		

				}
			} else {
				// 验证码不匹配，显示错误消息或重定向到错误页面
				request.setAttribute("errorMsg", "驗證碼輸入錯誤!");
				System.out.println("錯誤3");

				response.sendRedirect(request.getContextPath() + "/seller/sel_resetPassword.jsp");
			}
		}
	}
}