package com.amrni.sport.shop.command;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseIdCmd implements Serializable {
    private Integer id;

    public BaseIdCmd(Integer id){
        this.id = id;
    }
}
