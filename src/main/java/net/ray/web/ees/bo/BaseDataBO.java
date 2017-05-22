/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ray.web.ees.bo;

import java.util.List;
import net.ray.web.ees.db.eo.BaseData;
import net.ray.web.ees.db.eo.RentType;

/**
 *
 * @author tebi
 */
public interface BaseDataBO {
    public List<RentType> getRentTypesBySelective(RentType para);
    public List<BaseData> getBaseDataBySelective(BaseData baseData);
}
