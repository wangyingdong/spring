package lambda;

import java.util.function.Consumer;

public class VarDemo {

    public static void main(String[] args) {

        final String s = "hello"; //s不能修改
        Consumer<String> consumer = string -> System.out.println(string +" "+ s);
        consumer.accept("java");
    }


}
