package net.ray.web.ees.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data_enter")
public class DataEnterController {
	@RequestMapping("/daily_data_enter_init")
	public String daliyEnterInit(){
		
		return "daily_enter";
	}
	
	@RequestMapping("/monthly_data_enter_init")
	public String monthlyEnterInit(){
		return "monthly_enter";
	}
	
	@RequestMapping("/yearly_data_enter_init")
	public String yearlyEnterInit(){
		return "yearly_enter";
	}
	
	@RequestMapping("/target_data_enter_init")
	public String targetDataEnterInit(){
		return "target_data_enter";
	}
}
