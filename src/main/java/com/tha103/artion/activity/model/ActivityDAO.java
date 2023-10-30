package com.tha103.artion.activity.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tha103.artion.administrator.model.AdministratorVO;
import com.tha103.artion.seller.model.SellerVO;
import com.tha103.artion.util.HibernateUtil;

public class ActivityDAO implements ActivityDAO_interface {

	@Override
	public int insert(ActivityVO activityVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		int actId = 0;
		try {
			session.getTransaction().begin();
			actId = (int) session.save(activityVO);
			session.getTransaction().commit();
			return actId;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(ActivityVO activityVO) {
		Session session = HibernateUtil.getSessionFactory().openSession(); // 使用 openSession 获取当前会话
		try {
			session.beginTransaction();
			session.merge(activityVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		} finally {
			session.close(); // 在完成操作后关闭会话
		}
		return 0;
	}

//	@Override
//	public int update(ActivityVO activityVO) {
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		try {
//			session.getTransaction().begin();
//			session.merge(activityVO);
//			session.getTransaction().commit();
//			return 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return -1;
//	}

	@Override // 皓瑄
	public ActivityVO findByPK(Integer actId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			ActivityVO activity = session.get(ActivityVO.class, actId);
			session.getTransaction().commit();
			return activity;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	

	public List<ActivityVO> getAll() {
		List<ActivityVO> list = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			list = session.createQuery("from ActivityVO", ActivityVO.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return list;
	}

	// 透過種類查詢
	public List<ActivityVO> getActType(String type) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String hql = "FROM Activity WHERE actType = :type";
			Query<ActivityVO> query = session.createQuery(hql, ActivityVO.class);
			query.setParameter("type", type);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	// DAO測試
	public static void main(String[] args) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			// 新增資料
			ActivityVO activityVO = new ActivityVO();
//
//			activityVO.setActName("啤酒節");
//			activityVO.setActTicketPrice(120);
//			activityVO.setActTicketStartTime(Date.valueOf("2023-09-12"));
//			activityVO.setActTicketEndTime(Date.valueOf("2023-09-12"));
//			activityVO.setActType(1);
//			activityVO.setActStartDate(Date.valueOf("2023-10-10"));
//			activityVO.setActEndDate(Date.valueOf("2023-10-31"));
//			activityVO.setActStartTime(Time.valueOf("00:00:00"));
//			activityVO.setActEndTime(Time.valueOf("00:00:00"));
//			activityVO.setActCity("台北市");
//			activityVO.setActZone("中正區");
//			activityVO.setActAddress("台北市中正區博愛路1號");
//			activityVO.setActOrganization("寬宏藝術");
//			activityVO.setActEmail("abc@gmail.com");
//			activityVO.setActPhone("0912345678");
//			activityVO.setActTicketTotal(2000);
//			activityVO.setActContent("歡迎來玩");
//			try {
//				byte[] actCoverPicture = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
//				byte[] actPicture1 = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
//				byte[] actPicture2 = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
//				byte[] actPicture3 = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\OIP.jpg");
//				activityVO.setActCoverPicture(actCoverPicture);
//				activityVO.setActPicture1(actPicture1);
//				activityVO.setActPicture2(actPicture2);
//				activityVO.setActPicture3(actPicture3);
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			activityVO.setActLikeTimes(200);
//			activityVO.setActViews(58);
//			activityVO.setActApproalStatus(1);
//			activityVO.setActStatus(1);
//
//			SellerVO sellerVO = session.get(SellerVO.class, 2001); // 以賣家的ID為例
//			activityVO.setSeller(sellerVO);
//			
//			activityVO.setActLongitude(new BigDecimal("55.40338"));
//			activityVO.setActLatitude(new BigDecimal("22.17403"));
//			activityVO.setActTicketTotalSell(158);
//			
//			AdministratorVO administratorVO = session.get(AdministratorVO.class, 1001);
//			activityVO.setAdmId(administratorVO);
//			
//			activityVO.setActLastModifiedTime(Timestamp.valueOf("2023-09-23 01:12:36"));
//			activityVO.setActResultContent("你好!我是寬宏藝術");
//
//			session.save(activityVO);
//			// 查詢單筆資料
////			ActivityVO activityVO1 = session.get(ActivityVO.class, 10001);
////			System.out.println(activityVO1);
//
////			List<ActivityVO> list = session.createQuery("from ActivityVO", ActivityVO.class).list();
////			System.out.println(list);
//			
////			ActivityDAO dao = new ActivityDAO();
////			System.out.println(dao.getAll());
//			
//			//刪除單筆資料
////			 ActivityVO activity = session.get(ActivityVO.class, 10001);
////			 session.delete(activity);
	
//			activityVO.setActName("2023台北國際咖啡節");
//			activityVO.setActTicketPrice(100);
//			activityVO.setActTicketStartTime(Date.valueOf("2023-09-10"));
//			activityVO.setActTicketEndTime(Date.valueOf("2023-10-31"));
//			activityVO.setActType(1);  //1:市集 2: 展覽 3: 表演
//			activityVO.setActStartDate(Date.valueOf("2023-10-10"));
//			activityVO.setActEndDate(Date.valueOf("2023-10-31"));
//			activityVO.setActStartTime(Time.valueOf("13:0:00"));
//			activityVO.setActEndTime(Time.valueOf("18:00:00"));
//			activityVO.setActCity("台北市");
//			activityVO.setActZone("信義區");
//			activityVO.setActAddress("台北市信義區光復南路133號");
//			activityVO.setActOrganization("台灣咖啡研究室");
//			activityVO.setActEmail("coffee1010@gmail.com");
//			activityVO.setActPhone("0922942991");
//			activityVO.setActTicketTotal(2000);
//			activityVO.setActContent("台北國際咖啡節於2017年起領先策劃縣市級咖啡相關活動，至今邁入第7年，而今年度更以「咖啡之友」為活動主題，藉由台、日烘焙大師不同文化及手法的交織，共烘焙十多個產國的咖啡豆，以多元風味帶領民眾拓展國際觀，更能透過咖啡，連結台灣與世界的友誼，邀您一同參加台北國際咖啡節！");
//			try {
//				byte[] coverpicture = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\white_bg.jpg");	
//				activityVO.setActCoverPicture(coverpicture);
//			
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//			activityVO.setActLikeTimes(58);
//			activityVO.setActViews(156); 
//			activityVO.setActApproalStatus(2); //0草稿1未審核2審核通過3審核未通過
//			activityVO.setActStatus(1);
//			SellerVO sellerVO = session.get(SellerVO.class, 2001); // 以賣家的ID為例
//			activityVO.setSeller(sellerVO);
//			activityVO.setActLongitude(new BigDecimal("25.0237"));
//			activityVO.setActLatitude(new BigDecimal("12.13345"));
//			activityVO.setActTicketTotalSell(100);
//			AdministratorVO administratorVO = session.get(AdministratorVO.class, 1001);
//			activityVO.setAdmId(administratorVO);
//			activityVO.setActLastModifiedTime(Timestamp.valueOf("2023-09-23 01:12:36"));
//			activityVO.setActResultContent("你好!您的活動已審核通過");

//			activityVO.setActName("2023 台北插畫藝術節");
//			activityVO.setActTicketPrice(200);
//			activityVO.setActTicketStartTime(Date.valueOf("2023-10-01"));
//			activityVO.setActTicketEndTime(Date.valueOf("2023-12-08"));
//			activityVO.setActType(2);  //1:市集 2: 展覽 3: 表演
//			activityVO.setActStartDate(Date.valueOf("2023-12-08"));
//			activityVO.setActEndDate(Date.valueOf("2023-12-08"));
//			activityVO.setActStartTime(Time.valueOf("12:0:00"));
//			activityVO.setActEndTime(Time.valueOf("19:00:00"));
//			activityVO.setActCity("台北市");
//			activityVO.setActZone("信義區");
//			activityVO.setActAddress("義區光復南路133號");
//			activityVO.setActOrganization("自由人藝術公寓");
//			activityVO.setActEmail("freeman111@gmail.com");
//			activityVO.setActPhone("0952773426");
//			activityVO.setActTicketTotal(1000);
//			activityVO.setActContent("屬於台北城市的插畫藝術節，以在地連結國際的插畫藝術展會。固定舉辦的常態性盛會，每年徵選一百位優秀在地、國際的插畫家，共同曝光凝聚插畫效益，推動插畫藝術產業良性循環發展，讓「插畫不再只是插畫。」");
//			try {
//				byte[] coverpicture = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\white_bg.jpg");	
//				activityVO.setActCoverPicture(coverpicture);
//	
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//			activityVO.setActLikeTimes(427);
//			activityVO.setActViews(842); 
//			activityVO.setActApproalStatus(2); //0草稿1未審核2審核通過3審核未通過
//			activityVO.setActStatus(1);
//			SellerVO sellerVO = session.get(SellerVO.class, 2001); // 以賣家的ID為例
//			activityVO.setSeller(sellerVO);
//			activityVO.setActLongitude(new BigDecimal(25.044086));
//			activityVO.setActLatitude(new BigDecimal(121.560984));
//			activityVO.setActTicketTotalSell(433);
//			AdministratorVO administratorVO = session.get(AdministratorVO.class, 1001);
//			activityVO.setAdmId(administratorVO);
//			activityVO.setActLastModifiedTime(Timestamp.valueOf("2023-09-23 01:12:36"));
//			activityVO.setActResultContent("你好!您的活動已審核通過");
	
//			activityVO.setActName("都市再生願景館");
//			activityVO.setActTicketPrice(100);
//			activityVO.setActTicketStartTime(Date.valueOf("2023-07-14"));
//			activityVO.setActTicketEndTime(Date.valueOf("2023-11-27"));
//			activityVO.setActType(2);  //1:市集 2: 展覽 3: 表演
//			activityVO.setActStartDate(Date.valueOf("2023-07-14"));
//			activityVO.setActEndDate(Date.valueOf("2023-11-27"));
//			activityVO.setActStartTime(Time.valueOf("12:0:00"));
//			activityVO.setActEndTime(Time.valueOf("18:00:00"));
//			activityVO.setActCity("台北市");
//			activityVO.setActZone("大安區");
//			activityVO.setActAddress("臺北市大安區忠孝東路三段219號");
//			activityVO.setActOrganization("社團法人臺北市都市更新學會");
//			activityVO.setActEmail("citycity@gmail.com");
//			activityVO.setActPhone("0952772141");
//			activityVO.setActTicketTotal(5000);
//			activityVO.setActContent("以懷生危老案的成功為契機，都市再生願景館期望透過保留原有建物為展場，探討都市更新的現況、困境，提出下一世代的都市再生倡議與城市願景。期望以此作為示範，使大眾、媒體有更多理解，試想各自心中的理想城市；使專業界與政策規劃者，願意開始討論現有制度改變的可能性，共同追求更理想、更完備的都市更新制度。");
//			try {
//				byte[] coverpicture = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\white_bg.jpg");	
//				activityVO.setActCoverPicture(coverpicture);
//	
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//			activityVO.setActLikeTimes(629);
//			activityVO.setActViews(1037); 
//			activityVO.setActApproalStatus(2); //0草稿1未審核2審核通過3審核未通過
//			activityVO.setActStatus(2); //1未開始 2進行中 3結束
//			SellerVO sellerVO = session.get(SellerVO.class, 2001); // 以賣家的ID為例
//			activityVO.setSeller(sellerVO);
//			activityVO.setActLongitude(new BigDecimal(25.041891));
//			activityVO.setActLatitude(new BigDecimal(121.540112));
//			activityVO.setActTicketTotalSell(191);
//			AdministratorVO administratorVO = session.get(AdministratorVO.class, 1001);
//			activityVO.setAdmId(administratorVO);
//			activityVO.setActLastModifiedTime(Timestamp.valueOf("2023-09-23 01:12:36"));
//			activityVO.setActResultContent("你好!您的活動已審核通過");
			
//			activityVO.setActName("北投溫泉博物館25週年");
//			activityVO.setActTicketPrice(100);
//			activityVO.setActTicketStartTime(Date.valueOf("2023-09-01"));
//			activityVO.setActTicketEndTime(Date.valueOf("2023-11-12"));
//			activityVO.setActType(2);  //1:市集 2: 展覽 3: 表演
//			activityVO.setActStartDate(Date.valueOf("2023-10-28"));
//			activityVO.setActEndDate(Date.valueOf("2023-11-12"));
//			activityVO.setActStartTime(Time.valueOf("13:0:00"));
//			activityVO.setActEndTime(Time.valueOf("18:00:00"));
//			activityVO.setActCity("台北市");
//			activityVO.setActZone("北投區");
//			activityVO.setActAddress("臺北市北投區中山路2號");
//			activityVO.setActOrganization("財團法人台北市文化基金會北投溫泉博物館");
//			activityVO.setActEmail("paitowhothot@gmail.com");
//			activityVO.setActPhone("0993650275");
//			activityVO.setActTicketTotal(3000);
//			activityVO.setActContent("顏色繽紛、拼砌方法變化多端的馬賽克拼貼，從公共建築到家庭生活環境，北投溫泉博物館也可以隨處其蹤影。跟孩子一起走進自然，感受陽光與草皮，一個帳篷一隻畫筆，在帳篷上自由創作，繪成屬於小朋友的秘密空間。天氣漸涼進入冬天，就來北投溫泉鄉舒活走一趟，了解北投溫泉與湯花的起源，動手製作北投湯花沐浴球，給生活來點療癒，讓身心透過溫泉與湯花獲得紓壓好心情吧！");
//			try {
//				byte[] coverpicture = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\white_bg.jpg");	
//				activityVO.setActCoverPicture(coverpicture);
//	
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//			activityVO.setActLikeTimes(204);
//			activityVO.setActViews(4319); 
//			activityVO.setActApproalStatus(2); //0草稿1未審核2審核通過3審核未通過
//			activityVO.setActStatus(1); //1未開始 2進行中 3結束
//			SellerVO sellerVO = session.get(SellerVO.class, 2001); // 以賣家的ID為例
//			activityVO.setSeller(sellerVO);
//			activityVO.setActLongitude(new BigDecimal(25.136416));
//			activityVO.setActLatitude(new BigDecimal(121.507197));
//			activityVO.setActTicketTotalSell(52);
//			AdministratorVO administratorVO = session.get(AdministratorVO.class, 1001);
//			activityVO.setAdmId(administratorVO);
//			activityVO.setActLastModifiedTime(Timestamp.valueOf("2023-08-13 13:42:52"));
//			activityVO.setActResultContent("你好!您的活動已審核通過");
			
//			activityVO.setActName("2023《親密感》編舞場創作平台");
//			activityVO.setActTicketPrice(100);
//			activityVO.setActTicketStartTime(Date.valueOf("2023-08-01"));
//			activityVO.setActTicketEndTime(Date.valueOf("2023-10-12"));
//			activityVO.setActType(1); // 1:市集 2: 展覽 3: 表演
//			activityVO.setActStartDate(Date.valueOf("2023-10-27"));
//			activityVO.setActEndDate(Date.valueOf("2023-10-29"));
//			activityVO.setActStartTime(Time.valueOf("19:3:00"));
//			activityVO.setActEndTime(Time.valueOf("16:00:00"));
//			activityVO.setActCity("台北市");
//			activityVO.setActZone("中山區");
//			activityVO.setActAddress("台灣台北市中山區民生東路二段26號");
//			activityVO.setActOrganization("特有種商行");
//			activityVO.setActEmail("st23411785@gmail.com");
//			activityVO.setActPhone("0958195935");
//			activityVO.setActTicketTotal(1000);
//			activityVO.setActContent(
//					"余余劇場製作2023年「編舞場」創作平台，以「親密感」為關鍵詞，探問在疫後時代下，嶄新的身體關係與情感樣態，乃至編舞語彙等呈現，演出四位編舞者全新作品，包括：許辰《艾迪歐計畫》、葉詠甄《怪物》、廖育伶《甬者》、熊世翔《魔法繩》。");
//			try {
//				byte[] coverpicture = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\white_bg.jpg");	
//				activityVO.setActCoverPicture(coverpicture);
//	
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//			activityVO.setActLikeTimes(101);
//			activityVO.setActViews(963);
//			activityVO.setActApproalStatus(2); // 0草稿1未審核2審核通過3審核未通過
//			activityVO.setActStatus(1); // 1未開始 2進行中 3結束
//			SellerVO sellerVO = session.get(SellerVO.class, 2001); // 以賣家的ID為例
//			activityVO.setSeller(sellerVO);
//			activityVO.setActLongitude(new BigDecimal(25.0579017));
//			activityVO.setActLatitude(new BigDecimal(121.52862062));
//			activityVO.setActTicketTotalSell(31);
//			AdministratorVO administratorVO = session.get(AdministratorVO.class, 1001);
//			activityVO.setAdmId(administratorVO);
//			activityVO.setActLastModifiedTime(Timestamp.valueOf("2023-10-20 10:31:01"));
//			activityVO.setActResultContent("你好!您的活動已審核通過");
			
//			activityVO.setActName("「時尚旖境 新•奢饗宴」品酩會");
//			activityVO.setActTicketPrice(0);
//			activityVO.setActTicketStartTime(Date.valueOf("2023-11-04"));
//			activityVO.setActTicketEndTime(Date.valueOf("2023-11-04"));
//			activityVO.setActType(2); // 1:市集 2: 展覽 3: 表演
//			activityVO.setActStartDate(Date.valueOf("2023-11-04"));
//			activityVO.setActEndDate(Date.valueOf("2023-11-04"));
//			activityVO.setActStartTime(Time.valueOf("13:00:00"));
//			activityVO.setActEndTime(Time.valueOf("20:15:00"));
//			activityVO.setActCity("台北市");
//			activityVO.setActZone("信義區");
//			activityVO.setActAddress("台灣台北市信義區市府路45號");
//			activityVO.setActOrganization("皇家禮炮 Royal Salute");
//			activityVO.setActEmail("goda1933@gmail.com");
//			activityVO.setActPhone("0983575001");
//			activityVO.setActTicketTotal(0);
//			activityVO.setActContent(
//					"皇家禮炮打造全新六感品酩會「時尚旖境 新‧奢饗宴」，走進跨界時尚空間，開拓威士忌嶄新境界，再創時尚美學新標竿! 現場沉浸式的六感體驗，遊走於夢幻與現實之境；伴隨奢華光影氛圍，交織跨領域新奢鉅作；身歷其境，進入高訂時裝的極致工藝美學；品鑑皇家禮炮新奢時尚系列第二代珍貴的酒款，見證威士忌與高訂藝術結合之美，隨著頂級威士忌製訂者皇家禮炮，前往絕無僅有的製酒工藝與時尚美學薈萃之境。");
//			try {
//				byte[] coverpicture = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\white_bg.jpg");	
//				activityVO.setActCoverPicture(coverpicture);
//	
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//			activityVO.setActLikeTimes(68);
//			activityVO.setActViews(284);
//			activityVO.setActApproalStatus(2); // 0草稿1未審核2審核通過3審核未通過
//			activityVO.setActStatus(1); // 1未開始 2進行中 3結束
//			SellerVO sellerVO = session.get(SellerVO.class, 2001); // 以賣家的ID為例
//			activityVO.setSeller(sellerVO);
//			activityVO.setActLongitude(new BigDecimal(25.034238828));
//			activityVO.setActLatitude(new BigDecimal(121.564031923));
//			activityVO.setActTicketTotalSell(0);
//			AdministratorVO administratorVO = session.get(AdministratorVO.class, 1001);
//			activityVO.setAdmId(administratorVO);
//			activityVO.setActLastModifiedTime(Timestamp.valueOf("2023-10-21 11:11:01"));
//			activityVO.setActResultContent("你好!您的活動已審核通過");
			
			activityVO.setActName("Skyline Film 屋頂電影院");
			activityVO.setActTicketPrice(100);
			activityVO.setActTicketStartTime(Date.valueOf("2023-09-01"));
			activityVO.setActTicketEndTime(Date.valueOf("2023-11-18"));
			activityVO.setActType(1); // 1:市集 2: 展覽 3: 表演
			activityVO.setActStartDate(Date.valueOf("2023-11-10"));
			activityVO.setActEndDate(Date.valueOf("2023-11-12"));
			activityVO.setActStartTime(Time.valueOf("17:00:00"));
			activityVO.setActEndTime(Time.valueOf("22:15:00"));
			activityVO.setActCity("台北市");
			activityVO.setActZone("信義區");
			activityVO.setActAddress("台灣台北市信義區松高路11號7樓");
			activityVO.setActOrganization("Skyline Film");
			activityVO.setActEmail("Skyline1122@gmail.com");
			activityVO.setActPhone("0983615009");
			activityVO.setActTicketTotal(50);
			activityVO.setActContent(
					"追求簡單生活，就從整理開始。 掌握正確的整理步驟，立刻開始行動，為自己的生活創造更多空間和清潔感， 讓我們一起揮別混亂，迎接簡單，並開始更輕鬆、有秩序的生活。");
			try {
				byte[] coverpicture = writePicture("C:\\Users\\Tibame_T14\\Desktop\\pics\\white_bg.jpg");	
				activityVO.setActCoverPicture(coverpicture);
	
			}catch(IOException e) {
				e.printStackTrace();
			}
			activityVO.setActLikeTimes(916);
			activityVO.setActViews(712);
			activityVO.setActApproalStatus(2); // 0草稿1未審核2審核通過3審核未通過
			activityVO.setActStatus(1); // 1未開始 2進行中 3結束
			SellerVO sellerVO = session.get(SellerVO.class, 2001); // 以賣家的ID為例
			activityVO.setSeller(sellerVO);
			activityVO.setActLongitude(new BigDecimal(25.04148953420592));
			activityVO.setActLatitude(new BigDecimal(121.56605430544329));
			activityVO.setActTicketTotalSell(21);
			AdministratorVO administratorVO = session.get(AdministratorVO.class, 1001);
			activityVO.setAdmId(administratorVO);
			activityVO.setActLastModifiedTime(Timestamp.valueOf("2023-09-21 10:00:00"));
			activityVO.setActResultContent("你好!您的活動已審核通過");

			session.save(activityVO);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		HibernateUtil.shutdown();
	}

	public static byte[] writePicture(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = fis.readAllBytes();
		fis.close();
		return buffer;
	}

	@Override
	public List<ActivityVO> getActivitiesBySellerId(Integer selId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			String hql = "FROM ActivityVO AS a WHERE a.seller.selId = :selId";
			Query<ActivityVO> query = session.createQuery(hql, ActivityVO.class);
			query.setParameter("selId", selId);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public void delete(Integer actId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			// Load the entity by its ID
			ActivityVO activity = session.get(ActivityVO.class, actId);

			if (activity != null) {
				// If the entity exists, delete it
				session.delete(activity);
			}

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	@Override
	public String getActNameByActId(Integer actId) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        ActivityVO activity = session.get(ActivityVO.class, actId);
	        session.getTransaction().commit();
	        if (activity != null) {
	            return activity.getActName(); // 从ActivityVO对象中获取actName
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    }
	    return null;
	}
}