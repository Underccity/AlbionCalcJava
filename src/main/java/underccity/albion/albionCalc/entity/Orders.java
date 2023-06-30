package underccity.albion.albionCalc.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="orders")
public class Orders {
	
	@Column(name="itemid")
	@Id
	private String itemId;
	
	@Column(name="qualitylevel")
	private int qualityLevel;
	@Column(name="enchantmentlevel")
	private int enchantmentLevel;
	
	@Column(name="city")
	private String city;
	
	@Column(name="maxpricerequest")
	private Long maxPricerequest;
	@Column(name="minpricerequest")
	private Long minPricerequest;

	@Column(name="maxpriceoffer")
	private Long maxPriceOffer;
	@Column(name="minpriceoffer")
	private Long minpriceoffer;
	
	
}
