package net.ray.web.ees.bo;

import java.util.List;

import net.ray.web.ees.db.eo.TradeYearAchievement;

public interface TradeYearlyBO {
	List<TradeYearAchievement> getTradeYearAchievementsByCondition(TradeYearAchievement tradeYearAchievement);
}
