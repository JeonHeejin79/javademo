package algorithm.example;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlphaGenerator {

    public static void main(String[] args) {
        String upperAlpha = IntStream.rangeClosed('A', 'Z')
                .mapToObj(v -> "" + (char)v).collect(Collectors.joining());

        String lowerAlphe = IntStream.rangeClosed('a', 'z')
                .mapToObj(v -> "" + (char)v).collect(Collectors.joining());

        String number = IntStream.rangeClosed(0, 9)
                .mapToObj(v -> "" + v).collect(Collectors.joining());

        StringBuilder sb = new StringBuilder();
        sb.append(upperAlpha);
        sb.append(lowerAlphe);
        sb.append(number);

        System.out.println(sb.toString());
    }
}
