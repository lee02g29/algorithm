import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int sum = 0;

            for(int i = 1; i <= n ; i++) {
                int temp = i;
                sum = temp;
                while(temp > 0) {
                    sum = sum + temp % 10;
                    temp = temp / 10;
                }
                if(sum == n) {
                    System.out.println(i);
                    break;
                }
                if(i == n) System.out.println(0);
            }         
        }    
}
