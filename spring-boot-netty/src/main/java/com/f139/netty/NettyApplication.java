package com.f139.netty;

import com.f139.netty.booter.NettyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;


@SpringBootApplication
public class NettyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class, args);
    }

    @Value("${n.port}")
    private int port;

    @Value("${n.url}")
    private String url;

    @Autowired
    private NettyServer socketServer;

    @Override
    public void run(String... strings) {
        InetSocketAddress address = new InetSocketAddress(url, port);
        socketServer.run(address);
    }
}
