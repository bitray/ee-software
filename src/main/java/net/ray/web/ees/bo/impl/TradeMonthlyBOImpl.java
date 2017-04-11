package net.ray.web.ees.bo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.TradeMonthlyBO;
import net.ray.web.ees.db.dao.TradeMonthlyAchievementMapper;
import net.ray.web.ees.db.eo.TradeMonthlyAchievement;

@Service
public class TradeMonthlyBOImpl implements TradeMonthlyBO{
	
	@Resource
	private TradeMonthlyAchievementMapper tradeMonthlyMapper;
	
	@Override
	public List<TradeMonthlyAchievement> getMonthlyAchievementBycondition(
			TradeMonthlyAchievement tradeMonthlyAchievement) {
		return tradeMonthlyMapper.selectBySelective(tradeMonthlyAchievement);
	}

}
