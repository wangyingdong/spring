package com.f139.netty.booter;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

public class ClientHandler extends SimpleChannelInboundHandler<String> {

    private String delimiter = "\n";

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(LocalDateTime.now()+" : "+msg);
    }




}