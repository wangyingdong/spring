package lambda;

import java.util.function.Function;

public class CurryDemo {


    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> function = x -> y -> (x + y);
        System.out.println(function.apply(1).apply(2));


        Function<Integer, Function<Integer, Function<Integer, Integer>>> function2 = x -> y -> z -> (x + y + z);
        System.out.println(function2.apply(1).apply(2).apply(3));


        int[] nums = {1, 2, 3};
        Function f = function2;
        for (int i : nums) {
            if (f instanceof Function) {
                Object o = f.apply(i);
                if (o instanceof Function) {
                    f = (Function) o;
                } else {
                    System.out.println("结果为：" + o);
                }
            }
        }


    }

}
