package underccity.albion.albionCalc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import underccity.albion.albionCalc.service.OrderService;

@SpringBootTest
class AlbionCalcApplicationTests {

	@Autowired
	private OrderService orderService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<underccity.albion.albionCalc.entity.Orders> order = orderService.findAll();

		System.out.print(order);

    }

}
