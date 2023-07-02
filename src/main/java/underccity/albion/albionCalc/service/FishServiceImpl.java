package underccity.albion.albionCalc.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import underccity.albion.albionCalc.dao.ItemsDao;
import underccity.albion.albionCalc.model.Craft;
import underccity.albion.albionCalc.model.FishItem;
import underccity.albion.albionCalc.model.Item;
import underccity.albion.albionCalc.model.OrderType;

@Service
public class FishServiceImpl implements FishService {

	@Autowired
	ItemsDao itemsDao;
	
	@Override
	public List<FishItem> getAllFish() throws StreamReadException, DatabindException, IOException {
		HashMap<String, Item> items = itemsDao.getDictItems();
		List<FishItem> result = new ArrayList<>();
		if(itemsDao.checkExistItemPrices("T1_FISHCHOPS_1_1") && items.containsKey("T1_FISHCHOPS_1_1")) {
			List<Craft> craftList = items.get("T1_FISHCHOPS_1_1").getCraft();
			BigDecimal fishChopPrice = itemsDao.getMaxItemPrice("T1_FISHCHOPS_1_1", OrderType.REQUEST).multiply(new BigDecimal(0.92));
			for(Craft craftItem: craftList) {
				
				FishItem fishItem = new FishItem();
				
				String itemName = craftItem.getCraftItems().get(0).getItemName();
				String description = items.get(itemName).getDescription();
				BigDecimal minPriceOffer = itemsDao.getMinItemPrice(itemName, OrderType.OFFER);
				int givenCount = craftItem.getGivenCount();
				BigDecimal priceForOne = minPriceOffer.divide(new BigDecimal(givenCount));
				
				fishItem.setGivenCount(givenCount);
				fishItem.setItemName(itemName);
				fishItem.setDescription(description);
				fishItem.setMinpriceoffer(minPriceOffer);
				fishItem.setSumFishChop(fishChopPrice.multiply(new BigDecimal(givenCount)));
				fishItem.setPriceForOne(priceForOne);
				fishItem.setProfit(fishChopPrice.subtract(priceForOne));
				
				result.add(fishItem);
			}
		}
		return result;
	}

}
