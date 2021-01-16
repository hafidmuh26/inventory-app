package com.enigma.restservice.model.classmodel;


import com.enigma.restservice.entity.TypeTransaction;

public class TransactionSummary {
    private  Long id;
    private TypeTransaction type;
    private Double amount;

    public TransactionSummary(Long id,TypeTransaction type, Double amount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

    public Long getTotalTransaction() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionSummary{" +
                "type=" + type +
                ", amount=" + amount +
                '}';
    }
}
