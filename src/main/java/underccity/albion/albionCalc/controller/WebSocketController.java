package underccity.albion.albionCalc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import underccity.albion.albionCalc.model.UpdateItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class WebSocketController {

	@Autowired
    private SimpMessagingTemplate template;
	
	@SendTo("/topic/updateItems")
	public List<UpdateItem> updateItems(List<UpdateItem> items) throws Exception {
		return items;
	}
	
	@GetMapping("/initUpdate")
	public List<UpdateItem> initUpdate() {
		List<UpdateItem> items = new ArrayList<>();
		UpdateItem item = new UpdateItem();
		item.setItemId("T1_FISHCHOPS");
		item.setValue(new BigDecimal(1000));
		items.add(item);
		
		template.convertAndSend("/topic/updateItems", items);
		
		return items;
	}

}
