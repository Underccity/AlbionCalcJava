package underccity.albion.albionCalc.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import underccity.albion.albionCalc.model.Item;
import underccity.albion.albionCalc.model.ItemPrice;
import underccity.albion.albionCalc.model.OrderType;

public interface ItemsDao {
	
	public HashMap<String, Item> getDictItems() throws StreamReadException, DatabindException, IOException;
	public HashMap<String, List<ItemPrice>> getItemsPrices();
	public BigDecimal getMinItemPrice(String itemName, OrderType orderType);
	public BigDecimal getMaxItemPrice(String itemName, OrderType orderType);
	public boolean checkExistItemPrices(String itemName);
	public boolean checkExistItemPrices(String itemName, OrderType orderType);
	
}
