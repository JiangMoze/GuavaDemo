package com.maoyan.day1;

import com.google.common.collect.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jiangdongyu on 2017/4/17.
 * Guava新定义的集合类
 * 和JDK框架并存 并非常精准的遵循了JDK接口契约
 */
public class NewCollections {
    /**
     * MultiSet统计元素次数
     * 1没有元素顺序限制的ArrayList<E>
     * 2Map<E, Integer>，键为元素，值为计数
     * <p>
     * Multiset接口定义的接口主要有：
     * 　　　　add(E element) :向其中添加单个元素
     * 　　　　add(E element,int occurrences) : 向其中添加指定个数的元素
     * 　　　　count(Object element) : 返回给定参数元素的个数
     * 　　　　remove(E element) : 移除一个元素，其count值 会响应减少
     * 　　　　remove(E element,int occurrences): 移除相应个数的元素
     * 　　　　elementSet() : 将不同的元素放入一个Set中
     * 　　　　entrySet(): 类似与Map.entrySet 返回Set<Multiset.Entry>。包含的Entry支持使用getElement()和getCount()
     * 　　　　setCount(E element ,int count): 设定某一个元素的重复次数
     * 　　　　setCount(E element,int oldCount,int newCount): 将符合原有重复个数的元素修改为新的重复次数 不符合则不允许修改
     * 　　　　retainAll(Collection c) : 保留出现在给定集合参数的所有的元素
     * 　　　　removeAll(Collectionc) : 去除出现给给定集合参数的所有的元素
     * multiset.size() 方法返回的是所有的元素的总和，相当于是将所有重复的个数相加。如果需要知道每个元素的个数可以使用elementSet().size()得到.
     * (因而调用add(E)方法会是multiset.size()增加1).
     * 　     multiset.iterator() 会循环迭代每一个出现的元素，迭代的次数与multiset.size()相同。
     */
    @Test
    public void testMultsetWordCount() {
        //分解字符串
        String strWorld = "wer|dfd|dd|dfd|dda|de|dr";
        String[] words = strWorld.split("\\|");
        List<String> wordList = new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }

        //装填
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);

        System.out.println(wordsMultiset.size());
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }


        //修改
        wordsMultiset.add("dd");
        wordsMultiset.add("wer", 5);
        wordsMultiset.remove("dfd");
        wordsMultiset.setCount("de", 5);
        wordsMultiset.count("dd");

        System.out.println(wordsMultiset.size());
        System.out.println();
        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + " count：" + wordsMultiset.count(key));
        }

    }


    /*
        Multimap是把键映射到任意多个值的一般方式。
        不会有任何键映射到空集合：一个键要么至少到一个值，要么根本就不在Multimap中。
     */
    @Test
    public void MultMap() {
        Multimap<String, String> myMultimap = ArrayListMultimap.create();

        // 添加键值对
        myMultimap.put("Fruits", "Bannana");
        //给Fruits元素添加另一个元素
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Vegetables", "Carrot");

        // 获得multimap的size
        int size = myMultimap.size();
        System.out.println(size);  // 4

        // 获得Fruits对应的所有的值

        Iterator<String> fruits = myMultimap.get("Fruits").iterator();
        while (fruits.hasNext()) {
            System.out.print(fruits.next());
        }
//        System.out.println(fruits); // [Bannana, Apple, Pear]

//        Collection<string> vegetables = myMultimap.get("Vegetables");
//        System.out.println(vegetables); // [Carrot]

        //遍历Mutlimap
        for (String value : myMultimap.values()) {
            System.out.println(value);
        }

        // Removing a single value
        myMultimap.remove("Fruits", "Pear");
        System.out.println(myMultimap.get("Fruits")); // [Bannana, Pear]

        // Remove all values for a key
        myMultimap.removeAll("Fruits");
        System.out.println(myMultimap.get("Fruits")); // [] (Empty Collection!)
    }

    /*
    Multimap的视图
    asMap为Multimap<K, V>提供Map<K,Collection<V>>形式的视图。
    entries用Collection<Map.Entry<K, V>>返回Multimap中所有”键-单个值映射”——包括重复键
    keySet用Set表示Multimap中所有不同的键。
    keys用Multiset表示Multimap中的所有键，每个键重复出现的次数等于它映射的值的个数。
    values()用一个”扁平”的Collection<V>包含Multimap中的所有值。


    实现              	键行为类似	      值行为类似
ArrayListMultimap	    HashMap	        ArrayList
HashMultimap	        HashMap	        HashSet
LinkedListMultimap*	    LinkedHashMap*	LinkedList*
LinkedHashMultimap**	LinkedHashMap	LinkedHashMap
TreeMultimap	        TreeMap	        TreeSet
ImmutableListMultimap	ImmutableMap	ImmutableList
ImmutableSetMultimap	ImmutableMap	ImmutableSet
除了两个不可变形式的实现，其他所有实现都支持null键和null值


     */

    /*
    BiMap
    BiMap<K, V>是特殊的Map：
    可以实现键值对的双向映射
    可以用 inverse()反转BiMap<K, V>的键值映射
    保证值是唯一的，因此 values()返回Set而不是普通的Collection
    键–值实现	        值–键实现	        对应的BiMap实现
    HashMap	        HashMap	        HashBiMap
    ImmutableMap	ImmutableMap	ImmutableBiMap
    EnumMap	        EnumMap	        EnumBiMap
    EnumMap	        HashMap	        EnumHashBiMap
     */


    /*
    Table  行        列       值
    Table<Vertex, Vertex, Double> weightedGraph = HashBasedTable.create();
    weightedGraph.put(v1, v2, 4);
    weightedGraph.put(v1, v3, 20);
    weightedGraph.put(v2, v3, 5);

    weightedGraph.row(v1); // returns a Map mapping v2 to 4, v3 to 20
    weightedGraph.column(v3); // returns a Map mapping v1 to 20, v2 to 5


    rowMap()：用Map<R, Map<C, V>>表现Table<R, C, V>。返回当前行
     rowKeySet()返回”行”的集合Set<R>。
     row(r) ：用Map<C, V>返回给定”行”的所有列，对这个map进行的写操作也将写入Table中。
    类似的列访问方法：columnMap()、columnKeySet()、column(c)。（基于列的访问会比基于的行访问稍微低效点）
    cellSet()：用元素类型为Table.Cell<R, C, V>的

    Table有如下几种实现：

HashBasedTable：本质上用HashMap<R, HashMap<C, V>>实现；
TreeBasedTable：本质上用TreeMap<R, TreeMap<C,V>>实现；
ImmutableTable：本质上用ImmutableMap<R, ImmutableMap<C, V>>实现；注：ImmutableTable对稀疏或密集的数据集都有优化。
ArrayTable：要求在构造时就指定行和列的大小，本质上由一个二维数组实现，以提升访问速度和密集Table的内存利用率。
ArrayTable与其他Table的工作原理有点不同，请参见Javadoc了解详情。
     */
    @Test
    public void tableDemo(){
        Table<Integer, Integer, Integer> weightedGraph = HashBasedTable.create();
        weightedGraph.put(1, 2, 4);
        weightedGraph.put(1, 3, 20);
        weightedGraph.put(2, 3, 5);

        Iterator iterator=weightedGraph.row(1).entrySet().iterator();
        // returns a Map mapping 2 to 4, 3 to 20 返回某行
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        weightedGraph.column(3); // returns a Map mapping 1 to 20, 2 to 5
    }

    /*
    ClassToInstanceMap
ClassToInstanceMap是一种特殊的Map：它的键是类型，而值是符合键所指类型的对象。
ClassToInstanceMap有唯一的泛型参数，通常称为B，代表Map支持的所有类型的上界。例如：
ClassToInstanceMap<Number> numberDefaults=MutableClassToInstanceMap.create();
numberDefaults.putInstance(Integer.class, Integer.valueOf(0));
从技术上讲，ClassToInstanceMap<B>实现了Map<Class<? extends B>, B>——或者换句话说，是一个映射B的子类型到对应实例的Map。
这让ClassToInstanceMap包含的泛型声明有点令人困惑，但请记住B始终是Map所支持类型的上界——通常B就是Object。
     */
}
