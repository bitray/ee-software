package net.ray.web.ees.bo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.TradeBO;
import net.ray.web.ees.db.dao.TradeTypeMapper;
import net.ray.web.ees.db.eo.TradeType;

@Service
public class TradeBOImpl implements TradeBO {
	@Resource
	private TradeTypeMapper tradeTypeMapper;
	@Override
	public List<TradeType> geTradeTypesBySelective(TradeType para) {
		return tradeTypeMapper.selectBySelective(para);
	}

    @Override
    public TradeType getTradeTypeById(Integer id) {
        return tradeTypeMapper.selectByPrimaryKey(id);
    }

}
