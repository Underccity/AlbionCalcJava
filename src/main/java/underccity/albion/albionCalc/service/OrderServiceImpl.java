package underccity.albion.albionCalc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import underccity.albion.albionCalc.dao.OrdersDao;
import underccity.albion.albionCalc.entity.Orders;

@Service
public class OrderServiceImpl implements OrderService {

	 @Autowired
	 private OrdersDao ordersDao;
	 
	 @Override
	    public List<Orders> findAll() {
	        return ordersDao.findAll();
	    }
}
