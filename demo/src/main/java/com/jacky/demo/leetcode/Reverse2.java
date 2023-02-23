package com.jacky.demo.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/**
 * intput: 11,12,13,14,15
 * output: 15,14,13,12,11
 * */

public class Reverse2 {

        public static void reverse(Integer[] num) {
            Collections.reverse(Arrays.asList(num));
            System.out.println(Arrays.asList(num));
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("請輸入要反轉的整數陣列，並以逗號分隔：");
            String input = scanner.nextLine();

            String[] strArr = input.split(","); // 輸入要反轉的整數陣列，以逗號分隔。
            Integer[] arr = new Integer[strArr.length];

            // 將strArr轉換成Integer型態的陣列arr，並使用trim()方法，去除每個元素字串的前後空白。
            for (int i = 0; i < strArr.length; i++) {
                arr[i] = Integer.parseInt(strArr[i].trim());
            }

            reverse(arr);
        }
}


