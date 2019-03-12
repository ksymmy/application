package com.wkcheng.rpc.server;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/4 8:44
 * @desc HelloServices接口实现类
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
        return "Hi, " + name;
    }
}
