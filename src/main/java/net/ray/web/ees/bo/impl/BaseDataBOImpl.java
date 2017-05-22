/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ray.web.ees.bo.impl;

import java.util.List;
import javax.annotation.Resource;
import net.ray.web.ees.bo.BaseDataBO;
import net.ray.web.ees.db.dao.RentTypeMapper;
import net.ray.web.ees.db.eo.BaseData;
import net.ray.web.ees.db.eo.RentType;
import org.springframework.stereotype.Service;

/**
 *
 * @author tebi
 */
@Service
public class BaseDataBOImpl implements BaseDataBO{
    @Resource
    private RentTypeMapper rentTypeMapper;
    @Override
    public List<RentType> getRentTypesBySelective(RentType para) {
        return rentTypeMapper.selectBySelective(para);
    }

    @Override
    public List<BaseData> getBaseDataBySelective(BaseData baseData) {
        return rentTypeMapper.selectBaseDataBySelective(baseData);
    }
    
}
