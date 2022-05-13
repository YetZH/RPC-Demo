package com.rpc.client;

import com.rpc.Peer;
import com.rpc.codec.Decoder;
import com.rpc.codec.Encoder;
import com.rpc.codec.JSONDecoder;
import com.rpc.codec.JSONEncoder;
import com.rpc.transport.HttpTransportClient;
import com.rpc.transport.TransportClient;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> TransportClass = HttpTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1",3000));
}
