# Java-systeam
Java 集合体系特点
1、数组和集合的元素存储的个数问题。
数组定义后类型确定，长度固定
集合类型可以不固定，大小是可变的。
2、数组和集合存储元素的类型问题。
数组可以存储基本类型和引用类型的数据。
集合只能存储引用数据类型的数据。
3、数组和集合适合的场景
数组适合做数据个数和类型确定的场景。
集合适合做数据个数不确定，且要做增删元素的场景，集合种类更多，功能更强大。

# 1.集合的体系特点

# 1.1Collection的常用方法

## 1.2Collection集合特点

List系列集合：添加的元素是有序、可重复、有索引。
ArrayList、LinekdList ：有序、可重复、有索引。
Set系列集合：添加的元素是无序、不重复、无索引。
HashSet: 无序、不重复、无索引；LinkedHashSet: 有序、不重复、无索引。
TreeSet：按照大小默认升序排序、不重复、无索引。

```java
package collction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Demo1 {
    public static void main(String[] args) {
        //有序可重复索引
        Collection list = new ArrayList(  );
        list.add("java");
        list.add("java");
        list.add("Match");
        list.add("false");
        list.add("true");
        System.out.println( list );
        //无序不重复索引
        Collection list1 = new HashSet(  );
        list1.add("java");
        list1.add("java");
        list1.add("Match");
        list1.add("false");
        list1.add("true");
        System.out.println( list1 );
        System.out.println("****************");
        Collection list2 = new ArrayList(  );
        list2.add("java");
        list2.add("23");
        list2.add("黑马");
        //集合和泛型不支持基本数据类型 ，只能支持引用数据类型
        Collection<Integer> list3 = new ArrayList<>(  );
        list3.add(23);
        list3.add(233);
        list3.add(2343);
        Collection<Double> list4= new ArrayList<>(  );
        list4.add(23.3);
        list4.add(233.7);
        list4.add(2343.3);
        

    }
}

```

1、集合的代表是？
Collection接口。
2、Collection集合分了哪2大常用的集合体系？
List系列集合：添加的元素是有序、可重复、有索引。
Set系列集合：添加的元素是无序、不重复、无索引。
3、如何约定集合存储数据的类型，需要注意什么？
集合支持泛型。
集合和泛型不支持基本类型，只支持引用数据类型。

Collection集合常用API

| 方法名称                             | 说明                             |
| ------------------------------------ | -------------------------------- |
| public  boolean add(E e)             | 把给定的对象添加到当前集合中     |
| public  void clear()                 | 清空集合中所有的元素             |
| public  boolean remove(E e)          | 把给定的对象在当前集合中删除     |
| public  boolean contains(Object obj) | 判断当前集合中是否包含给定的对象 |
| public  boolean isEmpty()            | 判断当前集合是否为空             |
| public  int size()                   | 返回集合中元素的个数。           |
| public  Object[] toArray()           | 把集合中的元素，存储到数组中     |

```java
package collection.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>(  );
        //1.添加元素
        c.add( "java" );
        c.add( "Mysql" );
        c.add( "java" );
        c.add( "heima" );
        System.out.println( c );
        //2.清空集合中所有的元素
        //list.clear();
     //   System.out.println( c );
       // 3.判断当前集合是否为空
        System.out.println( c.isEmpty() );
        //4.返回集合中元素的个数。
        System.out.println( c.size() );
        //5.判断当前集合中是否包含给定的对象
        System.out.println( c.contains( "heima" ) );
        //6.把给定的对象在当前集合中删除
        System.out.println( c.remove( "java" ) );
        //7.把集合转成数组
        Object[] arrs =  c.toArray();
        System.out.println("数组："+ Arrays.toString( arrs ) );
        System.out.println("**************");
        Collection<String> c1 = new ArrayList<>(  );
        c1.add("java1");
        c1.add("java2");
        Collection<String> c2 = new ArrayList<>(  );
        c1.add("张三");
        c1.add("李四");
        c1.addAll( c2 );
        System.out.println( c1 );
        System.out.println( c2 );


    }
}
```

# 1.3Collection集合的遍历方式

### 方式一：迭代器

遍历就是一个一个的把容器中的元素访问一遍。 
迭代器在Java中的代表是Iterator，迭代器是集合的专用的遍历方式。

```java
package traversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class demo {
    public static void main(String[] args) {
        Collection<String> lists = new ArrayList<>(  );
        lists.add("张三");
        lists.add("李四");
        lists.add("王五");
        lists.add("刘备");
        //1.得到当前对象的对象
        Iterator<String> it = lists.iterator();
        String e =  it.next();
       // System.out.println( e );
       // System.out.println( it.next() );
        //System.out.println( it.next() );
        //System.out.println( it.next() );
        //System.out.println( it.next() );//出现无此元素异常 禁止越界
        //2.定义一个循环
        while(it.hasNext()){
           String ee =  it.next();
            System.out.println( ee );
        }
        
    }
}
```

1、迭代器的默认位置在哪里。
Iterator<E> iterator()：得到迭代器对象，默认指向当前集合的索引0

2、迭代器如果取元素越界会出现什么问题。
会出现NoSuchElementException异常。

### 方式二：foreach/增强for循环

 增强for循环：既可以遍历集合也可以遍历数组。

```java
package traversal;

import java.util.ArrayList;
import java.util.Collection;

public class Demo2 {
    public static void main(String[] args) {
        Collection<String> lists= new ArrayList<>(  );
        lists.add("张三");
        lists.add("张二");
        lists.add("张一");
        lists.add("张八");
        System.out.println( lists );
        for(String ele:lists){
            System.out.println( ele );
        }
        System.out.println("**************");
        double[] scores = {100,99.5,59.5};
        for (double score : scores) {
            System.out.println( score );
            if(score == 59.5){
                score = 100;//修改无意义,不会改变元素值
            }

        }
        System.out.println( scores );//没有影响
    }
}
```

```
for(元素数据类型 变量名 : 数组或者Collection集合) {
         //在此处使用变量即可，该变量就是元素
}

```

### 方式三：lambda表达式

| 方法名称                                          | 说明               |
| ------------------------------------------------- | ------------------ |
| default void forEach(Consumer<? super T> action): | 结合lambda遍历集合 |

```java
package traversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class Demo3 {
    public static void main(String[] args) {
        Collection<String> lists = new ArrayList<>();
        lists.add( "张一" );
        lists.add( "张二" );
        lists.add( "张三" );
        lists.add( "张四" );
        lists.add( "张五" );
        System.out.println( lists );

      // lists.forEach( new Consumer<String>() {
      //      @Override
       //     public void accept(String s) {
          //      System.out.println( s );
       //     }
    //    } );
        lists.forEach( s-> {
                System.out.println( s );
        } );
    }
}
```

# 1.4Collection集合存储自定义类型的对象

影片信息在程序中的表示

```java
package traversal;

import java.util.ArrayList;
import java.util.Collection;

public class TestDemo {
    public static void main(String[] args) {
        Collection<Movie> movies = new ArrayList<>(  );
        movies.add(new Movie( "张三",9.9,"李四" ));
        movies.add(new Movie( "王五",9.9,"李四" ));
        movies.add(new Movie( "刘备",9.9,"李四" ));
        for (Movie movie : movies) {
            System.out.println("片名："+movie.getName());
            System.out.println("得分："+movie.getScore());
            System.out.println("主演："+movie.getActor());

        }
    }
}
```

1、集合中存储的是元素的什么信息?
集合中存储的是元素对象的地址。

# 2. 常见数据结构

##  2.1 数据结构概述、栈、队列

​      数据结构是计算机底层存储、组织数据的方式。是指数据相互之间是以什么方式排列在一起的。
​      通常情况下，精心选择的数据结构可以带来更高的运行或者存储效率

​      栈数据结构的执行特点  后进先出，先进后出

​      常见数据结构之队列 先进先出，后进后出

## 2.2 数组

​     查询速度快：查询数据通过地址值和索引定位，查询任意数据耗时相同。（元素在内存中是连续存储的）

​     删除效率低：要将原始数据删除，同时后面每个数据前移

​     添加效率极低：添加位置后的每个数据后移，再添加元素。

## 2.3 链表

链表中的元素是在内存中不连续存储的，每个元素节点包含数据值和下一个元素的地址。

链表查询慢。无论查询哪个数据都要从头开始找

链表增删相对快

## 2.4 二叉树、 二叉查找树

二叉树

只能有一个根节点，每个节点最多支持2个直接子节点。
节点的度： 节点拥有的子树的个数，二叉树的度不大于2 叶子节点 度为0的节点，也称之为终端结点。
高度：叶子结点的高度为1，叶子结点的父节点高度为2，以此类推，根节点的高度最高。
层：根节点在第一层，以此类推
兄弟节点 ：拥有共同父节点的节点互称为兄弟节点

二叉查找树

目的：提高检索数据的性能。

规则：
      小的存左边
      大的存右边
      一样的不存

## 2.5 二叉树查找树添节点平衡二叉树

任意节点的左右两个子树的高度差不超过1，任意节点的左右两个子树都是一颗平衡二叉树

旋转：

左左
左右
右右
右左

## 2.6 红黑树

每一个节点可以是红或者黑；红黑树不是通过高度平衡的，它的平衡是通过“红黑规则”进行实现的。

添加的节点的颜色，可以是红色的，也可以是黑色的。
默认用红色效率高

红黑规则：

每一个节点或是红色的，或者是黑色的，根节点必须是黑色。
如果某一个节点是红色，那么它的子节点必须是黑色(不能出现两个红色节点相连的情况)。
对每一个节点，从该节点到其所有后代叶节点的简单路径上，均包含相同数目的黑色节点。

每一个节点或是红色的，或者是黑色的，根节点必须是黑色
如果一个节点没有子节点或者父节点，则该节点相应的指针属性值为Nil，这些Nil视为叶节点，每个叶节点(Nil)是黑色的；
如果某一个节点是红色，那么它的子节点必须是黑色(不能出现两个红色节点相连的情况)
对每一个节点，从该节点到其所有后代叶节点的简单路径上，均包含相同数目的黑色节点。

红黑树增删改查的性能都很好

## 2.7 各种数据结构的特点和作用是什么样的

队列：先进先出，后进后出。
栈：后进先出，先进后出。
数组：内存连续区域，查询快，增删慢。
链表：元素是游离的，查询慢，首尾操作极快。
二叉树：永远只有一个根节点, 每个结点不超过2个子节点的树。
查找二叉树：小的左边，大的右边，但是可能树很高，查询性能变差。
平衡查找二叉树：让树的高度差不大于1，增删改查都提高了。
红黑树（就是基于红黑规则实现了自平衡的排序二叉树）

# 3. List系列集合

## 3.1 List集合特点、特有API

1、list系列集合特点
  ArrayList、LinekdList ：有序，可重复，有索引。
有序：存储和取出的元素顺序一致
有索引：可以通过索引操作元素
可重复：存储的元素可以重复

2、List的实现类的底层原理
 ArrayList底层是基于数组实现的，根据查询元素快，增删相对慢。
LinkedList底层基于双链表实现的，查询元素慢，增删首尾元素是非常快的

| 方法名称                      | 说明                                   |
| ----------------------------- | -------------------------------------- |
| void add(int index,E element) | 在此集合中的指定位置插入指定的元素     |
| E remove(int index)           | 删除指定索引处的元素，返回被删除的元素 |
| E set(int index,E element)    | 修改指定索引处的元素，返回被修改的元素 |
| E get(int index)              | 返回指定索引处的元素                   |

```java
package list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(  );//经典代码

        list.add( "Java" );
        list.add( "Java" );
        list.add( "Html" );
        list.add( "Mysql" );
        //1.插入
        list.add(2,"南辞");
        System.out.println( list );
        //2.删除
        list.remove( 1 );
        System.out.println( list );
        //3.根据索引获取元素
        System.out.println( list.get( 1 ) );
        //4,修改索引位置元素值
        list.set( 1 ,"张南辞");
        System.out.println( list );


    }
}
```

## 3.2 List集合的遍历方式小结

1.List集合的遍历方式有几种？
迭代器 
增强for循环
Lambda表达式
for循环（因为List集合存在索引）

```java
package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>(  );
        lists.add( "java1" );
        lists.add( "java2" );
        lists.add( "java3" );
        //1.for
        System.out.println("*******************");
        for (int i = 0; i < lists.size(); i++) {
         String  e = lists.get( i );
            System.out.println( e );
        }
        //2.迭代器
        System.out.println("*******************");
        Iterator<String> it = lists.iterator();
        while (it.hasNext()){
          String ee =   it.next();
          System.out.println( ee );
        }

        //3.Lambda表达式
        System.out.println("*******************");
        lists.forEach( s -> {
            System.out.println( s );
        } );

        //4.foreach
        System.out.println("*******************");
        for(String eee:lists){
            System.out.println( eee );
        }
    }
}
```



## 3.3 LinkedList集合的底层原理

底层数据结构是双链表，查询慢，首尾操作的速度是极快的，所以多了很多首尾操作的特有API。

| 方法名称                  | 说明                             |
| ------------------------- | -------------------------------- |
| public void addFirst(E e) | 在该列表开头插入指定的元素       |
| public void addLast(E e)  | 将指定的元素追加到此列表的末尾   |
| public E getFirst()       | 返回此列表中的第一个元素         |
| public E getLast()        | 返回此列表中的最后一个元素       |
| public E removeFirst()    | 从此列表中删除并返回第一个元素   |
| public E removeLast()     | 从此列表中删除并返回最后一个元素 |

```java
package list;

import java.util.LinkedList;

public class Demo3 {
    public static void main(String[] args) {
        //排队系统
        //栈结构队列结构
        //1.队列
        LinkedList<String> queue  = new LinkedList<>(  );
        queue.addLast("1号");
        queue.addLast("2号");
        queue.addLast("3号");
        System.out.println( queue );
        //出队
        System.out.println( queue.removeFirst() );
        System.out.println( queue.removeFirst() );
        System.out.println( queue );

        //栈
        LinkedList<String> stack  = new LinkedList<>(  );
        //手枪 入栈(push)
        stack.push("第一颗");
        stack.push("第二颗");
        stack.push("第三颗");
        stack.push("第四颗");
        System.out.println( stack );
        //出栈(pop)
        System.out.println( stack.pop() );
        System.out.println( stack.pop() );
        System.out.println( stack.pop() );
        System.out.println( stack );//[第一颗]

    }
}
```



# 4. 补充知识：集合的并发修改异常问题

## 4.1 哪些遍历存在问题？

迭代器遍历集合且直接用集合删除元素的时候可能出现。
增强for循环遍历集合且直接用集合删除元素的时候可能出现。

## 4.2 哪种遍历且删除元素不出问题

迭代器遍历集合但是用迭代器自己的删除方法操作可以解决。
使用for循环遍历并删除元素不会存在这个问题。

```java
package update;
//迭代器（必须使用自己的）或者for(从后往前遍历删除)
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
       // 当我们从集合中找出某个元素并删除的时候可能出现一种并发修改异常问题。
        List<String> list =  new ArrayList<>(  );
        list.add("黑马");
        list.add("黑我去");
        list.add("黑我去饿");
        list.add("黑分别");
//        //迭代器
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()){
//            String e = it.next();
//            if("黑马".equals( e )){
//                //删除
//             //   list.remove( e );
//                it.remove();//删除迭代器所在位置的元素值
//            }
//        }
//        System.out.println( list );
        //foreach 不能变遍历变删除会出现Bug
//       /
        //lambda 也不行
//        list.forEach( s->{
//            if("黑马".equals( s )){
//                list.remove( s ) ;}
//        } );
        //for  可以必须从后遍历删除
        for (int i = list.size()-1; i >=0 ; i--) {
            String e =  list.get( i );
            if("黑马".equals( e )){
                list.remove( e );
            }
        }
        System.out.println( list );
    }
}
```

