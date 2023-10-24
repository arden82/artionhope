package com.tha103.artion.activity.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import com.tha103.artion.activity.model.ActivityDAO;
import com.tha103.artion.activity.model.ActivityDAO_interface;
import com.tha103.artion.activity.model.ActivityVO;
import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.seller.model.SellerVO;


public class ActivityService {

	private ActivityDAO_interface dao;

	public ActivityService() {
		dao = new ActivityDAO();
	}

	public ActivityVO addActivity(String act_name, Integer act_ticketPrice, Date act_ticketStartTime,
			Date act_ticketEndTime, Integer act_type, Date act_startDate, Date act_endDate, Time act_startTime,
			Time act_endTime, String act_city, String act_zone, String act_address, String act_organization,
			String act_email, String act_phone, Integer act_ticketTotal, String act_content, 
		    Integer sel_id, byte[] act_coverPicture, byte[] act_picture1, byte[] act_picture2,
		    byte[] act_picture3) {

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
		activityVO.setActApproalStatus(1);
		activityVO.setActStatus(1);

		// 创建一个SellerVO对象并设置sel_id
		SellerVO sellerVO = new SellerVO();
		sellerVO.setSelId(sel_id);
		// 将SellerVO对象设置为ActivityVO的卖家
		activityVO.setSeller(sellerVO);

		activityVO.setActLongitude(new BigDecimal("00.00000"));
		activityVO.setActLatitude(new BigDecimal("00.00000"));
		activityVO.setActTicketTotalSell(0);

		AdministratorVO administrator = new AdministratorVO();
		administrator.setAdmId(1001); // 这里假设管理员的 ID 为 1001
		activityVO.setAdmId(administrator);
		activityVO.setActResultContent("無");

		activityVO.setActLastModifiedTime(new Timestamp(System.currentTimeMillis()));

		dao.insert(activityVO);

		return activityVO;
	}

	public ActivityVO updateActivity(Integer act_id, String act_name , Integer act_ticketPrice,
			Date act_ticketStartTime, Date act_ticketEndTime, Integer act_type, Date act_startDate,
			Date act_endDate, Time act_startTime, Time act_endTime, String act_city, String act_zone,
			String act_address, String act_organization, String act_email, String act_phone, Integer act_ticketTotal,
			String act_content, byte[] act_coverPicture) {

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
//		activityVO.setActPicture1(act_picture1);
//		activityVO.setActPicture2(act_picture2);
//		activityVO.setActPicture3(act_picture3);
		activityVO.setActApproalStatus(1);
		
		dao.update(activityVO);

		return activityVO;
	}

	// 查詢全部活動//皓瑄
	public List<ActivityVO> getAll() {
		return dao.getAll();
	}

	public List<ActivityVO> getActivitiesBySellerId(Integer selId) {
	    // 修改dao方法，使其返回List<ActivityVO>，並根據selId取得多個活動
	    List<ActivityVO> activityList = dao.getActivitiesBySellerId(selId);
	    return activityList;
	}

	// 皓瑄
	public ActivityVO getOneActivity(Integer act_Id) {
		// 连接到数据库并检索指定ID的ActivityVO对象
		ActivityVO activityVO = dao.findByPK(act_Id);

		// 如果找到了匹配的ActivityVO对象，则返回它
		if (activityVO != null) {
			return activityVO;
		} else {
			// 如果未找到匹配的对象，您可以选择返回一个空的ActivityVO对象或null，或者执行其他逻辑
			return null;
		}
	}

	public void delete(Integer actId) {
		dao.delete(actId);
	}
}
