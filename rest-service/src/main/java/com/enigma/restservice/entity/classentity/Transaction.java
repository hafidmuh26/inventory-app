package com.enigma.restservice.entity.classentity;

import com.enigma.restservice.entity.AbstractEntity;
import com.enigma.restservice.entity.TypeTransaction;

import javax.persistence.*;

@Table(name = "transaction")
@Entity
public class Transaction extends AbstractEntity<Integer> {

    @Column
    private Double amount;

    @Column(name = "type_transaction")
    @Enumerated(EnumType.STRING)
    private TypeTransaction type;

    @Column
    private String description;

    public Transaction(Double amount, TypeTransaction type, String description) {
        this.amount = amount;
        this.type = type;
        this.description = description;
    }

    public Transaction() {
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
