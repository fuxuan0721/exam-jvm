package com.fuxuan.service;

import java.util.List;

import com.fuxuan.entity.TradeRecord;

public interface TradeService {
	
	public TradeRecord newTrade(TradeRecord tr);
	
	public List<TradeRecord> getTradeList(Integer status);
}
