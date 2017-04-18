package com.maoyan.day1;

/**
 * Created by jiangdongyu on 2017/4/18.
 */
public class Catch {
//    LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
//            .maximumSize(1000)
//            .expireAfterWrite(10, TimeUnit.MINUTES)
//            .removalListener(MY_LISTENER)
//            .build(
//                    new CacheLoader<Key, Graph>() {
//                        public Graph load(Key key) throws AnyException {
//                            return createExpensiveGraph(key);
//                        }
//                    });
//
/*
计算或检索一个值的代价很高，并且对同样的输入需要不止一次获取值的时候，就应当考虑使用缓存。
ConcurrentMap会一直保存所有添加的元素，直到显式地移除。相对地，Guava Cache为了限制内存占用，通常都设定为自动回收元素。
使用场景：
你愿意消耗一些内存空间来提升速度。
你预料到某些键会被查询一次以上。
缓存中存放的数据总量不会超出内存容量。

缓存回收方式：
基于容量回收
LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
        .maximumWeight(100000)
        .weigher(new Weigher<Key, Graph>() {
            public int weigh(Key k, Graph g) {
                return g.vertices().size();
            }
        })
        .build(
            new CacheLoader<Key, Graph>() {
                public Graph load(Key key) { // no checked exception
                    return createExpensiveGraph(key);
                }
            });

定时回收
基于引用的回收

清理什么时候发生？
如果你的缓存是高吞吐的，那就无需担心缓存的维护和清理等工作。如果你的 缓存只会偶尔有写操作，而你又不想清理工作阻碍了读操作，
那么可以创建自己的维护线程，以固定的时间间隔调

刷新
刷新表示为键加载新值，这个过程可以是异步的。在刷新操作进行时，缓存仍然可以向其他线程返回旧值，而不像回收操作，读缓存的线程必须等待新值加载完成。
如果刷新过程抛出异常，缓存将保留旧值，而异常会在记录到日志后被丢弃[swallowed]。

统计：
CacheBuilder.recordStats()用来开启Guava Cache的统计功能。
hitRate()：缓存命中率；
averageLoadPenalty()：加载新值的平均时间，单位为纳秒；
evictionCount()：缓存项被回收的总数，不包括显式清除。

asMap视图
asMap视图提供了缓存的ConcurrentMap形式，但asMap视图与缓存的交互需要注意：
cache.asMap()包含当前所有加载到缓存的项。因此相应地，cache.asMap().keySet()包含当前所有已加载键;
asMap().get(key)实质上等同于cache.getIfPresent(key)，而且不会引起缓存项的加载。这和Map的语义约定一致。
所有读写操作都会重置相关缓存项的访问时间，包括Cache.asMap().get(Object)方法和Cache.asMap().put(K, V)方法，
但不包括Cache.asMap().containsKey(Object)方法，也不包括在Cache.asMap()的集合视图上的操作。比如，遍历Cache.asMap().entrySet()不会重置缓存项的读取时间。
 */

}
