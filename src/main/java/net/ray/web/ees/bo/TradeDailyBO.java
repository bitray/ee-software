package net.ray.web.ees.bo;

import java.util.Date;
import java.util.List;

import net.ray.web.ees.db.eo.TradeDailyAchievement;

public interface TradeDailyBO {
	public List<TradeDailyAchievement> getDailyTradeByDate(Date date);
	public List<TradeDailyAchievement> getDailyTradeYesterday(boolean isTrade);
	public List<TradeDailyAchievement> getDailyTradeByIdForCurrentWeek(Integer tradeId); 
}
