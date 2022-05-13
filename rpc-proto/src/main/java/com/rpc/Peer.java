package com.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 表示服务
 */
@Data
@AllArgsConstructor
public class Peer {
            private String host;
            private  int port;
}
