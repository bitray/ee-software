package net.ray.web.ees.bo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.UserAuthorityBO;
import net.ray.web.ees.dao.MenuDAO;
import net.ray.web.ees.dao.UserAuthorityDAO;
import net.ray.web.ees.eo.Menu;
import net.ray.web.ees.eo.User;
import net.ray.web.ees.eo.UserAuthority;

@Service("userAuthorityBO")
public class UserAuthorityBOImpl implements UserAuthorityBO {
	@Resource(name = "userAuthority")
	private UserAuthorityDAO userArthorityDAO;
	@Resource(name = "menuDAO")
	private MenuDAO menuDAO;

	@Override
	public List<Menu> getMenuByUser(User user) {
		List<UserAuthority> authorityList=userArthorityDAO.getUserAuthoritiesByUser(user);
		List<Menu> allMenu=menuDAO.getAllMenus();
		List<Menu> menus=this.convertToMenu(allMenu, authorityList);
		for(Menu menu:menus){
			if(!menu.isLeaf()){
				List<Menu> children=this.filterByParentId(menus, menu.getId());
				menu.setChildren(children);
			}
			
		}
		return null;
	}
	
	private List<Menu> filterByParentId(List<Menu> menus,Integer parentId){
		List<Menu> returnList=new ArrayList<>();
		for(Menu menu:menus){
			if(menu.getParentId().equals(parentId)){
				returnList.add(menu);
			}
		}
		
		return returnList;
	}
	
	private List<Menu> convertToMenu(List<Menu> menus,List<UserAuthority> authorityList){
		List<Menu> returnList=new ArrayList<>();
		for(UserAuthority authority: authorityList){
			for(Menu menu:menus){
				if(authority.getMenuId().equals(menu.getId())){
					returnList.add(menu);
				}
			}
		}
		return returnList;
	}

}
