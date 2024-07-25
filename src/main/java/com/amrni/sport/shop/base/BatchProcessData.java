package com.amrni.sport.shop.base;

@FunctionalInterface
public interface BatchProcessData<T, R> {

    void consumer(T t, R r);
}
