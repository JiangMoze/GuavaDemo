package com.maoyan.day1;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import org.junit.Test;

/**
 * Created by jiangdongyu on 2017/4/18.
 */
public class Hash {
    /*
    HashFunction
    HashFunction是一个单纯的（引用透明的）、无状态的方法，它把任意的数据块映射到固定数目的位指，并且保证相同的输入一定产生相同的输出，不同的输入尽可能产生不同的输出。

    Hasher
    Hasher提供了流畅的语法把数据添加到散列运算，然后获取散列值。Hasher可以接受所有原生类型、字节数组、字节数组的片段、字符序列、特定字符集的字符序列等等，
    或者任何给定了Funnel实现的对象。
     */
    @Test
    public void hashiDemo(){
        HashFunction hf = Hashing.md5();
        HashCode hc = hf.newHasher()
                .putLong(1234)
                .putString("jiji", Charsets.UTF_8)
                .hash();
        System.out.println(hc);
    }

    /*
    Funnel
    Funnel描述了如何把一个具体的对象类型分解为原生字段值，从而写入PrimitiveSink。
    Funnel<Person> personFunnel = new Funnel<Person>() {
        @Override
        public void funnel(Person person, PrimitiveSink into) { 把一个person内的信息进行拆分
            into
             .putInt(person.id)
             .putString(person.firstName, Charsets.UTF_8)
            .putString(person.lastName, Charsets.UTF_8)
            .putInt(birthYear);
         }
    }
     */

    /*
    HashCode
    一旦Hasher被赋予了所有输入，就可以通过hash()方法获取HashCode实例（多次调用hash()方法的结果是不确定的）。
    HashCode可以通过asInt()、asLong()、asBytes()方法来做相等性检测，此外，writeBytesTo(array, offset, maxLength)把散列值的前maxLength字节写入字节数组。
     */

    /*
    Hashing类
    Hashing类提供了若干散列函数，以及运算HashCode对象的工具方法。

    md5()	    murmur3_128()	murmur3_32()	sha1()
    sha256()	sha512()	    goodFastHash(int bits)
     */

    /*
    HashCode运算
    HashCode combineOrdered( Iterable<HashCode>)	    以有序方式联接散列码，如果两个散列集合用该方法联接出的散列码相同，那么散列集合的元素可能是顺序相等的
    HashCode   combineUnordered( Iterable<HashCode>)	以无序方式联接散列码，如果两个散列集合用该方法联接出的散列码相同，那么散列集合的元素可能在某种排序下是相等的
    int   consistentHash( HashCode, int buckets)	    为给定的”桶”大小返回一致性哈希值。当”桶”增长时，该方法保证最小程度的一致性哈希值变化。详见一致性哈希。
     */
}

