package com.enigma.restservice.entity.classentity;


import com.enigma.restservice.entity.AbstractEntity;
import com.enigma.restservice.model.classmodel.StockSummary;

import javax.persistence.*;

@Table(name = "stock")
@Entity
public class Stock extends AbstractEntity<Integer> {

    private Integer quantity;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Unit unit;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Item item;

    public Stock() {
    }

    public Stock(Item item, Integer quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + getId() +
                "quantity=" + quantity +
                ", unit=" + unit +
                ", item=" + item +
                '}';
    }
}
