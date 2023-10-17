package com.tha103.artion.memberNotify.model;

import java.util.List;

public interface MemberNotifyDAO_interface {
          public void insert(MemberNotifyVO memberNotifyVO);
          public void update(MemberNotifyVO memberNotifyVO);
          public void delete(Integer memberNotSerialNumber);
          public MemberNotifyVO findByPrimaryKey(Integer memberNotSerialNumber);
          public List<MemberNotifyVO> getAll();
          //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
