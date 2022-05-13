package com.rpc.codec;

import junit.framework.TestCase;

public class JSONDecoderTest extends TestCase {

    public void testDecode() {
        JSONEncoder jsonEncoder = new JSONEncoder();
        TestBean Bean = new TestBean();
        Bean.setName("ZH");
        Bean.setAge(22);
        byte[] bytes = jsonEncoder.encoder(Bean);
        assertNotNull(bytes);
        System.out.println(bytes);
        JSONDecoder jsonDecoder = new JSONDecoder();
        TestBean bean2 = jsonDecoder.decode(bytes,TestBean.class);
        assertEquals(Bean.getName(),bean2.getName() );
        assertEquals(Bean.getAge(),bean2.getAge() );
        System.out.println(bean2);
    }
}