package com.example.tacao;

public class dd {
    public static void main(String[] args) {
        String str = "**java***java*****java*";
        String str1 = "java";
        int index = 0;

        while ((index = str.indexOf(str1, index)) != -1) {
            System.out.print(index + " #");
            index += str1.length();
        }

        System.out.println(22.5 * 22.5);
    }
}
