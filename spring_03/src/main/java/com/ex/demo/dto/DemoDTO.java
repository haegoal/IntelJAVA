package com.ex.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class DemoDTO {
    private String param1;
    private String param2;

//    public void setParam1(String param1) {
//        this.param1 = param1;
//    }
//
//    public void setParam2(String param2) {
//        this.param2 = param2;
//    }
//
//    @Override
//    public String toString() {
//        return "DemoDTO{" +
//                "param1='" + param1 + '\'' +
//                ", param2='" + param2 + '\'' +
//                '}';
//    }
}
