package underccity.albion.albionCalc.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
public class FishItem {
	private String itemName;
	private String description;
	private BigDecimal minpriceoffer;
	private int givenCount;
	private BigDecimal sumFishChop;
	private BigDecimal priceForOne;
	private BigDecimal profit;
}
