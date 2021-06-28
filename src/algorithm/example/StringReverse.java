package algorithm.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class StringReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] sc = scanner.nextLine().toCharArray();

        Arrays.asList(sc).stream().forEach(System.out::println);

        // str ing
        for (int i=0; i<sc.length/2; i++) {
            char temp = sc[i];
            sc[i] = sc[sc.length-i-1];
            sc[sc.length-i-1] = temp;
        }

        System.out.println(new String(sc));

    }
}
