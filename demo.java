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
