package net.ray.web.ees.db.dao;

import java.util.List;

import net.ray.web.ees.db.eo.BrandInfo;

public interface BrandInfoMapper {
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
    int insert(BrandInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_info
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int insertSelective(BrandInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_info
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    BrandInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_info
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKeySelective(BrandInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table e_brand_info
     *
     * @mbg.generated Thu Nov 24 17:04:55 CST 2016
     */
    int updateByPrimaryKey(BrandInfo record);
    
    List<BrandInfo> selectBySelective(BrandInfo record);
}