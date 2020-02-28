package lambda;

@FunctionalInterface
interface IMath {
    int add(int x, int y);
}


public class TypeDemo {


    public static void main(String[] args) {
        //变量类型定义
        IMath lambda = (x, y) -> x + y;
        System.out.println(lambda.add(1,2));

        //数组
        IMath lambdas[] = {(x, y) -> x + y};

        //强转
        Object lambdaObject = (IMath) (x, y) -> x + y;

        //通过返回类型
        IMath iMath = createlambda();


    }

    public static IMath createlambda() {
        return (x, y) -> x + y;
    }
}
