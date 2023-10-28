package com.tha103.artion.memberCollection.service;

import java.util.List;

import com.tha103.artion.memberCollection.model.MemberCollectionVO;

public interface  MemberCollectionService{
	int insert (MemberCollectionVO entity, Integer memId, Integer actId);
	int update(MemberCollectionVO entity);
	List<MemberCollectionVO> memberCollectionList(Integer memId);
}