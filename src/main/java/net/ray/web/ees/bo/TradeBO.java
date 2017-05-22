package net.ray.web.ees.bo;

import java.util.List;

import net.ray.web.ees.db.eo.TradeType;

public interface TradeBO {
	public List<TradeType> geTradeTypesBySelective(TradeType para);
        public TradeType getTradeTypeById(Integer id);
}
