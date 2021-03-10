package com.wkcheng.pro_netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author created by wkcheng@iflytek.com at 2018/10/16 20:21
 * @desc
 */
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap server = new ServerBootstrap();

        EventLoopGroup parentGroup = new NioEventLoopGroup();
        EventLoopGroup childGroup = new NioEventLoopGroup();

        server.group(parentGroup, childGroup);

        server.channel(NioServerSocketChannel.class);

        server.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, -1, 4));
                socketChannel.pipeline().addLast(new SimpleServerHandler());
                socketChannel.pipeline().addLast(new LengthFieldPrepender(4, false));
                socketChannel.pipeline().addLast(new StringEncoder());
            }
        });

        ChannelFuture channelFuture = server.bind(8777).sync();
        channelFuture.channel().closeFuture().sync();

        System.out.println("关闭了");
    }
}
