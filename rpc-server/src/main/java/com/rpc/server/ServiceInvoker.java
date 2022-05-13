package com.rpc.server;

import com.rpc.Request;
import com.rpc.common.utils.ReflectionUtils;

/**
 * 调用具体的服务
 */
public class ServiceInvoker {
    public  Object invoke(ServiceInstance service, Request request){
        return ReflectionUtils.invoke(service.getTarget(),service.getMethod(),request.getParmeters());
    }
}
