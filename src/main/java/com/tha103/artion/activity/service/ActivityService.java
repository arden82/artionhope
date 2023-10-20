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
		dao = new ActivityDAO(HibernateUtil.getSessionFactory());
	}

	// 新增活動
	public ActivityVO addActivity(ActivityVO activityVO) {
		dao.insert(activityVO);
		return activityVO;
	}

	// 更新活動
	public ActivityVO update(ActivityVO activityVO) {
		dao.insert(activityVO);
		return activityVO;
	}

	public ActivityVO getOneActivity(Integer act_id) {
		return dao.findByPK(act_id);
	}

	// 查詢全部活動
	public List<ActivityVO> getAll() {
		return dao.getAll();
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
