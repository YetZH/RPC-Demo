package com.rpc.server;

import com.rpc.common.utils.ReflectionUtils;
import com.rpc.Request;
import com.rpc.ServiceDescriptor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
/**
 * 管理RPC暴露的方法
 */
public class ServiceManager {
    private Map<ServiceDescriptor,ServiceInstance> services;

    public  ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }
    public <T> void register(Class<T> intefaceClass,T bean){
        Method[] methods = ReflectionUtils.getPublicMethods(intefaceClass);
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean,method);
            ServiceDescriptor sdp = ServiceDescriptor.from(intefaceClass, method);

            services.put(sdp,sis);
            log.info("register service: {} {}",sdp.getClazz(),sdp.getMethod());
        }
    }

    public ServiceInstance lookup(Request request){
        ServiceDescriptor sdp = request.getService();
        return services.get(sdp);
    }
}

