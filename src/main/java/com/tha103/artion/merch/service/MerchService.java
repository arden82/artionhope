package com.tha103.artion.merch.service;

import java.util.List;

import com.tha103.artion.merch.model.MerchDAO;
import com.tha103.artion.merch.model.MerchVO;

public class MerchService implements MerchService_Interface {

	private MerchDAO dao;

	public MerchService() {

		dao = new MerchDAO();

	}

	@Override
	public int addMerch(MerchVO merch) {
		return dao.insert(merch);
	}

	@Override
	public int updateMerch(MerchVO merch) {
		return dao.update(merch);
	}

	@Override
	public void deleteMerch(Integer merchId) {
		dao.delete(merchId);
	}

	@Override
	public MerchVO getMerchByMerchId(Integer merchId) {
		return dao.getById(merchId);
	}

	@Override
	public List<MerchVO> getAllMerches() {
		List<MerchVO> list = dao.getAll();
		return list;
	}

}
