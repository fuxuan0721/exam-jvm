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
	
	List<User> userList = new ArrayList<User>();//用户列表
	List<TradeRecord> recordList = new ArrayList<TradeRecord>();//交易记录列表
	

	/**
	 * 默认创建一个zhangsan用户，插入5条交易记录
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
	 * 新建记录
	 * @return 返回插入的对象
	 */
	public TradeRecord newTrade(TradeRecord tr) {
		tr.setAddTime(new Date());//创建时间
		Integer id = recordList.size()+1;//模拟主键自增
		tr.setId(id);
		Integer userID = tr.getUser().getId();
		String userName = userList.get(userID-1).getUserName();
		tr.getUser().setUserName(userName);
		recordList.add(tr);
		return tr;
	}

	/**
	 * 根据交易状态码查询记录列表
	 * @param status 0 查询所有记录  ,1 支付等待,2成功支付,3失败支付
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
