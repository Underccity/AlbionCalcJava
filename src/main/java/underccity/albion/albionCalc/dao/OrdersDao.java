package underccity.albion.albionCalc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import underccity.albion.albionCalc.entity.Orders;

@Repository
public interface OrdersDao extends JpaRepository<Orders, Long>  {
}
