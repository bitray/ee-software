package net.ray.web.ees.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.ray.web.ees.bo.BaseDataBO;
import net.ray.web.ees.bo.BrandInfoBO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ray.web.ees.bo.FloorBO;
import net.ray.web.ees.bo.MallBO;
import net.ray.web.ees.bo.TradeBO;
import net.ray.web.ees.db.eo.BaseData;
import net.ray.web.ees.db.eo.BrandInfo;
import net.ray.web.ees.db.eo.Floors;
import net.ray.web.ees.db.eo.MallBase;
import net.ray.web.ees.db.eo.RentType;
import net.ray.web.ees.db.eo.TradeType;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/data_query")
public class DataQueryController {

    @Resource(name = "floorBO")
    private FloorBO floorBO;
    @Resource
    public MallBO mallBO;
    @Resource
    private TradeBO tradeBO;
    @Resource
    private BrandInfoBO brandInfoBO;
    @Resource
    private BaseDataBO baseDataBO;
    
    @RequestMapping("/single_brand_query_init")
    public String singleBrandQueryInit() {
        return "single_brand_query";
    }

    @RequestMapping("/multiple_brand_query_init")
    public String multipleBrandQueryInit() {
        return "multiple_brand_query";
    }

    @RequestMapping("/basic_query_init")
    public String basicQueryInit(HttpServletRequest request) {
        MallBase para = new MallBase();
        para.setIsAlive(Boolean.TRUE);
        List<MallBase> malls = mallBO.getMalls(para);
        if (malls != null) {
            request.setAttribute("mall", malls.get(0));
        }

        List<Floors> floors = floorBO.getFloors();
        request.setAttribute("floors", floors);

        TradeType trade = new TradeType();
        trade.setTradeLevel(0);
        trade.setIsAlive(Boolean.TRUE);
        List<TradeType> rootTades = tradeBO.geTradeTypesBySelective(trade);
        trade.setTradeLevel(1);
        List<TradeType> leve1Trades = tradeBO.geTradeTypesBySelective(trade);
        trade.setTradeLevel(2);
        List<TradeType> leve2Trades = tradeBO.geTradeTypesBySelective(trade);
        request.setAttribute("rootTades", rootTades);
        request.setAttribute("leve1Trades", leve1Trades);
        request.setAttribute("leve2Trades", leve2Trades);
        
        RentType rentPara=new RentType();
        rentPara.setIsAlive(Boolean.TRUE);
        List<RentType> rentTypes=baseDataBO.getRentTypesBySelective(rentPara);
        request.setAttribute("rentTypes", rentTypes);
        
        BaseData baseData=new BaseData();
        baseData.setDataType(2);
        List<BaseData> operTypes=baseDataBO.getBaseDataBySelective(baseData);
        request.setAttribute("operTypes", operTypes);
        baseData.setDataType(3);
        List<BaseData> leaseTypes=baseDataBO.getBaseDataBySelective(baseData);
        request.setAttribute("leaseTypes", leaseTypes);
        baseData.setDataType(1);
        List<BaseData> operStates=baseDataBO.getBaseDataBySelective(baseData);
        request.setAttribute("operStates", operStates);
        return "basic_query";
    }
    
    @RequestMapping("/getBrandInfoByName")
    @ResponseBody
    public BrandInfo getBrandInfroByName(Integer brandId,String brandName){
        BrandInfo brandInfo=new BrandInfo();
        brandInfo.setId(brandId);
        brandInfo.setBrandName(brandName);
        List<BrandInfo> brands=brandInfoBO.getBrandsBySelective(brandInfo);
        BrandInfo result=null;
        if(brands!=null){
            result=brands.get(0);
            TradeType rootTradeType=tradeBO.getTradeTypeById(result.getBrandIdRoot());
            TradeType tradeType1=tradeBO.getTradeTypeById(result.getBrandIdRoot());
            TradeType tradeType2=tradeBO.getTradeTypeById(result.getBrandIdRoot());
            result.setBrandIdRootStr(rootTradeType.getTradeName());
            result.setBrandIdLevel1Str(tradeType1.getTradeName());
            result.setBrandIdLevel2Str(tradeType2.getTradeName());
        }
        return result;
    }
}
