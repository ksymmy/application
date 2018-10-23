package com.wkcheng.retry;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author created by wkcheng@iflytek.com at 2018/10/11 8:31
 * @desc
 */
@Service
public class RetryService {

    @Retryable(value = {RemoteAccessException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000L, multiplier = 1))
    public void call() {
      /*  double random = Math.random();
        if (random > 0.1) {
            System.out.println(random);
            throw new RemoteAccessException("RPC调用异常");
        }*/
        throw new RemoteAccessException("RPC调用异常");
    }

    @Recover
    public void recover(RemoteAccessException e) {
        System.out.println("异常:" + e.getMessage());
    }
}
