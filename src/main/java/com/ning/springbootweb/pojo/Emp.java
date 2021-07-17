package com.ning.springbootweb.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class Emp {
    private Integer id;
    private String lastName;
    private  String email;
    private Integer gender;
    private Dept dept;
    private Date birth;

    public Emp(Integer id, String lastName, String email, Integer gender, Dept dept) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dept = dept;
        //默认的创建日期 实现
        this.birth = new Date();
    }
}
