package net.ray.web.ees.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.ray.web.ees.bo.BrandInfoBO;
import net.ray.web.ees.bo.FloorBO;
import net.ray.web.ees.bo.PersonBO;
import net.ray.web.ees.db.eo.BrandInfro;
import net.ray.web.ees.db.eo.Floors;
import net.ray.web.ees.db.eo.Person;

@Controller
@RequestMapping("/base_data")
public class BaseDataController {
	
	@Resource(name="floorBO")
	private FloorBO floorBO;
	@Resource(name="personBO")
	public PersonBO personBO;
	@Resource
	public BrandInfoBO brandBO;
	
	@RequestMapping("/project_data_init")
	public String projectDataInit(){
		return "project_data";
	}
	
	
	@RequestMapping("/brand_data_init")
	public String brandDataInit(){
		return "brand_data";
	}
	
	@RequestMapping("/brand_data_List")
	@ResponseBody
	public List<BrandInfro> brandDataList(){
		BrandInfro para=new BrandInfro();
		para.setIsAlive(true);
		List<BrandInfro> brands=brandBO.getBrandsBySelective(para);
		return brands;
	}
	
	@RequestMapping("/floor_data_init")
	public String floorDataInit(HttpServletRequest request){
		List<Floors> floors=floorBO.getFloors();
		request.setAttribute("list", floors);
		return "floor_data";
	}
	
	@RequestMapping("/floor_data_insert")
	@ResponseBody
	public boolean floorDataInsert(String floorNum){
		Date now=new Date();
		Floors floor=new Floors();
		floor.setFloorNumber(floorNum);
		floor.setCreatedBy("admin");
		floor.setCreationDate(now);
		floor.setIsAlive(Boolean.TRUE);
		floor.setUpdateDate(now);
		floor.setUpdatedBy("admin");
		boolean result=floorBO.insertFloor(floor);
		return result;
	}
	
	@RequestMapping("/floor_data_update")
	@ResponseBody
	public boolean floorDataUpdate(Integer floorId,String floorNum){
		Date now=new Date();
		Floors floor=new Floors();
		floor.setId(floorId);
		floor.setFloorNumber(floorNum);
		floor.setIsAlive(Boolean.TRUE);
		floor.setUpdateDate(now);
		floor.setUpdatedBy("admin");
		boolean result=floorBO.updateFloor(floor);
		return result;
	}
	
	@RequestMapping("/floor_data_delete")
	@ResponseBody
	public boolean floorDataDelete(Integer floorId){
		boolean result=floorBO.deleteFloor(floorId);
		return result;
	}
	
	@RequestMapping("/trade_data_init")
	public String tradeDataInit(){
		return "trade_data";
	}
	
	@RequestMapping("/user_data_init")
	public String userDataInit(HttpServletRequest request){
		List<Person> users=personBO.getUsers();
		request.setAttribute("list", users);
		return "user_data";
	}
	
	@RequestMapping("/user_data_insert")
	@ResponseBody
	public boolean userDataInsert(Person person){
		person.setCreatedBy("admin");
		person.setUpdatedBy("admin");
		person.setMacAddress("2010");
		boolean result=personBO.insertUser(person);
		return result;
	}
	
	@RequestMapping("/user_data_update")
	@ResponseBody
	public boolean userDataUpdate(Person person){
		boolean result=personBO.updateUser(person);
		return result;
	}
	
	@RequestMapping("/user_data_delete")
	@ResponseBody
	public boolean userDatadelete(Integer userId){
		boolean result=personBO.deleteUserById(userId);
		return result;
	}
	
	@RequestMapping("/authority_data_init")
	public String authorityDataInit(){
		return "authority_data";
	}
}
