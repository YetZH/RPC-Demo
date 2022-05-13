package com.rpc.server;

import com.rpc.codec.Decoder;
import com.rpc.codec.Encoder;
import com.rpc.codec.JSONDecoder;
import com.rpc.codec.JSONEncoder;
import com.rpc.transport.HttpTransportServer;
import com.rpc.transport.TransportServer;
import lombok.Data;

/**
 * server 配置
 */
@Data
public class RpcServerConfig {
    private  Class<? extends TransportServer> transportClass = HttpTransportServer.class;
    private  Class<? extends Encoder> EncoderClass = JSONEncoder.class;
    private  Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private  int port = 3000;
}
