package net.ray.web.ees.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data_analysis")
public class DataAnalysisController {
	@RequestMapping("/daily_analysis_init")
	public String dailyAnalysisInit(){
		return "daily_analysis";
	}
	
	@RequestMapping("/weekly_analysis_init")
	public String weeklyAnalysisInit(){
		return "weekly_analysis";
	}
	
	@RequestMapping("/monthly_analysis_init")
	public String monthlyAnalysisInit(){
		return "monthly_analysis";
	}
	
	@RequestMapping("/yearly_analysis_init")
	public String yearlyAnalysisInit(){
		return "yearly_analysis";
	}
}
