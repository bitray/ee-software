package net.ray.web.ees.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data_query")
public class DataQueryController {
	@RequestMapping("/single_brand_query_init")
	public String singleBrandQueryInit(){
		return "single_brand_query";
	}
	
	@RequestMapping("/multiple_brand_query_init")
	public String multipleBrandQueryInit(){
		return "multiple_brand_query";
	}
}
