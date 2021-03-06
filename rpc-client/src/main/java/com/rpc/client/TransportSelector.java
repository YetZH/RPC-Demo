package com.rpc.client;

import com.rpc.Peer;
import com.rpc.transport.TransportClient;

import java.util.List;

/**
 * 表示选择哪个server去连接
 */
public interface TransportSelector {
    /**
     * 初始化selector
     * @param peers 可以连接的server断电信息
     * @param count client与server建立多少个连接
     * @param calzz client实现class
     */
    void init(List<Peer> peers,int count,Class<? extends  TransportClient> calzz);
    /**
     * 选择一个transport与server做交互
     * @return
     */
    TransportClient select();

    /**
     * 释放用完的client
     * @param client
     */
    void release(TransportClient client);
    void close();
}
