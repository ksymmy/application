package com.wkcheng.pro_netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author created by wkcheng@iflytek.com at 2018/10/16 20:34
 * @desc
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {


        Bootstrap client = new Bootstrap();

        EventLoopGroup childGroup = new NioEventLoopGroup();
        client.group(childGroup);

        client.channel(NioSocketChannel.class);

        client.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                nioSocketChannel.pipeline().addLast(new SimpleClientHandler());
                nioSocketChannel.pipeline().addLast(new LengthFieldPrepender(4, false));
                nioSocketChannel.pipeline().addLast(new StringEncoder());
            }
        });


        ChannelFuture channelFuture = client.connect("localhost", 8777).sync();

        channelFuture.channel().writeAndFlush("hello 我是 netty");

        channelFuture.channel().closeFuture().sync();
        System.out.println("客户端运行结束!");
    }
}
