package com.jacky.demo.leetcode;

import java.util.Scanner;

public class Reverse {


        public static void main(String[] args) {
            // 讓使用者輸入整數陣列
            Scanner scanner = new Scanner(System.in);
            System.out.print("請輸入要反轉的整數陣列（以逗號分隔）：");
            String input = scanner.nextLine();
            String[] arrStr = input.split(",");
            int[] arr = new int[arrStr.length];
            for (int i = 0; i < arrStr.length; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }

            // 反轉arr陣列
            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }

            // 輸出反轉後的arr陣列
            System.out.print("反轉後的整數陣列為：");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i < arr.length - 1) {
                    System.out.print(", ");
                }
            }
        }
}
