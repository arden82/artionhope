package com.tha103.artion.ticketOrderDetail.model;

import java.util.List;
import java.util.Map;

public interface TicketOrderDetailService {

	TicketOrderDetailVO addEmp(TicketOrderDetailVO ticketorderetailVO);

	TicketOrderDetailVO updateEmp(TicketOrderDetailVO emp);

	void deleteEmp(Integer empno);

	TicketOrderDetailVO getEmpByEmpno(Integer empno);

	List<TicketOrderDetailVO> getAllEmps(int currentPage);

	int getPageTotal();

	List<TicketOrderDetailVO> getEmpsByCompositeQuery(Map<String, String[]> map);
}
