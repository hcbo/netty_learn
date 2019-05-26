package com.hcb.netty.common_protobuf_in_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Mymessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Mymessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 随机生成 0、1、2
        int randomInt = new Random().nextInt(3);
        MyDataInfo.Mymessage Mymessage = null;
        // 如果
        if ( 0==randomInt ){
            Mymessage = MyDataInfo.Mymessage.newBuilder()
                    .setDataType(MyDataInfo.Mymessage.DataType.PersonType)
                    .setPerson(MyDataInfo.Person.newBuilder()
                            .setName("张三").setAge(20).setAddress("北京").build())
                    .build();
        } else if ( 1==randomInt ) {
            Mymessage = MyDataInfo.Mymessage.newBuilder()
                    .setDataType(MyDataInfo.Mymessage.DataType.DogType)
                    .setDog(MyDataInfo.Dog.newBuilder()
                            .setName("张三的狗").setAge(2).build())
                    .build();
        } else {
            Mymessage = MyDataInfo.Mymessage.newBuilder()
                    .setDataType(MyDataInfo.Mymessage.DataType.CatType)
                    .setCat(MyDataInfo.Cat.newBuilder()
                            .setName("张三的猫").setCity("北京").build())
                    .build();
        }

        ctx.channel().writeAndFlush(Mymessage);


    }
}
