package com.enigma.restservice.model.classmodel;

import com.enigma.restservice.validation.annotations.MaxLength;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class StockModel {

    private Integer id;

    @NotNull(message = "{quantity.notNull}")
    private Integer quantity;

    private ItemModel item;

    private UnitModel unit;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ItemModel getItem() {
        return item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }

    public UnitModel getUnit() {
        return unit;
    }

    public void setUnit(UnitModel unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "StockModel{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", item=" + item +
                ", unit=" + unit +
                '}';
    }
}
