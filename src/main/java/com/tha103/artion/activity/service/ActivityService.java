package com.tha103.artion.activity.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.tha103.artion.activity.model.ActivityDAO;
import com.tha103.artion.activity.model.ActivityDAO_interface;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.activityComment.model.ActivityCommentVO;
import com.tha103.artion.activityLike.model.ActivityLikeVO;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.memberCollection.model.MemberCollectionVO;
import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.ticketOrderDetail.model.TicketOrderDetailVO;
import com.tha103.artion.util.HibernateUtil;

public class ActivityService {

	private ActivityDAO_interface dao;

	public ActivityService() {
		dao = new ActivityDAO();
	}

	public ActivityVO addActivity(String act_name, Integer act_ticketPrice, Date act_ticketStartTime,
			Date act_ticketEndTime, Integer act_type, Date act_startDate, Date act_endDate, Time act_startTime,
			Time act_endTime, String act_city, String act_zone, String act_address, String act_organization,
			String act_email, String act_phone, Integer act_ticketTotal, String act_content, byte[] act_coverPicture,
			byte[] act_picture1, byte[] act_picture2, byte[] act_picture3, Integer selId) {

		ActivityVO activityVO = new ActivityVO();

		activityVO.setActName(act_name);
		activityVO.setActTicketPrice(act_ticketPrice);
		activityVO.setActTicketStartTime(act_ticketStartTime);
		activityVO.setActTicketEndTime(act_ticketEndTime);
		activityVO.setActType(act_type);
		activityVO.setActStartDate(act_startDate);
		activityVO.setActEndDate(act_endDate);
		activityVO.setActStartTime(act_startTime);
		activityVO.setActEndTime(act_endTime);
		activityVO.setActCity(act_city);
		activityVO.setActZone(act_zone);
		activityVO.setActAddress(act_address);
		activityVO.setActOrganization(act_organization);
		activityVO.setActEmail(act_email);
		activityVO.setActPhone(act_phone);
		activityVO.setActTicketTotal(act_ticketTotal);
		activityVO.setActContent(act_content);
		activityVO.setActCoverPicture(act_coverPicture);
		activityVO.setActPicture1(act_picture1);
		activityVO.setActPicture2(act_picture2);
		activityVO.setActPicture3(act_picture3);

		activityVO.setActLikeTimes(0);
		activityVO.setActViews(0);
		activityVO.setActApproalStatus(2);
		activityVO.setActStatus(2);
		
		activityVO.setActLongitude(new BigDecimal("00.00000"));
		activityVO.setActLatitude(new BigDecimal("00.00000"));
		activityVO.setActTicketTotalSell(0);
		
	    SellerVO sellerVO = new SellerVO();
	    sellerVO.setSelId(selId); // 使用賣家的ID
	    activityVO.setSeller(sellerVO);

		AdministratorVO administrator = new AdministratorVO();
		administrator.setAdmId(10001); // 这里假设管理员的 ID 为 10001
		activityVO.setAdmId(administrator);

		
//		AdministratorVO administrator = session.get(AdministratorVO.class, 1001);
//		activityVO.setAdmId(administrator);
		
		System.out.println("here");
		activityVO.setActLastModifiedTime(new Timestamp(System.currentTimeMillis()));
		activityVO.setActResultContent("無");

		dao.insert(activityVO);
		System.out.println("here2");

		return activityVO;
	}
		
	public ActivityVO updateActivity(Integer act_id, String act_name , Integer act_ticketPrice,
			Date act_ticketStartTime, Date act_ticketEndTime, Integer act_type, Date act_startDate,
			Date act_endDate, Time act_startTime, Time act_endTime, String act_city, String act_zone,
			String act_address, String act_organization, String act_email, String act_phone, Integer act_ticketTotal,
			String act_content, byte[] act_coverPicture, byte[] act_picture1, byte[] act_picture2, byte[] act_picture3,
			Integer act_likeTimes, Integer act_views, Integer act_approalStatus, Integer act_status,
			BigDecimal act_longitude, BigDecimal act_latitude, Integer act_ticketTotalSell,
			Timestamp act_lastModifiedTime, String act_ResultContent) {

		ActivityVO activityVO = new ActivityVO();

		activityVO.setActId(act_id);
		activityVO.setActName(act_name);
		activityVO.setActTicketPrice(act_ticketPrice);
		activityVO.setActTicketStartTime(act_ticketStartTime);
		activityVO.setActTicketEndTime(act_ticketEndTime);
		activityVO.setActType(act_type);
		activityVO.setActStartDate(act_startDate);
		activityVO.setActEndDate(act_endDate);
		activityVO.setActStartTime(act_startTime);
		activityVO.setActEndTime(act_endTime);
		activityVO.setActCity(act_city);
		activityVO.setActZone(act_zone);
		activityVO.setActAddress(act_address);
		activityVO.setActOrganization(act_organization);
		activityVO.setActEmail(act_email);
		activityVO.setActPhone(act_phone);
		activityVO.setActTicketTotal(act_ticketTotal);
		activityVO.setActContent(act_content);
		activityVO.setActCoverPicture(act_coverPicture);
		activityVO.setActPicture1(act_picture1);
		activityVO.setActPicture2(act_picture2);
		activityVO.setActPicture3(act_picture3);
		activityVO.setActLikeTimes(0);
		activityVO.setActViews(0);
		activityVO.setActApproalStatus(2);
		activityVO.setActStatus(2);
	
		activityVO.setActLongitude(new BigDecimal("00.00000"));
		activityVO.setActLatitude(new BigDecimal("00.00000"));
		activityVO.setActTicketTotalSell(0);

		activityVO.setActLastModifiedTime(new Timestamp(System.currentTimeMillis()));
		activityVO.setActResultContent("無");

		dao.update(activityVO);

		return activityVO;
	}

	// 查詢全部活動
	public List<ActivityVO> getAll() {
		return dao.getAll();
	}

	public ActivityVO getOneActivity(Integer actId) {
		// TODO Auto-generated method stub
		return null;
	}


//	// 查詢展覽活動
//	public List<ActivityVO> getExhAct(String type) {
//      return ActivityDAO.getExhAct(type);
//
//    //查詢市集活動
//	public List<ActivityVO> getMarAct(String type) {
//		return ActivityDAO.getActType("市集");
//	}
//
//	// 查詢市集活動
//	public List<ActivityVO> getPerAct(String type) {
//		return ActivityDAO.getPerType("表演");
//	}

	// 查詢分類活動
//	@Transactional
//    public List<ActivityVO> getActType(String type) {
//        return ActivityDAO.getActType(type);
//    }
}
