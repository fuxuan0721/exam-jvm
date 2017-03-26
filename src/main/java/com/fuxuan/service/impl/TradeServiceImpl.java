package com.fuxuan.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fuxuan.entity.TradeRecord;
import com.fuxuan.entity.User;
import com.fuxuan.service.TradeService;


@Service("TradeService")
public class TradeServiceImpl implements TradeService{
	
	List<User> userList = new ArrayList<User>();//�û��б�
	List<TradeRecord> recordList = new ArrayList<TradeRecord>();//���׼�¼�б�
	

	/**
	 * Ĭ�ϴ���һ��zhangsan�û�������5�����׼�¼
	 */
	TradeServiceImpl(){
		User userZhang = new User(1,"ZhangSan");
		User userLi = new User(2,"LiSi");
		userList.add(0,userZhang);
		userList.add(1,userLi);
		
		TradeRecord record1 = new TradeRecord(1,new Date(),2,1,BigDecimal.valueOf(5L),1,userZhang);
		TradeRecord record2 = new TradeRecord(2,new Date(),2,1,BigDecimal.valueOf(6L),1,userZhang);
		TradeRecord record3 = new TradeRecord(3,new Date(),2,1,BigDecimal.valueOf(7L),1,userZhang);
		TradeRecord record4 = new TradeRecord(4,new Date(),3,2,BigDecimal.valueOf(8L),2,userLi);
		TradeRecord record5 = new TradeRecord(5,new Date(),3,2,BigDecimal.valueOf(9L),2,userLi);
		recordList.add(record1);
		recordList.add(record2);
		recordList.add(record3);
		recordList.add(record4);
		recordList.add(record5);
		
	}
	
	/**
	 * �½���¼
	 * @return ���ز���Ķ���
	 */
	public TradeRecord newTrade(TradeRecord tr) {
		tr.setAddTime(new Date());//����ʱ��
		Integer id = recordList.size()+1;//ģ����������
		tr.setId(id);
		Integer userID = tr.getUser().getId();
		String userName = userList.get(userID-1).getUserName();
		tr.getUser().setUserName(userName);
		recordList.add(tr);
		return tr;
	}

	/**
	 * ���ݽ���״̬���ѯ��¼�б�
	 * @param status 0 ��ѯ���м�¼  ,1 ֧���ȴ�,2�ɹ�֧��,3ʧ��֧��
	 */
	public List<TradeRecord> getTradeList(Integer status) {
		if(status.intValue() != 0){
			List<TradeRecord> list = new ArrayList<TradeRecord>();
			for(TradeRecord tr : recordList){
				if(tr.getStatus().intValue() == status.intValue()){
					list.add(tr);
				}
			}
			return list;
		}else{
			return recordList;
		}
	}
}
