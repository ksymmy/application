package com.wkcheng.pro_netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @author created by wkcheng@iflytek.com at 2018/10/16 20:45
 * @desc
 */
public class SimpleClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        if (msg instanceof ByteBuf) {
            System.out.println("客户端接收消息" + ((ByteBuf) msg).toString(Charset.defaultCharset()));
        }
        ctx.channel().close();
    }
}
