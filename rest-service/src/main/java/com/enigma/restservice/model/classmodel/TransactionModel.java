package com.enigma.restservice.model.classmodel;


import com.enigma.restservice.validation.annotations.MaxLength;
import com.enigma.restservice.validation.annotations.MinLength;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TransactionModel {

    private int id;

    @NotNull(message = "{amount.notNull}")
    private Double amount;

    @NotBlank(message = "{type.notBlank}")
    private String type;

    @MinLength(3)
    @MaxLength(50)
    @NotBlank(message = "{description.notBlank}")
    private String description;

    private LocalDateTime createdDate;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
