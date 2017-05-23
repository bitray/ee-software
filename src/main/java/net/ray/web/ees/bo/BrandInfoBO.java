package net.ray.web.ees.bo;

import java.util.List;

import net.ray.web.ees.db.eo.BrandInfo;
 
public interface BrandInfoBO {
	public List<BrandInfo> getBrandsBySelective(BrandInfo brandInfo);
}
