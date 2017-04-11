package net.ray.web.ees.bo;

import java.util.List;

import net.ray.web.ees.db.eo.TradeMonthlyAchievement;


public interface TradeMonthlyBO {
	public List<TradeMonthlyAchievement> getMonthlyAchievementBycondition(TradeMonthlyAchievement tradeMonthlyAchievement);
}
