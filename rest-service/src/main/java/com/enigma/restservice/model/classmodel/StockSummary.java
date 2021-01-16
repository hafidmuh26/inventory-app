package com.enigma.restservice.model.classmodel;


public class StockSummary {

    private Long quantity;
    private String name;
    private String description;

    public StockSummary(String name, Long quantity, String description) {
        this.quantity = quantity;
        this.name = name;
        this.description = description;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
