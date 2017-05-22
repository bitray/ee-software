package net.ray.web.ees.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ray.web.ees.bo.FloorBO;
import net.ray.web.ees.bo.MallBO;
import net.ray.web.ees.bo.TradeBO;
import net.ray.web.ees.db.eo.Floors;
import net.ray.web.ees.db.eo.MallBase;
import net.ray.web.ees.db.eo.TradeType;

@Controller
@RequestMapping("/data_query")
public class DataQueryController {
	@Resource(name="floorBO")
	private FloorBO floorBO;
	@Resource
	public MallBO mallBO;
	@Resource
	private TradeBO tradeBO;
	@RequestMapping("/single_brand_query_init")
	public String singleBrandQueryInit(){
		return "single_brand_query";
	}
	
	@RequestMapping("/multiple_brand_query_init")
	public String multipleBrandQueryInit(){
		return "multiple_brand_query";
	}
	
	@RequestMapping("/basic_query_init")
	public String basicQueryInit(HttpServletRequest request){
		MallBase para=new MallBase();
		para.setIsAlive(Boolean.TRUE);
		List<MallBase> malls=mallBO.getMalls(para);
		request.setAttribute("malls", malls);
		
		List<Floors> floors=floorBO.getFloors();
		request.setAttribute("floors", floors);
		
		TradeType trade=new TradeType();
		trade.setTradeLevel(0);
		trade.setIsAlive(Boolean.TRUE);
		List<TradeType> rootTades=tradeBO.geTradeTypesBySelective(trade);
		trade.setTradeLevel(1);
		List<TradeType> leve1Trades=tradeBO.geTradeTypesBySelective(trade);
		trade.setTradeLevel(2);
		List<TradeType> leve2Trades=tradeBO.geTradeTypesBySelective(trade);
		request.setAttribute("rootTades", rootTades);
		request.setAttribute("leve1Trades", leve1Trades);
		request.setAttribute("leve2Trades", leve2Trades);
		return "basic_query";
	}
}
