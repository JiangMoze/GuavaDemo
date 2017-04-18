package com.maoyan.day1;

/**
 * Created by jiangdongyu on 2017/4/18.
 */
public class ExtensionClasses {
    /*
    Forwarding抽象类以简化装饰者模式的使用。


     */


    /*
    PeekingIterator
    Iterators提供一个Iterators.peekingIterator(Iterator)方法，来把Iterator包装为PeekingIterator，
    这是Iterator的子类，它能让你事先窥视[peek()]到下一次调用next()返回的元素。


    List<E> result = Lists.newArrayList();
    PeekingIterator<E> iter = Iterators.peekingIterator(source.iterator());
    while (iter.hasNext()) {
        E current = iter.next(); 取出一个元素
        while (iter.hasNext() && iter.peek().equals(current)) { 和后边的元素比较 若有相同的 重复 则抛弃
        //跳过重复的元素                                       若没有重复元素则最终存入
        iter.next();
        }
        result.add(current);
    }
     */

    /*
    AbstractIterator
    实现自己的iterator  禁止remove

     跳过空值
    public static Iterator<String> skipNulls(final Iterator<String> in) {
        return new AbstractIterator<String>() {
            protected String computeNext() {
                while (in.hasNext()) {
                    String s = in.next();
                    if (s != null) {
                    return s;
                    }
                }
            return endOfData();
            }
        };
    }
     */
}
