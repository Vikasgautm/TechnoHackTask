import java.util.*;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter binary number");
        int n = in.nextInt();
        int placevalue = 1;
        int ans = 0;
        while (n != 0) {
            int lastdigit = n % 10;
            n = n / 10;
            ans = ans + placevalue * lastdigit;
            placevalue = 2 * placevalue;
        }
        System.out.println("Your decimal Number" + ans);
    }
}
