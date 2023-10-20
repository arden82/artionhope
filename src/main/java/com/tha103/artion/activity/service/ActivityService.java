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
import com.tha103.artion.seller.model.SellerDAO;
import com.tha103.artion.seller.model.SellerDAO_interface;
import com.tha103.artion.seller.model.SellerVO;

public class ActivityService {

	private ActivityDAO_interface dao;
	
		public ActivityService() {
			dao = new ActivityDAO();
		}

		public ActivityVO addActivity(String act_name, Integer act_ticketPrice, Timestamp act_ticketStartTime,
				Timestamp act_ticketEndTime, Integer act_type, Date act_startDate, Date act_endDate, Time act_startTime,
				Time act_endTime, String act_city, String act_zone, String act_address, String act_organization,
				String act_email, String act_phone, Integer act_ticketTotal, String act_content, byte[] act_coverPicture,
				byte[] act_picture1, byte[] act_picture2, byte[] act_picture3, Timestamp act_lastModifiedTime) {

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
			activityVO.setActLastModifiedTime(act_lastModifiedTime);

			dao.insert(activityVO);

			return activityVO;
		}

		public ActivityVO updateActivity(Integer act_id, String act_name, Integer act_ticketID, Integer act_ticketPrice,
				Timestamp act_ticketStartTime, Timestamp act_ticketEndTime, Integer act_type, Date act_startDate,
				Date act_endDate, Time act_startTime, Time act_endTime, String act_city, String act_zone,
				String act_address, String act_organization, String act_email, String act_phone, Integer act_ticketTotal,
				String act_content, byte[] act_coverPicture, byte[] act_picture1, byte[] act_picture2, byte[] act_picture3,
				Integer act_likeTimes, Integer act_views, Integer act_approalStatus, Integer act_status,
				BigDecimal act_longitude, BigDecimal act_latitude, Integer act_ticketTotalSell,
				Timestamp act_lastModifiedTime, String act_ResultContent) {

			ActivityVO activityVO = new ActivityVO();

			activityVO.setActId(act_id);
			activityVO.setActName(act_name);
			activityVO.setActTicketID(act_ticketID);
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
			activityVO.setActLikeTimes(act_likeTimes);
			activityVO.setActViews(act_views);
			activityVO.setActApproalStatus(act_approalStatus);
			activityVO.setActStatus(act_status);
		
			activityVO.setActLongitude(act_longitude);
			activityVO.setActLatitude(act_latitude);
			activityVO.setActTicketTotalSell(act_ticketTotalSell);

			activityVO.setActLastModifiedTime(act_lastModifiedTime);
			activityVO.setActResultContent(act_ResultContent);

			dao.update(activityVO);

			return activityVO;
		}

		public ActivityVO getOneActivity(Integer act_id) {
			return dao.findByPrimaryKey(act_id);
		}

		public List<ActivityVO> getAll() {
			return dao.getAll();
		}
	}	