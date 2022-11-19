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
