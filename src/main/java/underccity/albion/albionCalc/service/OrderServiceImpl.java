package underccity.albion.albionCalc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import underccity.albion.albionCalc.dao.ItemsDao;
import underccity.albion.albionCalc.model.Item;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	ItemsDao itemsDao;
	 
	 @Override
	    public HashMap<String, Item> getItems() {
		 
		 HashMap<String, Item> emptyMap = new HashMap();
	        try {
				return itemsDao.getDictItems();
			} catch (StreamReadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatabindException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return emptyMap;
	    }

	@Override
	public List<Item> getListItems() throws StreamReadException, DatabindException, IOException {
		return new ArrayList<Item>(itemsDao.getDictItems().values());
	}
}
