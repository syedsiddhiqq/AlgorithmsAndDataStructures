package Learning;

import java.util.concurrent.Callable;

/**
 * @author Syed Ali.
 * @createdAt 13/01/2022, Thursday, 11:15
 */
public class A {
    public static void main(String[] args) throws Exception {
        Callable<Integer> x = () ->{
            return 5 * 2;
        };

        System.out.println(x.call());;
    }
}
