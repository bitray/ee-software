package net.ray.web.ees.db.dao;

import net.ray.web.ees.db.eo.Floors;

public interface FloorsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_floors
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_floors
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int insert(Floors record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_floors
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int insertSelective(Floors record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_floors
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    Floors selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_floors
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKeySelective(Floors record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_floors
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKey(Floors record);
}