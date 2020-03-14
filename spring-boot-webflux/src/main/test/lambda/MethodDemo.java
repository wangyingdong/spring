package lambda;

import java.util.function.*;

class Dog {

    private String name = "旺财";


    public Dog() {

    }

    /**
     * 参数的构造函数
     *
     * @param name
     */
    public Dog(String name) {
        this.name = name;
    }

    private int food = 10;

    public static void bark(Dog dog) {
        System.out.println(dog + "叫了");
    }

    public int eat(int num) {
        System.out.println("吃了：" + num + "斤狗粮");
        this.food -= num;
        return this.food;
    }


    @Override
    public String toString() {
        return this.name;

    }

}

public class MethodDemo {

    public static void main(String[] args) {
        Dog dog = new Dog();

        //方法引用
        Consumer<String> consumer1 = i -> System.out.println(i);
        consumer1.accept("hello");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("hello");

        //静态方法
        Consumer<Dog> consumer3 = Dog::bark;
        consumer3.accept(dog);

        //非静态方法，使用对象实例的方法引用
        //Function<Integer, Integer> function = dog::eat;
        //UnaryOperator<Integer> function = dog::eat;
        IntUnaryOperator function = dog::eat;
        System.out.println("还有多少：" + function.applyAsInt(2) + "斤");

        //使用类名来方法引用
        BiFunction<Dog, Integer, Integer> eatFunction = Dog::eat;
        System.out.println("还有多少：" + eatFunction.apply(dog, 1) + "斤");


        //构造函数的方法引用
        Supplier<Dog> supplier = Dog::new;
        System.out.println("创建了新对象：" + supplier.get());


        //带参数的构造方法引用 //左边参数，右边返回值
        Function<String, Dog> function1 = Dog::new;
        System.out.println("创建了新对象：" + function1.apply("大黄"));


    }


}
