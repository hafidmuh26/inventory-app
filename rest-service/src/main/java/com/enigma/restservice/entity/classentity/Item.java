package com.enigma.restservice.entity.classentity;

import com.enigma.restservice.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "item")
@Entity
public class Item extends AbstractEntity<Integer> {

    @Column(name = "name_item")

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + getId() +
                "name='" + name + '\'' +
                '}';
    }

}
