package net.ray.web.ees.bo;

import java.util.List;

import net.ray.web.ees.db.eo.BrandInfro;

public interface BrandInfoBO {
	public List<BrandInfro> getBrandsBySelective(BrandInfro brandInfo);
}
