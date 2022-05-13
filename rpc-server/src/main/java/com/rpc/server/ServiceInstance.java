package com.rpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;

/**
 * 表示一个具体的服务
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInstance  {
    private  Object target;
    private Method method;



}
