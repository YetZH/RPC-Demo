package com.rpc.codec;

import junit.framework.TestCase;

public class JSONEncoderTest extends TestCase {

    public void testEncoder() {
        JSONEncoder jsonEncoder = new JSONEncoder();
        TestBean Bean = new TestBean();
        Bean.setName("ZH");
        Bean.setAge(22);
        byte[] bytes = jsonEncoder.encoder(Bean);
        assertNotNull(bytes);
        System.out.println(bytes);

    }
}