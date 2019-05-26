package com.hcb.netty.common_protobuf_in_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.Mymessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Mymessage msg) throws Exception {
        MyDataInfo.Mymessage.DataType dataType = msg.getDataType();

        if ( dataType==MyDataInfo.Mymessage.DataType.PersonType ) {
            MyDataInfo.Person person = msg.getPerson();
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.getAddress());
        } else if ( dataType==MyDataInfo.Mymessage.DataType.DogType ) {
            MyDataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getName());
            System.out.println(dog.getAge());
        } else {
            MyDataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getName());
            System.out.println(cat.getCity());
        }


    }

}
