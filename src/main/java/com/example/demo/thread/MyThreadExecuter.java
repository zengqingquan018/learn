package com.example.demo.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * 描述：nj
 *
 * @author zengqingquan
 * @date 2021/1/4 10:03
 */
public class MyThreadExecuter {

    private static volatile ExecutorService executorService;

    private final ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setNameFormat("my-test-pool-%").build();

    private synchronized ExecutorService builder() {
        if (null != executorService) {
            return executorService;
        }
        executorService = new ThreadPoolExecutor(10, 1024, 60, TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(), threadFactory, new AbortPolicy());
        return executorService;
    }

}
