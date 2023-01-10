package com.Shiroha.coronavirus.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Supply {
    private int id;
    private String name;
    private String price;
    private String amount;
    private String illness;
}
