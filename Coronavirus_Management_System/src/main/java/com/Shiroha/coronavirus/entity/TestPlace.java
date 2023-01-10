package com.Shiroha.coronavirus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class TestPlace {
    private int id;
    private String name;
    private String place;
    private String phone;
    private String time;
}
