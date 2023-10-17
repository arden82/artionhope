package com.tha103.artion.memberNotify.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tha103.artion.memberNotify.model.MemberNotifyService;
import com.tha103.artion.memberNotify.model.MemberNotifyVO;


public class MemberNotifyServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("memberNotSerialNumber");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J���u�s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/membernotify/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer memberNotSerialNumber = null;
				try {
					memberNotSerialNumber = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("���u�s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/membernotify/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				MemberNotifyService memberNotifySvc = new MemberNotifyService();
				MemberNotifyVO memberNotifyVO = memberNotifySvc.getOneEmp(memberNotSerialNumber);
				if (memberNotifyVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/membernotify/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("memberNotifyVO", memberNotifyVO); // ��Ʈw���X��memberNotifyVO����,�s�Jreq
				String url = "/membernotify/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
				successView.forward(req, res);
		}
		
		if("getMem".equals(action)) {
			Integer memId = Integer.valueOf(req.getParameter("memId").trim());
			MemberNotifyService memberNotifySvc = new MemberNotifyService();
			List<MemberNotifyVO> memberNotifyVO = memberNotifySvc.getMemID(memId);
			req.setAttribute("memberNotifyVO", memberNotifyVO); // ��Ʈw���X��memberNotifyVO����,�s�Jreq
			String url = "/membernotify/filter.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOneEmp.jsp
			successView.forward(req, res);
			
		}
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllEmp.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer memberNotSerialNumber = Integer.valueOf(req.getParameter("memberNotSerialNumber"));
				
				/***************************2.�}�l�d�߸��****************************************/
				MemberNotifyService memberNotifySvc = new MemberNotifyService();
				MemberNotifyVO memberNotifyVO = memberNotifySvc.getOneEmp(memberNotSerialNumber);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("memberNotifyVO", memberNotifyVO);         // ��Ʈw���X��memberNotifyVO����,�s�Jreq
				String url = "/membernotify/update_emp_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // �Ӧ�update_emp_input.jsp���ШD
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
			Integer memberNotSerialNumber = Integer.valueOf(req.getParameter("memberNotSerialNumber"));

		


Integer memId = Integer.valueOf(req.getParameter("memId").trim());

boolean memberNotReadStatus = Boolean.parseBoolean(req.getParameter("memberNotReadStatus"));

boolean memberNotExistStatus = Boolean.parseBoolean(req.getParameter("memberNotExistStatus"));
				
String memberNotContent = req.getParameter("memberNotContent");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,20}$";
				if (memberNotContent == null || memberNotContent.trim().length() == 0) {
					errorMsgs.add("�q�����e: �ФŪť�");
				} else if(!memberNotContent.trim().matches(enameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("�q�����e: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb1��20����");
	            }
					
				
				

				

				MemberNotifyVO memberNotifyVO = new MemberNotifyVO();
				memberNotifyVO.setMemberNotSerialNumber(memberNotSerialNumber);
				memberNotifyVO.setMemId(memId);
				memberNotifyVO.setMemberNotReadStatus(memberNotReadStatus);
				memberNotifyVO.setMemberNotExistStatus(memberNotExistStatus);
				memberNotifyVO.setMemberNotContent(memberNotContent);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("memberNotifyVO", memberNotifyVO); // �t����J�榡���~��memberNotifyVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/membernotify/update_emp_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				MemberNotifyService memberNotifySvc = new MemberNotifyService();
				memberNotifyVO = memberNotifySvc.updateEmp(memberNotSerialNumber, memId, memberNotReadStatus, memberNotExistStatus, memberNotContent);
				
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("memberNotifyVO", memberNotifyVO); // ��Ʈwupdate���\��,���T����empVO����,�s�Jreq
				String url = "/membernotify/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOneEmp.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // �Ӧ�addEmp.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
Integer memId = Integer.valueOf(req.getParameter("memId").trim());


boolean memberNotReadStatus = Boolean.parseBoolean(req.getParameter("memberNotReadStatus"));

boolean memberNotExistStatus = Boolean.parseBoolean(req.getParameter("memberNotExistStatus"));

String memberNotContent = req.getParameter("memberNotContent");
				String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,20}$";
				if (memberNotContent == null || memberNotContent.trim().length() == 0) {
					errorMsgs.add("���u�m�W: �ФŪť�");
				} else if(!memberNotContent.trim().matches(enameReg)) { //�H�U�m�ߥ��h(�W)��ܦ�(regular-expression)
					errorMsgs.add("���u�m�W: �u��O���B�^��r���B�Ʀr�M_ , �B���ץ��ݦb1��20����");
				}
	


				

				MemberNotifyVO memberNotifyVO = new MemberNotifyVO();
				memberNotifyVO.setMemId(memId);
				memberNotifyVO.setMemberNotReadStatus(memberNotReadStatus);
				memberNotifyVO.setMemberNotExistStatus(memberNotExistStatus);
				memberNotifyVO.setMemberNotContent(memberNotContent);
				

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
                    req.setAttribute("memberNotifyVO", memberNotifyVO); // �t����J�榡���~��empVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/membernotify/addEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				MemberNotifyService memberNotifySvc = new MemberNotifyService();
				memberNotifyVO = memberNotifySvc.addEmp(memId, memberNotReadStatus, memberNotExistStatus, memberNotContent);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/membernotify/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllEmp.jsp
				successView.forward(req, res);				
		}
		
		
		if ("delete".equals(action)) { // �Ӧ�listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.�����ШD�Ѽ�***************************************/
Integer memberNotSerialNumber = Integer.valueOf(req.getParameter("memberNotSerialNumber"));
				
				/***************************2.�}�l�R�����***************************************/
				MemberNotifyService memberNotifySvc = new MemberNotifyService();
				memberNotifySvc.deleteEmp(memberNotSerialNumber);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/membernotify/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
		}
	}	
}
