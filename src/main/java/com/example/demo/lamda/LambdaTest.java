package com.example.demo.lamda;

import java.util.function.Function;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/29 10:39
 */
public class LambdaTest {


    public static void test(Integer a, Function function) {
        function.apply(1);
    }


    public static void print(Integer a, Integer b) {
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        Integer a = 2;

        test(a, x -> {
            print(a, 2);
            return null;
        });
    }

}
