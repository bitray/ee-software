package net.ray.web.ees.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/base_data")
public class BaseDataController {
	@RequestMapping("/project_data_init")
	public String projectDataInit(){
		return "project_data";
	}
	
	
	@RequestMapping("/brand_data_init")
	public String brandDataInit(){
		return "brand_data";
	}
	
	@RequestMapping("/floor_data_init")
	public String floorDataInit(){
		return "floor_data";
	}
	
	
	@RequestMapping("/trade_data_init")
	public String tradeDataInit(){
		return "trade_data";
	}
	
	@RequestMapping("/basic_query_init")
	public String basicQueryInit(){
		return "basic_query";
	}
	
	@RequestMapping("/user_data_init")
	public String userDataInit(){
		return "user_data";
	}
	
	@RequestMapping("/authority_data_init")
	public String authorityDataInit(){
		return "authority_data";
	}
}
