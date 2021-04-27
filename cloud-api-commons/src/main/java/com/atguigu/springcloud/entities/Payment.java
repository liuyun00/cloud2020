package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    //测试一下git
    //再一次测试
    //又一次测试
    //再有一次进行测试
    private Long id;
    private String serial;
}
