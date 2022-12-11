import java.util.*;
import java.math.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" "); 
        BigDecimal n = new BigDecimal(str[0]);
        BigDecimal m = new BigDecimal(str[1]);
        
        BigDecimal[] result = n.divideAndRemainder(m);
        
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
