package net.ray.web.ees.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data_import")
public class DataImportController {

	@RequestMapping("/daily_data_import_init")
	public String dailyDataImportInit(){
		return "daily_import";
	}
	
	@RequestMapping("/monthly_data_import_init")
	public String monthlyDataImportInit(){
		return "monthly_import";
	}
	
	
	@RequestMapping("/yearly_data_import_init")
	public String yearlyDataImportInit(){
		return "yearly_import";
	}
}
