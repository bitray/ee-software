package net.ray.web.ees.db.dao;

import net.ray.web.ees.db.eo.BrandInfro;

public interface BrandInfroMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_info
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_info
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int insert(BrandInfro record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_info
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int insertSelective(BrandInfro record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_info
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    BrandInfro selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_info
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKeySelective(BrandInfro record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_info
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKey(BrandInfro record);
}