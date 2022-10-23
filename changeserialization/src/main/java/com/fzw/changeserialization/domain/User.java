package com.fzw.changeserialization.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor //无参构造
@AllArgsConstructor //全部参数构造
@ToString
public class User {

    private String id;
    private String name;
    private int age;

}
