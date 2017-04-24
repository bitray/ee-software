package net.ray.web.ees.bo;

import net.ray.web.ees.db.eo.BrandDailyAchievement;

public interface BrandDailyBO {
	public boolean insertBrandDailyAchievement(BrandDailyAchievement brandAchievement);
	public BrandDailyAchievement validateBrandDailyData(BrandDailyAchievement brandAchievement);
}
