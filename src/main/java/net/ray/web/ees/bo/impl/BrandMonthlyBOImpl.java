package net.ray.web.ees.bo.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.BrandMonthlyBO;
import net.ray.web.ees.db.dao.BrandMonthlyAchievementMapper;
import net.ray.web.ees.db.eo.BrandMonthlyAchievement;
@Service
public class BrandMonthlyBOImpl implements BrandMonthlyBO {

	@Resource
	public BrandMonthlyAchievementMapper brandMonthlyMapper;
	
	@Override
	public boolean insertBrandMonthlyAchievement(BrandMonthlyAchievement achievement) {
		int rows = 0;
		try{
			rows = brandMonthlyMapper.insertSelective(achievement);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rows > 0;
	}

}
