package org.hc.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String,CartItem> items=new HashMap<>();
    private double totalmoney;
    public Cart() {
    }
    public Cart(double totalmoney) {
        this.totalmoney = totalmoney;
    }
    public Map<String, CartItem> getItems() {
        return items;
    }
    public void setItems(Map<String, CartItem> items) {
        this.items = items;
    }
    public double getTotalmoney() {
        double sum=0;
        for (CartItem car:
                items.values()) {
            sum+=car.getBookinfo().getBookPrice()*car.getNum();
        }
        this.totalmoney=sum;
        return totalmoney;
    }
    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }
    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                ", totalmoney=" + totalmoney +
                '}';
    }
}
