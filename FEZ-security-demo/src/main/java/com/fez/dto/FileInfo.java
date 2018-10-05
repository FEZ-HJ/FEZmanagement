package com.fez.dto;

import lombok.Data;

/**
 * Created by H.J
 * 2018/10/5
 */
@Data
public class FileInfo {

    public FileInfo(String path){
        this.path = path;
    }

    private String path;

}
