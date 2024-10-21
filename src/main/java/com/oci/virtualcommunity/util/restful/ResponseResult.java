package com.oci.virtualcommunity.util.restful;

import lombok.Data;

@Data
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;
    public ResponseResult(int a, String b, T c){
        code = a;
        message = b;
        data = c;
    }
}
