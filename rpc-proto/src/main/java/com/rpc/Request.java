package com.rpc;

import lombok.Data;

/**
 * 表示RPC的一个请求
 */
@Data
//@NoArgsConstructor
public class Request {
    private  ServiceDescriptor service;
    private Object[] parmeters;
}
