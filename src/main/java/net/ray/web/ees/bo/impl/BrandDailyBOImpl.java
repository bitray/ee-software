package net.ray.web.ees.bo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.BrandDailyBO;
import net.ray.web.ees.db.dao.BrandDailyAchievementMapper;
import net.ray.web.ees.db.eo.BrandDailyAchievement;

@Service
public class BrandDailyBOImpl implements BrandDailyBO {

	@Resource
	private BrandDailyAchievementMapper brandDailyDAO;

	@Override
	public boolean insertBrandDailyAchievement(BrandDailyAchievement brandAchievement) {
		int rows = 0;
		try{
			rows = brandDailyDAO.insertSelective(brandAchievement);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rows > 0;
	}

	@Override
	public BrandDailyAchievement validateBrandDailyData(BrandDailyAchievement brandAchievement) {
		List<BrandDailyAchievement> brandDataList=brandDailyDAO.selectBySelective(brandAchievement);
		return brandDataList!=null&&!brandDataList.isEmpty()?brandDataList.get(0):null;
	}

}
