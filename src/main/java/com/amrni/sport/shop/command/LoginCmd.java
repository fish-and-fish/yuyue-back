package com.amrni.sport.shop.command;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginCmd implements Serializable {

    private String code;

}
