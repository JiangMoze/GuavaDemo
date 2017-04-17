package com.maoyan.day1;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * Created by jiangdongyu on 2017/4/17.
 * NULL语义不清晰 如hashmap中null  可能表示没有键  或者这该键的值为null
 * 性能和和速度廉价，而且对象数组中无法避免
 * Guava中采用快速失败 除非提供 特定的处理措施
 * <p>
 * 应该使用特定值来存储null键
 * 增加枚举类型表示null
 */
public class UsingAndaAvoidingNull {

    /*
        Optional.of(T)：获得一个Optional对象，其内部包含了一个非null的T数据类型实例，若T=null，则立刻报错。
     　　Optional.absent()：获得一个Optional对象，其内部包含了空值
     　　Optional.fromNullable(T)：将一个T的实例转换为Optional对象，T的实例可以不为空，
        也可以为空[Optional.fromNullable(null)，和Optional.absent()等价。
     */
    /*
    　　  1>. boolean isPresent()：如果Optional包含的T实例不为null，则返回true；若T实例为null，返回false
　　      2>. T get()：返回Optional包含的T实例，该T实例必须不为空；否则，对包含null的Optional实例调用get()会抛出一个IllegalStateException异常
　　      3>. T or(T)：若Optional实例中包含了传入的T的相同实例，返回Optional包含的该T实例，否则返回输入的T实例作为默认值
　　      4>. T orNull()：返回Optional实例中包含的非空T实例，如果Optional中包含的是空值，返回null，逆操作是fromNullable()
　　      5>. Set<T> asSet()：返回一个不可修改的Set，该Set中包含Optional实例中包含的所有非空存在的T实例，且在该Set中，每个T实例都是单态，
            如果Optional中没有非空存在的T实例，返回的将是一个空的不可修改的Set。
     */
    @Test
    public void testOptional() throws Exception {
        Optional<Integer> possible = Optional.of(6);
        Optional<Integer> absentOpt = Optional.absent();
        Optional<Integer> NullableOpt = Optional.fromNullable(null);//和absent等价
        Optional<Integer> NoNullableOpt = Optional.fromNullable(10);


        String str=null;
        Optional<String> stringOptional=Optional.fromNullable(str);
        if(!stringOptional.isPresent()){
            System.out.println("str是空的");
            //stringOptional.get();//IllegalStateException
        }

        if (possible.isPresent()) {
            System.out.println("possible isPresent:" + possible.isPresent());
            System.out.println("possible value:" + possible.get());
        }
        if (absentOpt.isPresent()) {
            System.out.println("absentOpt isPresent:" + absentOpt.isPresent());

        }
        if (NullableOpt.isPresent()) {
            System.out.println("fromNullableOpt isPresent:" + NullableOpt.isPresent());

        }
        if (NoNullableOpt.isPresent()) {
            System.out.println("NoNullableOpt isPresent:" + NoNullableOpt.isPresent());

        }
    }


}
