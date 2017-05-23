package net.ray.web.ees.bo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.BrandInfoBO;
import net.ray.web.ees.db.eo.BrandInfo;
import net.ray.web.ees.db.dao.BrandInfoMapper;
@Service
public class BrandInfoBOImpl implements BrandInfoBO {
	@Resource
	private BrandInfoMapper brandInfroMapper;
	
	@Override
	public List<BrandInfo> getBrandsBySelective(BrandInfo brandInfo) {
		return brandInfroMapper.selectBySelective(brandInfo);
	}

}
