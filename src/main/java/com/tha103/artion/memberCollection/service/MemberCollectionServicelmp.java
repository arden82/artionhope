package com.tha103.artion.memberCollection.service;

import java.util.List;

import com.tha103.artion.memberCollection.model.MemberCollectionDAO;
import com.tha103.artion.memberCollection.model.MemberCollectionDAOlmp;
import com.tha103.artion.memberCollection.model.MemberCollectionVO;
import com.tha103.artion.util.HibernateUtil;

public class MemberCollectionServicelmp implements MemberCollectionService {
	MemberCollectionDAO dao;
	
	public MemberCollectionServicelmp() {
		dao=new MemberCollectionDAOlmp(HibernateUtil.getSessionFactory());
	}
	@Override
	public int insert(MemberCollectionVO entity, Integer memId, Integer actId) {
		return dao.insert(entity, memId, actId);
	}

	@Override
	public int update(MemberCollectionVO entity) {
		return dao.update(entity);
	}
	
	@Override
	public MemberCollectionVO getCollection(Integer memId,Integer actId) {
		return dao.getCollection(memId,actId);
	}
	@Override
	public List<MemberCollectionVO> memberCollectionList(Integer memId) {
	
		return dao.getMember(memId);
	}

}
