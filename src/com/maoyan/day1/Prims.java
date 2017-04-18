package com.maoyan.day1;

/**
 * Created by jiangdongyu on 2017/4/18.
 */
public class Prims {

    /*
    Guava提供了若干通用工具，包括原生类型数组与集合API的交互，原生类型和字节数组的相互转换，以及对某些原生类型的无符号形式的支持。
    原生类型	Guava工具类（都在com.google.common.primitives包）
    byte	Bytes, SignedBytes, UnsignedBytes
    short	Shorts
    int	    Ints, UnsignedInteger, UnsignedInts
    long	Longs, UnsignedLong, UnsignedLongs
    float	Floats
    double	Doubles
    char	Chars
    boolean	Booleans

    List<Wrapper> asList(prim… backingArray)	    把数组转为相应包装类的List
    prim[] toArray(Collection<Wrapper> collection)	把集合拷贝为数组，和collection.toArray()一样线程安全
    prim[] concat(prim[]… arrays)	串联多个原生类型数组
    boolean contains(prim[] array, prim target)	判断原生类型数组是否包含给定值
    int indexOf(prim[] array, prim target)	给定值在数组中首次出现处的索引，若不包含此值返回-1
    int lastIndexOf(prim[] array, prim target)	给定值在数组最后出现的索引，若不包含此值返回-1
    prim min(prim… array)数组中的最小值
    prim max(prim… array)数组中的最大值
    String join(String separator, prim… array)	把数组用给定分隔符连接为字符串
    Comparator<prim[]>   lexicographicalComparator()	按字典序比较原生类型数组的Comparator


    int compare(prim a, prim b)	传统的Comparator.compare方法，但针对原生类型。JDK7的原生类型包装类也提供这样的方法	符号相关
    prim checkedCast(long value)	把给定long值转为某一原生类型，若给定值不符合该原生类型，则抛出IllegalArgumentException	仅适用于符号相关的整型*
    prim saturatedCast(long value)	把给定long值转为某一原生类型，若给定值不符合则使用最接近的原生类型值	仅适用于符号相关的整型

    int BYTES	常量：表示该原生类型需要的字节数
    prim fromByteArray(byte[] bytes)	使用字节数组的前Prims.BYTES个字节，按大字节序返回原生类型值；如果bytes.length <= Prims.BYTES，抛出IAE
    prim fromBytes(byte b1, …, byte bk)	接受Prims.BYTES个字节参数，按大字节序返回原生类型值
    byte[] toByteArray(prim value)	按大字节序返回value的字节数组

    int/long UnsignedInts.parseUnsignedInt(String)	按无符号十进制解析字符串
    int/long UnsignedInts.parseUnsignedInt(String string, int radix)	按无符号的特定进制解析字符串
    String UnsignedInts.toString(long)	数字按无符号十进制转为字符串
    String UnsignedInts.toString(long   value, int radix)	数字按无符号特定进制转为字符串

    UnsignedPrim add(UnsignedPrim), subtract, multiply, divide, remainder	简单算术运算
    UnsignedPrim valueOf(BigInteger)	                                    按给定BigInteger返回无符号对象，若BigInteger为负或不匹配，抛出IAE
    UnsignedPrim valueOf(long)	                                            按给定long返回无符号对象，若long为负或不匹配，抛出IAE
    UnsignedPrim asUnsigned(prim value)	                                    把给定的值当作无符号类型。例如，UnsignedInteger.asUnsigned(1<<31)的值为231,尽管1<<31当作int时是负的
    BigInteger bigIntegerValue()	                                        用BigInteger返回该无符号对象的值
    toString(),  toString(int radix)	                                    返回无符号值的字符串表示

     */


}
