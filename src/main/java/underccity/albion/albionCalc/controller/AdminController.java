package underccity.albion.albionCalc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import underccity.albion.albionCalc.model.Item;
import underccity.albion.albionCalc.service.OrderService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/list")
	public String getOrders(Model theModel) throws StreamReadException, DatabindException, IOException{
//		List<Item> itemList = orderService.getListItems();
//		theModel.addAttribute("itemList", itemList);
		return "admin/itemList";
		
	}
}
