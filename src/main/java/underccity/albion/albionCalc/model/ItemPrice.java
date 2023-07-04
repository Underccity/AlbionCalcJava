package underccity.albion.albionCalc.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemPrice {

	private String itemName;
	private String city;
	private OrderType orderType;
	private int quality;
	private BigDecimal price;
	private int amount;
}
