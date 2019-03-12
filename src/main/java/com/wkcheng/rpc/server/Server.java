package com.wkcheng.rpc.server;

import java.io.IOException;

/**
 * @author created by wkcheng@iflytek.com at 2019/3/4 8:44
 * @desc 服务中心代码实现
 */
public interface Server {
    void stop();

    void start() throws IOException;

    void register(Class serviceInterface, Class impl);

    boolean isRunning();

    int getPort();
}
