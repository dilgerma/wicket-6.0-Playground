package de.effectivetrainings;

import de.effectivetrainings.domain.Food;
import de.effectivetrainings.domain.Order;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author martindilger
 *         Date: 31.10.12
 *         Time: 14:35
 */
public class DB {

    private static DB instance = new DB();

    private Map<String, Order> orders;

    private DB() {
        this.orders = Collections.synchronizedMap(new HashMap<String, Order>());
    }

    public void store(Order order) {
        this.orders.put(order.getOrderId(), order);
    }

    /*
    * do not copy that....
    * */
    public Map<Food, Integer> countOrdersByFood() {
        Map<Food, Integer> counts = new HashMap<Food, Integer>();
        Iterator<Order> it = orders.values().iterator();
        while (it.hasNext()) {
            Order order = it.next();
            if (!counts.containsKey(order.getFood())) {
                counts.put(order.getFood(), 0);
            }
            Integer count = counts.get(order.getFood());
            counts.put(order.getFood(), ++count);
        }
        return counts;
    }

    public static final DB get() {
        return instance;
    }
}
