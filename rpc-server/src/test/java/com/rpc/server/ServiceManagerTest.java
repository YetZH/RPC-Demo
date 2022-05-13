package com.rpc.server;

import com.rpc.Request;
import com.rpc.ServiceDescriptor;
import com.rpc.common.utils.ReflectionUtils;
import com.sun.corba.se.impl.orb.ParserTable;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

public class ServiceManagerTest {
    ServiceManager serviceManager ;
    @Before
    public void init(){
        serviceManager= new ServiceManager();
        TestInterface bean = new TestClass();
        serviceManager.register(TestInterface.class,bean);

    }
    @Test
    public void testRegister() {

        TestInterface bean = new TestClass();
        serviceManager.register(TestInterface.class,bean);

    }
    @Test
    public void testLookup() {
        Method method = ReflectionUtils.getPublicMethods(ParserTable.TestContactInfoListFactory.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, method);
        Request request = new Request();
        request.setService((sdp));
        ServiceInstance sis = serviceManager.lookup(request);
    }
}