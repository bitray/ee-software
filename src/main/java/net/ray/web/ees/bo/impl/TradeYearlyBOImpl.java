package net.ray.web.ees.bo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.TradeYearlyBO;
import net.ray.web.ees.db.dao.TradeYearAchievementMapper;
import net.ray.web.ees.db.eo.TradeYearAchievement;

@Service
public class TradeYearlyBOImpl implements TradeYearlyBO {
	@Resource
	private TradeYearAchievementMapper tradeYearAchievementMapper;
	
	@Override
	public List<TradeYearAchievement> getTradeYearAchievementsByCondition(TradeYearAchievement tradeYearAchievement) {
		// TODO Auto-generated method stub
		return tradeYearAchievementMapper.selectBySelective(tradeYearAchievement);
	}

}
