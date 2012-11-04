package de.effectivetrainings;

import de.effectivetrainings.domain.Food;
import de.effectivetrainings.domain.Order;

import java.util.*;

/**
 * @author martindilger
 *         Date: 31.10.12
 *         Time: 14:35
 */
public class DB {

    private static DB instance = new DB();

    private Map<String, List<Order>> orders;

    private DB() {
        this.orders = Collections.synchronizedMap(new HashMap<String, List<Order>>());
    }

    public void store(Order order) {
        List<Order> orders = this.orders.get(order.getFood().name());
        if(orders == null){
            this.orders.put(order.getFood().name(),new ArrayList<Order>());
        }
        this.orders.get(order.getFood().name()).add(order);

    }

    /*
    * do not copy that....
    * */
    public Map<String, Object> countOrdersByFood() {
        Map<String, Object> foodCount = new HashMap<String, Object>();
        for(Map.Entry<String, List<Order>> order : this.orders.entrySet()){
            foodCount.put(order.getKey(),order.getValue().size());
        }
        return foodCount;
    }

    public static final DB get() {
        return instance;
    }
}
