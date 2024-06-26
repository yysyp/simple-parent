package com.example.news.util.opslabJutil.functions;

/**
 * 定义一些处理接口，便于优雅的处理一些数据,实现的方法不返回数据
 */
public interface ObjectHandler<T> {

    /**
     * 实现自定义处理方法
     * @param t
     */
    void handler(T t);


}
