package net.ray.web.ees.bo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.MallBO;
import net.ray.web.ees.db.dao.MallBaseMapper;
import net.ray.web.ees.db.eo.MallBase;

@Service
public class MallBOImpl implements MallBO {
	@Resource
	MallBaseMapper mallBaseMapper;
	@Override
	public MallBase getMallById(Integer id) {
		return mallBaseMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<MallBase> getMalls(MallBase mallBase) {
		return mallBaseMapper.selectBySelective(mallBase);
	}

}
