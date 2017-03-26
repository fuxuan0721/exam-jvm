package com.fuxuan.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuxuan.entity.TradeRecord;
import com.fuxuan.entity.User;
import com.fuxuan.service.TradeService;
import com.fuxuan.utils.JsonResult;

/**
 * 
 * @author Fuxuan
 *
 */
@Controller
public class TradeController extends JsonResult {
	
	@Autowired
	private TradeService tradeService;//交易记录相关
	
	/**
	 * 
	 * @param status 交易状态
	 * @param type 交易类型
	 * @param money 金额
	 * @param currency 币种
	 * @param userId 用户ID
	 */
	@RequestMapping("/newTrade/{status}/{type}/{count}/{currency}/{userId}")
	@ResponseBody
	public String newTrade(@PathVariable("status") Integer status,@PathVariable("type") Integer type,@PathVariable("count") BigDecimal  count,@PathVariable("currency") Integer currency,@PathVariable("userId") Integer userId){
		try {
			TradeRecord tr = new TradeRecord();
			tr.setStatus(status);
			tr.setType(type);
			tr.setCount(count);
			tr.setCurrency(currency);
			User user = new User();
			user.setId(userId);
			tr.setUser(user);
			TradeRecord result = tradeService.newTrade(tr);
			return this.setJson(true, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return this.setJson(false, null);
		}
	}
	
	
	/**
	 * 
	 * @param status 0 查询所有记录  ,1 支付等待,2成功支付,3失败支付
	 * @return
	 */
	@RequestMapping("/getTradeList/{status}")
	@ResponseBody
	public String getTradeList(@PathVariable("status") Integer status){
		try {
			List<TradeRecord> tradeRecordList = tradeService.getTradeList(status);
			return this.setJson(true, tradeRecordList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return this.setJson(false, null);
		}
	}
	

}
