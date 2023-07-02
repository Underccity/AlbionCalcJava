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

import underccity.albion.albionCalc.model.FishItem;
import underccity.albion.albionCalc.service.FishService;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private FishService fishService;
	
	@GetMapping("/list")
	public String getAllList(Model theModel) throws StreamReadException, DatabindException, IOException{
		
		List<FishItem> fishList = fishService.getAllFish();
		
		theModel.addAttribute("fishChopPrice", fishList);
		theModel.addAttribute("items", fishList);
		return "main/main";
	}
	

	
}
