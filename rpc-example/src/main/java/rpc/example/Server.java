package rpc.example;

import com.rpc.server.RpcServer;
import com.rpc.server.RpcServerConfig;
import com.rpc.server.ServiceManager;

public class Server {
    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer(new RpcServerConfig());
       rpcServer.register(CalcServer.class, new CalcServiceImpl());
       rpcServer.start();
    }
}
