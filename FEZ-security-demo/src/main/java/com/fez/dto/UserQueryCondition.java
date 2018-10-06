package com.fez.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by H.J
 * 2018/10/1
 */
@Data
public class UserQueryCondition {

    private String username;

    @ApiModelProperty(value = "用户年龄起始值")
    private int age;

    @ApiModelProperty(value = "用户年龄终止值")
    private int ageTo;

}
