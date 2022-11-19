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
