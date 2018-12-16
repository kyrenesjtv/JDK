package com.github.kyrenesjtv.day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @ProjectName: JDK8
 * @Author: wanglin
 * @CreateDate: 2018/12/16 19:00
 */
public class CreateStream {

    /**
     * 通过集合 .stream()
     *
     * @return
     */
    private static Stream<String> createStreamFromCollection() {
        List<String> strings = Arrays.asList("wang", "lin", "hello", "world");
        return strings.stream();
    }

    /**
     * stream.of 集合
     *
     * @return
     */
    private static Stream<String> createStreamFromValues() {
        return Stream.of("wang", "lin", "hello", "world");
    }

    /**
     * 通过Arrays.stream 数组
     *
     * @return
     */
    private static Stream<String> createStreamFromArrays() {
        String[] strings = {"wang", "lin", "hello", "world"};
        return Arrays.stream(strings);
    }

    /**
     * Files.lines(path)
     *
     * @return
     */
    private static Stream<String> createStreamFromFile() {
        Path path = Paths.get("E:\\workspace\\myworkspace\\JDK8\\src\\main\\java\\com\\github\\kyrenesjtv\\day7\\CreateStream.java");
        //将需要关闭的资源卸载()当中,当try执行完毕的时候,会自动close(源代码帮我们close)。 比如流，线程?
        try (Stream<String> streams = Files.lines(path)) {
            streams.forEach(System.out::println);
            return streams;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Stream.iterate()。获取无限的stream。需要加限制条数。
     * @return
     */
    private static Stream<Integer> createStreamFromIterator() {
        //会返回无限多的stream。需要加限制。类似死循环
        Stream<Integer> streams =Stream.iterate(0, (e) -> e + 2).limit(10);
        return streams;
    }
    /**
     * Stream.generate()。获取无限的stream。需要加限制条数。
     * @return
     */
    private static Stream<Double> createStreamFromGenerate() {
        return Stream.generate(Math::random).limit(10);
    }

    /****************  自己创建一个对象的stream  ********************/


    /**
     * Stream.generate()。获取无限的stream。需要加限制条数。
     * @return
     */
    private static Stream<Obj> createObjStreamFromGenerate() {
        return Stream.generate(new ObjSpulier()).limit(10);
    }

    static class Obj{

        private Integer id;

        private String name ;

        public Obj(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "obj{" + "id=" + id + ", name='" + name + '\'' + '}';
        }
    }

    static class ObjSpulier implements Supplier<Obj>{

        private Integer index = 0;
        //不填写种子,默认为当前系统的毫秒数。不可用固定的数字，否则出来的就不是随机数
        private Random random = new Random(System.currentTimeMillis());

        @Override
        public Obj get() {
            index = random.nextInt(100);
            return new Obj(index,"name->"+index);
        }
    }


    public static void main(String[] args) {
//        createStreamFromCollection().forEach(System.out::println);
//        createStreamFromValues().forEach(System.out::println);
//        createStreamFromArrays().forEach(System.out::println);
//        Stream<String> streamFromFile = createStreamFromFile();
//        System.out.println("引用: " + streamFromFile);

//        createStreamFromIterator().forEach(System.out::println);
//        createStreamFromGenerate().forEach(System.out::println);

        createObjStreamFromGenerate().forEach(System.out::println);
    }


}
