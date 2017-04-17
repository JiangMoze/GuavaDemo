package com.maoyan.day1;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by jiangdongyu on 2017/4/17.
 *  不可变集合学习笔记：
 *
 * Guava提供的不可变集合优点：
 *  安全 无竞态 内存利用率高 可做常量
 *
 * JDK提供的Collections.unmodifiableXXX不够好：
 *  1笨重不适合所有场景
 *  2不安全，返回的才是不可变的，原饮用仍然可变
 *  3仍保留可变集合的开销
 *
 * Guava提供的不可变集合不接受NULL
 */
public class FinalCollections {

    /**
     * 几种不可变集合的创建方式
     */
    @Test
    public void createFinalCollection() {
        //直接创建
        ImmutableSet<String> COLOR_NAMES = ImmutableSet.of("red", "blue", "yellow");

        //装饰
        Set<String> set = new HashSet<String>();
        set.add("one");
        set.add("two");
        ImmutableSet<String> NUM_NAMES = ImmutableSet.copyOf(set);

        //build
        final ImmutableSet<String> CONTRY_NAMES = ImmutableSet.<String>builder()
                .add("China")
                .add("UK")
                .add("Japan")
                .build();

        //创建时排序
        ImmutableSortedSet<String> NUMBERS = ImmutableSortedSet.of("2", "1", "3");
        Iterator iterator=NUMBERS.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());//1 2 3
        }


        //COLOR_NAMES.remove("red");异常

    }

    /**
     * 关于asList
     * 所有不可变集合都有一个asList()方法提供ImmutableList视图，来帮助你用列表形式方便地读取集合元素。
     * 例如，你可以使用sortedSet.asList().get(k)从ImmutableSortedSet中读取第k个最小元素。
     * 一般平均性能较好   比如底层集合支持的情况下，它总是使用高效的contains方法。（为什么contains是高效的？？？）
     *
     *
     * 安全的情况下避免拷贝导致的线性时间复杂度减少性能开销：
     *  1常量时间内使用底层数据结构   ImmutableSet.copyOf(ImmutableList)就必须线性时间内拷贝
     *  2不会造成内存泄漏  很大的不可变集合  ImmutableList<String>hugeList
     *                                  ImmutableList.copyOf(hugeList.subList(0, 10))就会显式地拷贝
     *  3不改变语意   ImmutableSet.copyOf(myImmutableSortedSet)会显式地拷贝，因为和基于比较器的ImmutableSortedSet相比，
     *              ImmutableSet对hashCode()和equals有不同语义。
     */
    @Test
    public void immuCollAsList(){
        ImmutableSet<String> COLOR_NAMES = ImmutableSet.of("red", "blue", "yellow");
        ImmutableList<String> COPY_COLOR_NAMES=ImmutableList.copyOf(COLOR_NAMES);//直接调用COLOR_NAMES.asList()常量时间复杂度



    }
}
