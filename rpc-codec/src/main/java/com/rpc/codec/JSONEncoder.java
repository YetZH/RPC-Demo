package com.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * 基于JSON的序列化实现
 */
public class JSONEncoder implements  Encoder{
    @Override
    public byte[] encoder(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
