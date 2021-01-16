package com.enigma.restservice.model.classmodel;

import com.enigma.restservice.validation.annotations.MaxLength;
import com.enigma.restservice.validation.annotations.MinLength;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemModel {

    private Integer id;

    @MinLength(3)
    @MaxLength(30)
    @NotBlank(message = "{name.notBlank}")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
