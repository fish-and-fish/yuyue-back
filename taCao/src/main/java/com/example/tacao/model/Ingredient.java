package com.example.tacao.model;

import java.io.Serializable;

/**
 * (Ingredient)实体类
 *
 * @author makejava
 * @since 2022-08-19 14:50:53
 */
public class Ingredient implements Serializable {
    private static final long serialVersionUID = -29079379989872588L;
    
    private Integer id;
    
    private String name;
    
    private String type;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

