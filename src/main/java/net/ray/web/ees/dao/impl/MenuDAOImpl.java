package net.ray.web.ees.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.ray.web.ees.dao.BaseDAO;
import net.ray.web.ees.dao.MenuDAO;
import net.ray.web.ees.eo.Menu;

@Repository("menuDAO")
public class MenuDAOImpl extends BaseDAO implements MenuDAO {

	@Override
	public List<Menu> getAllMenus() {
		return this.getSqlSession().selectOne("net.ray.web.ees.eo.Menu.findByParams");
	}

}
