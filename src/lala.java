import java.util.Scanner;

import org.junit.Test;


public class lala {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        long n = scanner.nextLong();
        if (n == 0) {
            System.out.println((long) Math.pow(x, y));
        } else {
            System.out.println((long) (Math.pow(x, y) % n));
        }
    }
}
