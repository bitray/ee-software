package net.ray.web.ees.db.dao;

import net.ray.web.ees.db.eo.MallFloor;

public interface MallFloorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_mall_floor
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_mall_floor
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int insert(MallFloor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_mall_floor
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int insertSelective(MallFloor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_mall_floor
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    MallFloor selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_mall_floor
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKeySelective(MallFloor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_mall_floor
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKey(MallFloor record);
}