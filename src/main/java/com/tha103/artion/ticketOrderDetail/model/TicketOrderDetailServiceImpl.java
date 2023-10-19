package com.tha103.artion.ticketOrderDetail.model;

import static idv.david.util.Constants.PAGE_MAX_RESULT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tha103.artion.util.HibernateUtil;

import idv.david.emp.dao.EmpDAO;
import idv.david.emp.dao.EmpDAOImpl;
import idv.david.emp.entity.Emp;

public class TicketOrderDetailServiceImpl implements TicketOrderDetailService {

	// 一個 service 實體對應一個 dao 實體
	private EmpDAO dao;

	public EmpServiceImpl() {
			dao = new EmpDAOImpl(HibernateUtil.getSessionFactory());
		}

	@Override
	public Emp addEmp(Emp emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmp(Integer empno) {
		// TODO Auto-generated method stub

	}

	@Override
	public Emp getEmpByEmpno(Integer empno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> getAllEmps(int currentPage) {
		return dao.getAll(currentPage);
	}

	@Override
	public List<Emp> getEmpsByCompositeQuery(Map<String, String[]> map) {
		Map<String, String> query = new HashMap<>();
		// Map.Entry即代表一組key-value
		Set<Map.Entry<String, String[]>> entry = map.entrySet();

		for (Map.Entry<String, String[]> row : entry) {
			String key = row.getKey();
			// 因為請求參數裡包含了action，做個去除動作
			if ("action".equals(key)) {
				continue;
			}
			// 若是value為空即代表沒有查詢條件，做個去除動作
			String value = row.getValue()[0]; // getValue拿到一個String陣列，接著[0]取得一個元素檢查

//				if (value.isEmpty() || value == null) {
			if (value == null || value.isEmpty()) { // 這是比較好的寫法，先判斷是否空值，才不會有例外發生
				continue;
			}
			query.put(key, value);
		}

		System.out.println(query);

		return dao.getByCompositeQuery(query);
	}

	@Override
	public int getPageTotal() {
		long total = dao.getTotal();
		// 計算Emp數量每頁3筆的話總共有幾頁
		int pageQty = (int) (total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
		return pageQty;
	}
}
