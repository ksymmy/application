package com.wkcheng.rpc;

import com.wkcheng.rpc.client.RPCClient;
import com.wkcheng.rpc.server.HelloService;
import com.wkcheng.rpc.server.HelloServiceImpl;
import com.wkcheng.rpc.server.Server;
import com.wkcheng.rpc.server.ServiceCenter;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/4 8:49
 * @desc https://www.cnblogs.com/codingexperience/p/5930752.html
 */
public class RPCTest {

    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }
}