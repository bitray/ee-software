package net.ray.web.ees.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.ray.web.ees.bo.BrandDailyBO;
import net.ray.web.ees.bo.BrandInfoBO;
import net.ray.web.ees.bo.MallBO;
import net.ray.web.ees.db.eo.BrandDailyAchievement;
import net.ray.web.ees.db.eo.BrandInfro;
import net.ray.web.ees.db.eo.MallBase;
import net.ray.web.ees.db.eo.Person;
import net.ray.web.ees.db.eo.TradeDailyAchievement;
import net.ray.web.ees.util.CookieUtil;
import net.ray.web.ees.util.LocalCache;

@Controller
@RequestMapping("/data_enter")
public class DataEnterController {

	@Resource
	private BrandDailyBO brandDailyBO;
	@Resource
	private BrandInfoBO brandInfoBO;
	@Resource
	public MallBO mallBO;

	@RequestMapping("/daily_data_enter_init")
	public String daliyEnterInit(HttpServletRequest request) {
		Person currentUser = CookieUtil.getCurrentUser(request);
		request.setAttribute("currentUser", currentUser);
		MallBase mall = mallBO.getMallById(currentUser.getMallId());
		request.setAttribute("mall", mall);
		return "daily_enter";
	}

	@RequestMapping("/brandDailyValidate")
	@ResponseBody
	public BrandDailyAchievement validateBrandDailyData(BrandDailyAchievement brandAchievement, BrandInfro brandPara) {
		List<BrandInfro> brands = brandInfoBO.getBrandsBySelective(brandPara);
		BrandInfro brand = brands.get(0);
		BrandDailyAchievement result = null;
		if (brand != null) {
			BrandDailyAchievement params = new BrandDailyAchievement();
			params.setBrandId(brand.getId());
			params.setSalesDate(brandAchievement.getSalesDate());
			result = brandDailyBO.validateBrandDailyData(params);
		}
		return result;
	}

	@RequestMapping("/daily_data_enter_brand")
	@ResponseBody
	public String brandDailyEnter(BrandDailyAchievement brandAchievement, BrandInfro brandPara,
			HttpServletRequest request) {
		Integer brandId=brandAchievement.getBrandId();
		boolean result = false;
		if(brandId==null){
			List<BrandInfro> brands = brandInfoBO.getBrandsBySelective(brandPara);
			BrandInfro brand = brands.get(0);
			if (brand != null) {
				brandAchievement.setBrandId(brand.getId());
				Person currentUser = CookieUtil.getCurrentUser(request);
				brandAchievement.setCreatedBy(currentUser.getPersonName());
				brandAchievement.setUpdateBy(currentUser.getPersonName());
				result = brandDailyBO.insertBrandDailyAchievement(brandAchievement);

			}
		}else{
			Person currentUser = CookieUtil.getCurrentUser(request);
			brandAchievement.setCreatedBy(currentUser.getPersonName());
			brandAchievement.setUpdateBy(currentUser.getPersonName());
			result = brandDailyBO.insertBrandDailyAchievement(brandAchievement);
		}
		
		return String.valueOf(result);
	}

	@RequestMapping("/daily_data_enter_mall")
	@ResponseBody
	public String brandDailyMall(BrandDailyAchievement brandAchievement, BrandInfro brandPara,
			HttpServletRequest request) {
		boolean result = false;
		Person currentUser = CookieUtil.getCurrentUser(request);
		brandAchievement.setCreatedBy(currentUser.getPersonName());
		brandAchievement.setUpdateBy(currentUser.getPersonName());
		result = brandDailyBO.insertBrandDailyAchievement(brandAchievement);
		return String.valueOf(result);
	}

	@RequestMapping("/monthly_data_enter_init")
	public String monthlyEnterInit() {
		return "monthly_enter";
	}

	@RequestMapping("/yearly_data_enter_init")
	public String yearlyEnterInit() {
		return "yearly_enter";
	}

	@RequestMapping("/target_data_enter_init")
	public String targetDataEnterInit() {
		return "target_data_enter";
	}
}
