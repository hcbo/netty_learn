package com.hcb.netty.sixth_protobuf_in_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import javax.xml.crypto.Data;
import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Student msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        // 客户端构造 proto buf中的对象
        DataInfo.Student person = DataInfo.Student.newBuilder()
                .setName("张三").setAge(20).setAddress("北京").build();
        // 将构造好的对象发送给服务端
        ctx.channel().writeAndFlush(person);
    }
}
