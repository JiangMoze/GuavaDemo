package com.maoyan.day1;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangdongyu on 2017/4/17.
 * Guava新定义的集合类
 * 和JDK框架并存 并非常精准的遵循了JDK接口契约
 */
public class NewCollections {
    /**
     * MultiSet统计元素次数
     *  1没有元素顺序限制的ArrayList<E>
     *  2Map<E, Integer>，键为元素，值为计数
     *
        Multiset接口定义的接口主要有：
     　　　　add(E element) :向其中添加单个元素
     　　　　add(E element,int occurrences) : 向其中添加指定个数的元素
     　　　　count(Object element) : 返回给定参数元素的个数
     　　　　remove(E element) : 移除一个元素，其count值 会响应减少
     　　　　remove(E element,int occurrences): 移除相应个数的元素
     　　　　elementSet() : 将不同的元素放入一个Set中
     　　　　entrySet(): 类似与Map.entrySet 返回Set<Multiset.Entry>。包含的Entry支持使用getElement()和getCount()
     　　　　setCount(E element ,int count): 设定某一个元素的重复次数
     　　　　setCount(E element,int oldCount,int newCount): 将符合原有重复个数的元素修改为新的重复次数 不符合则不允许修改
     　　　　retainAll(Collection c) : 保留出现在给定集合参数的所有的元素
     　　　　removeAll(Collectionc) : 去除出现给给定集合参数的所有的元素
            multiset.size() 方法返回的是所有的元素的总和，相当于是将所有重复的个数相加。如果需要知道每个元素的个数可以使用elementSet().size()得到.
                (因而调用add(E)方法会是multiset.size()增加1).
     　     multiset.iterator() 会循环迭代每一个出现的元素，迭代的次数与multiset.size()相同。
     */
    @Test
    public void testMultsetWordCount(){
        //分解字符串
        String strWorld="wer|dfd|dd|dfd|dda|de|dr";
        String[] words=strWorld.split("\\|");
        List<String> wordList=new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }

        //装填
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);

        System.out.println(wordsMultiset.size());
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }


        //修改
        wordsMultiset.add("dd");
        wordsMultiset.add("wer",5);
        wordsMultiset.remove("dfd");
        wordsMultiset.setCount("de",5);
        wordsMultiset.count("dd");

        System.out.println(wordsMultiset.size());
        System.out.println();
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }

    }
}
