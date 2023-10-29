package com.tha103.artion.memberCollection.model;

import java.util.List;

public interface MemberCollectionDAO {
	int insert (MemberCollectionVO entity,Integer memId,Integer actId);
	int update(MemberCollectionVO entity);
	MemberCollectionVO getCollection(Integer memId,Integer actId);
	List<MemberCollectionVO> getMember(Integer memId);
}