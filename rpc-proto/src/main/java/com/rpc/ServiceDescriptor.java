package com.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 表示服务
 *
 * @author YET
 */
@Data  //getset方法
@AllArgsConstructor  //带参构造函数
@NoArgsConstructor  //无参构造函数
public class ServiceDescriptor {
    private String clazz;
    private String method;
    private String returnType;
    private String[] parmeterTyper;

    public static ServiceDescriptor from(Class clazz, Method method) {
        ServiceDescriptor descriptor = new ServiceDescriptor();
        descriptor.setClazz(clazz.getName());
        descriptor.setMethod(method.getName());
        descriptor.setReturnType(method.getReturnType().getName());
        Class[] parameterClasses = method.getParameterTypes();
        String[] parameterTypes = new String[parameterClasses.length];
        for (int i = 0; i < parameterClasses.length; i++) {
            parameterTypes[i] = parameterClasses[i].getName();
        }
        descriptor.setParmeterTyper(parameterTypes);
        return descriptor;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        ServiceDescriptor that = (ServiceDescriptor) o;
        return  this.toString().equals(that.toString());
    }

    @Override
    public String toString() {
        return "clazz = " + clazz
                + ",method = " + method
                +",returnType = "+ returnType
                +",parmeterTypes = "+ Arrays.toString(parmeterTyper);
    }
}
