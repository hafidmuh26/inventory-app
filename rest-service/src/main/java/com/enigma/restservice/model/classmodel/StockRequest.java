package com.enigma.restservice.model.classmodel;


import javax.validation.constraints.NotNull;

public class StockRequest {

    @NotNull(message = "{quantity.notNull}")
    private Integer quantity;

    @NotNull(message = "Item cannot blank")
    private Integer itemId;

    @NotNull(message = "Unit cannot blank")
    private Integer unitId;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    @Override
    public String toString() {
        return "StockRequest{" +
                "quantity=" + quantity +
                ", itemId=" + itemId +
                ", unitId=" + unitId +
                '}';
    }
}
