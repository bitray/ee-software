package net.ray.web.ees.db.dao;

import net.ray.web.ees.db.eo.TradeMonthlyAchievement;

public interface TradeMonthlyAchievementMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_trade_monthly_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_trade_monthly_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int insert(TradeMonthlyAchievement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_trade_monthly_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int insertSelective(TradeMonthlyAchievement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_trade_monthly_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    TradeMonthlyAchievement selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_trade_monthly_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKeySelective(TradeMonthlyAchievement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_trade_monthly_achievement
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKey(TradeMonthlyAchievement record);
}