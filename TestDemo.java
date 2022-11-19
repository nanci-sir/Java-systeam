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
