package com.rpc.client;

import com.rpc.Peer;
import com.rpc.common.utils.ReflectionUtils;
import com.rpc.transport.RequestHandler;
import com.rpc.transport.TransportClient;
import com.rpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class RandomTransportSelector implements TransportSelector {
    //已经连接好的client
    private List<TransportClient> clients;

    public RandomTransportSelector() {
        this.clients = new ArrayList<>( );
    }

    @Override
    public  synchronized void init(List<Peer> peers, int count, Class<? extends TransportClient> calzz) {
        count = Math.max(count,1);
        for (Peer peer : peers) {
            for(int i = 0; i < count ; ++i){
                TransportClient client = ReflectionUtils.newInstance(calzz);
                client.connect(peer);
                clients.add(client);
            }
            log.info("connect server:{}",peer);
        }
    }

    @Override
    public synchronized TransportClient select() {
        int i = new Random().nextInt(clients.size());
        return clients.remove(i);
    }

    @Override
    public void release(TransportClient client) {
        clients.add(client);
    }

    @Override
    public synchronized void close() {
        for (TransportClient client : clients) {
            client.close();
        }
        clients.clear();
    }
}
