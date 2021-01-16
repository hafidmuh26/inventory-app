package com.enigma.restservice.model.classmodel;


import com.enigma.restservice.validation.annotations.MaxLength;
import com.enigma.restservice.validation.annotations.MinLength;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UnitModel {

    private Integer id;

    @MaxLength(20)
   @NotBlank(message = "{name.notBlank}")
    private String name;

    @MinLength(3)
    @MaxLength(30)
    @NotBlank(message = "{description.notBlank}")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UnitModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
