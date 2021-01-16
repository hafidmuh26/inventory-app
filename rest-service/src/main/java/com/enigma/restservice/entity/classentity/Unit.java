package com.enigma.restservice.entity.classentity;

import com.enigma.restservice.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "unit")
@Entity
public class Unit extends AbstractEntity<Integer> {

    @Column(name = "name_unit")
    private String name;

    @Column
    private String description;

    public Unit() {
    }

    public Unit(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                '}';
    }

}
