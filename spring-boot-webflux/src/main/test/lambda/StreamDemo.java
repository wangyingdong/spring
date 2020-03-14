package lambda;


import com.f139.webflux.entry.Gender;
import com.f139.webflux.entry.User;
import org.apache.commons.collections4.MapUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {


    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        int sum = Arrays.stream(num).map(i -> i * 2).sum();
        System.out.println(sum);


        String str = "my name is 007";
        Stream.of(str.split(" ")).flatMap(s -> s.chars().boxed()).forEach(
                i -> System.out.println((char) i.intValue()));
        //peek 用于debug，是个中间操作，forEach是个终止操作
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);


        str.chars().parallel().forEach(i -> System.out.println((char) (i)));

        //limit
        new Random().ints().filter(i -> i > 100 && i < 10000).limit(10).forEach(System.out::println);

        Optional<String> reduce = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        System.out.println(reduce.orElse(""));

        String s = Stream.of(str.split(" ")).reduce("", (s1, s2) -> s1 + "|" + s2);
        System.out.println(s);

        //max
        Optional<String> max = Stream.of(str.split(" ")).max((s1, s2) -> s1.length() - s2.length());
        System.out.println(max.get());

        //parallel 并行流 多线程
        IntStream.range(1, 10).parallel().peek(StreamDemo::debug).count();


        List<User> studentList = Arrays.asList(
                User.builder().id("1").age(11).name("张三").gender(Gender.FEMALE).build(),
                User.builder().id("2").age(12).name("李四").gender(Gender.MALE).build(),
                User.builder().id("2").age(10).name("王五").gender(Gender.MALE).build()

        );
        //User:getId 方法引用  == s -> s.getId()
        List<Integer> collect = studentList.stream().map(User::getAge).collect(Collectors.toList());
        System.out.println(collect);

        //统计汇总
        IntSummaryStatistics collect1 = studentList.stream().collect(Collectors.summarizingInt(User::getAge));
        System.out.println(collect1);

        //分块
        Map<Boolean, List<User>> collect2 = studentList.stream().collect(Collectors.partitioningBy(i -> i.getGender() == Gender.FEMALE));
        MapUtils.verbosePrint(System.out, "男女列表", collect2);

        //分组
        Map<Gender, List<User>> collect3 = studentList.stream().collect(Collectors.groupingBy(User::getGender));
        MapUtils.verbosePrint(System.out, "男女列表", collect3);

        //分组的个数
        Map<Gender, Long> collect4 = studentList.stream().collect(Collectors.groupingBy(User::getGender, Collectors.counting()));
        MapUtils.verbosePrint(System.out, "男女个数列表", collect4);

    }


    public static void debug(int i) {
        System.out.println(Thread.currentThread().getName() + "debug" + i);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
