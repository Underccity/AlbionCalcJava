package underccity.albion.albionCalc.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import underccity.albion.albionCalc.model.Item;
import underccity.albion.albionCalc.model.ItemPrice;
import underccity.albion.albionCalc.model.OrderType;

@Repository
public class ItemsDaoImpl implements ItemsDao {

	private static HashMap<String, Item> items;
	private static HashMap<String, List<ItemPrice>> itemsPrices;
	ObjectMapper om = new ObjectMapper(); 
	
	static {
		itemsPrices = new HashMap<>();
		
		List<ItemPrice> itemPriceList = new ArrayList<>();
		
		ItemPrice itemPrice = new ItemPrice();
		itemPrice.setCity("Caerleon");
		itemPrice.setOrderType(OrderType.REQUEST);
		itemPrice.setPrice(new BigDecimal(182));
		itemPrice.setItemName("T1_FISHCHOPS_1_1");
		itemPrice.setAmount(10);
		itemPriceList.add(itemPrice);
		
		
		itemPrice = new ItemPrice();
		itemPrice.setCity("Caerleon");
		itemPrice.setOrderType(OrderType.OFFER);
		itemPrice.setPrice(new BigDecimal(150));
		itemPrice.setItemName("T1_FISHCHOPS_1_1");
		itemPrice.setAmount(10);
		itemPriceList.add(itemPrice);
		
		itemsPrices.put("T1_FISHCHOPS_1_1", itemPriceList);
		
		
		itemPriceList = new ArrayList<>();
		
		itemPrice = new ItemPrice();
		itemPrice.setCity("Caerleon");
		itemPrice.setOrderType(OrderType.OFFER);
		itemPrice.setPrice(new BigDecimal(100));
		itemPrice.setItemName("T1_FISH_FRESHWATER_ALL_COMMON_1_1");
		itemPrice.setAmount(10);
		itemPriceList.add(itemPrice);
		
		itemsPrices.put("T1_FISH_FRESHWATER_ALL_COMMON_1_1", itemPriceList);
		
		itemPriceList = new ArrayList<>();
		
		itemPrice = new ItemPrice();
		itemPrice.setCity("Caerleon");
		itemPrice.setOrderType(OrderType.OFFER);
		itemPrice.setPrice(new BigDecimal(1200));
		itemPrice.setItemName("T6_FISH_FRESHWATER_ALL_COMMON_1_1");
		itemPrice.setAmount(10);
		itemPriceList.add(itemPrice);
		
		itemsPrices.put("T6_FISH_FRESHWATER_ALL_COMMON_1_1", itemPriceList);
		
	}
	
	@Override
	public HashMap<String, Item> getDictItems() throws StreamReadException, DatabindException, IOException {
		if(items == null) {
			items = new HashMap<>();
			String temp = "[ 	{	\"itemName\": \"T1_FISHCHOPS_1_1\",	\"qualityLevel\": 1,	\"enchantmentLevel\": 1,	\"description\": \"Разделанная рыба\",	\"craft\": [	{	\"givenCount\": 1,	\"craftItems\": [	{	\"itemName\": \"T1_FISH_FRESHWATER_ALL_COMMON_1_1\",	\"count\": 1	}	]	},	{	\"givenCount\": 8,	\"craftItems\": [	{	\"itemName\": \"T6_FISH_FRESHWATER_ALL_COMMON_1_1\",	\"count\": 1	}	]	}	] 	}, 	{	\"itemName\": \"T1_FISH_FRESHWATER_ALL_COMMON_1_1\",	\"qualityLevel\": 1,	\"enchantmentLevel\": 1,	\"description\": \"Красноперка обыкновенная\" 	}, 	{	\"itemName\": \"T6_FISH_FRESHWATER_ALL_COMMON_1_1\",	\"qualityLevel\": 1,	\"enchantmentLevel\": 1,	\"description\": \"Яркоперый судак\" 	} ]";
			List<Item> itemList = om.readValue(temp.getBytes(), new TypeReference<List<Item>>(){});
			for(Item item : itemList) {
				String itemName = item.getItemName();// + "_" + item.getEnchantmentLevel() + "_" + item.getQualityLevel(); 
				items.put(itemName, item);
			}
		}
		return items;
	}

	@Override
	public HashMap<String, List<ItemPrice>> getItemsPrices() {
		if(itemsPrices == null) {
			itemsPrices = new HashMap<>();
		}
		return itemsPrices;
	}

	
	@Override
	public BigDecimal getMinItemPrice(String itemName, OrderType orderType) {
		BigDecimal result = null;
		if(itemsPrices != null && itemsPrices.containsKey(itemName)) {
			List<ItemPrice> priceList = itemsPrices.get(itemName);
			result = new BigDecimal(Integer.MAX_VALUE);
			for(ItemPrice itemPrice : priceList) {
				if(itemPrice.getOrderType() == orderType) {
					if(itemPrice.getPrice().compareTo(result) < 0) {
						result = itemPrice.getPrice();
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public BigDecimal getMaxItemPrice(String itemName, OrderType orderType) {
		BigDecimal result = null;
		if(itemsPrices != null && itemsPrices.containsKey(itemName)) {
			List<ItemPrice> priceList = itemsPrices.get(itemName);
			result = new BigDecimal(0);
			for(ItemPrice itemPrice : priceList) {
				if(itemPrice.getOrderType() == orderType) {
					if(itemPrice.getPrice().compareTo(result) > 0) {
						result = itemPrice.getPrice();
					}
				}
			}
		}
		return result;
	}

	@Override
	public boolean checkExistItemPrices(String itemName) {
		boolean result = false;
		if(itemsPrices != null && itemsPrices.containsKey(itemName)) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean checkExistItemPrices(String itemName, OrderType orderType) {
		boolean result = false;
		if(itemsPrices != null && itemsPrices.containsKey(itemName)) {
			List<ItemPrice> priceList = itemsPrices.get(itemName);
			for(ItemPrice itemPrice : priceList) {
				if(itemPrice.getOrderType() == orderType) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
