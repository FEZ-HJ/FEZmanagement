package com.fez.security.browser.support;

import lombok.Data;

/**
 * Created by H.J
 * 2018/10/7
 */
@Data
public class SimpleResponse {

    public SimpleResponse(Object content){
        this.content = content;
    }

    private Object content;
}
