package com.maoyan.day1;

import sun.jvm.hotspot.gc_implementation.shared.ImmutableSpace;

import java.util.Set;

/**
 * Created by jiangdongyu on 2017/4/17.
 * 不可变集合
 * Guava提供的不可变集合优点：
 * 安全 无竞态 内存利用率高 可做常量
 *
 *JDK提供的Collections.unmodifiableXXX不够好：
 * 笨重不适合所有场景
 * 不安全，返回的才是不可变的，原饮用仍然可变
 * 仍保留可变集合的开销
 *
 * Guava提供的不可变集合不接受NULL
 *
 */
public class FinalCollections {

    public void createFinalCollection(){
        Set<String> set= Immutable
    }
}
