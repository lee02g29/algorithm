import java.util.*;
import java.math.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        BigDecimal a = new BigDecimal(str);
        str = sc.nextLine();
        BigDecimal b = new BigDecimal(str);
        
        BigDecimal add = a.add(b);
        BigDecimal minus = a.subtract(b);
        BigDecimal multi = a.multiply(b);
          
        System.out.println(add);
        System.out.println(minus);
        System.out.println(multi);
    }
}
