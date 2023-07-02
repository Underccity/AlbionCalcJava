package underccity.albion.albionCalc.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import underccity.albion.albionCalc.model.FishItem;

public interface FishService {
	
	public List<FishItem> getAllFish() throws StreamReadException, DatabindException, IOException; 
}
