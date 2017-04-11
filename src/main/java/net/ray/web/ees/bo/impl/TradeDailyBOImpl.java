package net.ray.web.ees.bo.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.TradeDailyBO;
import net.ray.web.ees.db.dao.TradeDailyAchievementMapper;
import net.ray.web.ees.db.eo.TradeDailyAchievement;
import net.ray.web.ees.util.DateUtil;

@Service
public class TradeDailyBOImpl implements TradeDailyBO {
	@Resource
	private TradeDailyAchievementMapper tradeDailyAchievementMapper;

	@Override
	public List<TradeDailyAchievement> getDailyTradeByDate(Date date) {
		return tradeDailyAchievementMapper.selectByDate(date);
	}

	@Override
	public List<TradeDailyAchievement> getDailyTradeYesterday(boolean isTrade) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("for_mall", isTrade);
		List<TradeDailyAchievement> achievements=tradeDailyAchievementMapper.selectByYesterday(map);
		Float salesAmount=tradeDailyAchievementMapper.countByYesterday();
		for(TradeDailyAchievement achievement:achievements){
			Float dailyAmount=achievement.getSalesAmount();
			achievement.setSalesPercentage(dailyAmount.floatValue()/salesAmount.floatValue()*100);
		}
		return achievements;
	}

	@Override
	public List<TradeDailyAchievement> getDailyTradeByIdForCurrentWeek(Integer tradeId) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("tradeId", tradeId);
		Date[] duration=DateUtil.getCurrentWeek();
		map.put("fromDate", duration[0]);
		map.put("toDate", duration[1]);
		return tradeDailyAchievementMapper.selectByDurationAndTrade(map);
	}

}
