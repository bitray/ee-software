package net.ray.web.ees.bo;

import java.util.List;

import net.ray.web.ees.db.eo.MallBase;

public interface MallBO {
	public MallBase getMallById(Integer id);
	public List<MallBase> getMalls(MallBase mallBase);
}
