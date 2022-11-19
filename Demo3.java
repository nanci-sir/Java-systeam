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