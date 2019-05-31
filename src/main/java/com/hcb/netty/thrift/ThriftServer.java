package com.hcb.netty.thrift;

import com.hcb.thrift.generated.PersonService;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * 这个案例应用的是thrift自带的服务端和客户端,未与netty集成.
 */
public class ThriftServer {
    public static void main(String[] args) throws TTransportException {
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);
        THsHaServer.Args arg = new THsHaServer.Args(socket)
                .minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServiceImpl> processor =
                new PersonService.Processor<>(new PersonServiceImpl());

        arg.protocolFactory(new TCompactProtocol.Factory());  // 将信息压缩的协议
        arg.transportFactory(new TFramedTransport.Factory()); // 传输协议
        arg.processorFactory(new TProcessorFactory(processor));

        TServer server = new THsHaServer(arg);   //  半同步半异步Server
        System.out.println("Thrift Server Started!");

        server.serve();// 死循环一个，且异步非阻塞
    }
}
