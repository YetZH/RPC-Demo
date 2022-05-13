package com.rpc.client;

import com.rpc.codec.Decoder;
import com.rpc.codec.Encoder;
import com.rpc.common.utils.ReflectionUtils;

import java.lang.reflect.Proxy;
import java.security.PublicKey;

public class RpcClient {
    private  RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private  TransportSelector selector;

    public RpcClient(RpcClientConfig config) {
        this.config = config;
        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClass());
        this.selector.init(
                this.config.getServers(),
                this.config.getConnectCount(),
                this.config.getTransportClass()
        );

    }
    public  <T> T getProxy(Class<T> clazz){
        return (T)Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{clazz},
                new RemoteInvoker(clazz,encoder,decoder,selector)
        );
    }

    public RpcClient() {
        this(new RpcClientConfig());
    }
}
