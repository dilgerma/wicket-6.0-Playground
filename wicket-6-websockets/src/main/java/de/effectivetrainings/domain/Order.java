package de.effectivetrainings.domain;

import java.io.Serializable;

/**
 * @author martindilger
 *         Date: 31.10.12
 *         Time: 14:12
 */
public class Order implements Serializable {

    //some meaningless random order id
    private String orderId = String.valueOf(Math.random());
    private String name;
    private String street;
    private String zip;
    private String city;
    private Food food;

    public Order(){}

    public String getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", food=" + food +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (city != null ? !city.equals(order.city) : order.city != null) return false;
        if (food != order.food) return false;
        if (name != null ? !name.equals(order.name) : order.name != null) return false;
        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (street != null ? !street.equals(order.street) : order.street != null) return false;
        if (zip != null ? !zip.equals(order.zip) : order.zip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (food != null ? food.hashCode() : 0);
        return result;
    }
}
