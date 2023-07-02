package underccity.albion.albionCalc.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Craft {

    private int givenCount;
    private ArrayList<CraftItem> craftItems;
}
