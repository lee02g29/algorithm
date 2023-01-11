import java.math.BigDecimal;
import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] num = new int[n];
            int[] plus = new int[3];
            int max = 0;

            for(int i = 0; i < n ; i++) {
                num[i] = sc.nextInt();
            }

            for(int i = 0; i < n - 2; i++) {
                plus[0] = num[i];
                for(int j = i + 1; j < n - 1; j++) {
                    plus[1] = plus[0] + num[j];
                    for(int k = j + 1; k < n; k++) {
                        plus[2] = plus[1] + num[k];
                        if(max < plus[2] && plus[2] <= m) {
                            max = plus[2];
                        }
                    }
                }
            }

            System.out.println(max);
        }
}
