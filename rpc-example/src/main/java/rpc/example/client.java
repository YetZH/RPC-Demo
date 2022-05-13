package rpc.example;

import com.rpc.client.RpcClient;

public class client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();

        CalcServer server = client.getProxy(CalcServer.class);
        int a = server.add(2, 3);
        int b = server.minus(10, 3);
        System.out.println(a);
        System.out.println(b);
    }
}
