import java.math.BigDecimal;
import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);

            String number = sc.nextLine();
            BigDecimal n = new BigDecimal(number);
            int index = 1;
            BigDecimal sum = new BigDecimal(1);

            if(n.equals(new BigDecimal(1))) System.out.println(1);
            else {
                while( sum.compareTo(n) == 0 ||  sum.compareTo(n) < 0) {
                    if(sum.compareTo(n) == 0) break;
                    index++;
                    sum = new BigDecimal(3 * index * index - 3 * index + 1);                    
                }
                System.out.println(index);
            }
        }
}
