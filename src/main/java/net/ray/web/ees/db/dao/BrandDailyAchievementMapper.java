package net.ray.web.ees.db.dao;

import net.ray.web.ees.db.eo.BrandDailyAchievement;
import net.ray.web.ees.db.eo.BrandDailyAchievementExample;

public interface BrandDailyAchievementMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_daily_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    long countByExample(BrandDailyAchievementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_daily_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_daily_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int insert(BrandDailyAchievement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_daily_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int insertSelective(BrandDailyAchievement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_daily_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    BrandDailyAchievement selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_daily_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKeySelective(BrandDailyAchievement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_daily_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKey(BrandDailyAchievement record);
}