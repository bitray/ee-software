package net.ray.web.ees.bo.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.BrandYearlyBO;
import net.ray.web.ees.db.dao.BrandYearAchievementMapper;
import net.ray.web.ees.db.eo.BrandYearAchievement;
@Service
public class BrandYearlyBOImpl implements BrandYearlyBO {

	@Resource
	public BrandYearAchievementMapper brandYearAchievementMapper;
	@Override
	public boolean insertBrandYearlyAchievement(BrandYearAchievement brandYearAchievement) {
		int rows = 0;
		try{
			rows = brandYearAchievementMapper.insertSelective(brandYearAchievement);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rows > 0;
	}

}
