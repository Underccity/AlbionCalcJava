package underccity.albion.albionCalc.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Item {
	
	private String itemName;
	private String description;
	private int qualityLevel;
	private int enchantmentLevel;
   
    private ArrayList<Craft> craft;
}
