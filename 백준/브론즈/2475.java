import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);

            int sum = 0;

            for(int i = 1; i <= 5; i++) {
                int n = sc.nextInt();
                sum = sum + n * n;
            }

            System.out.println(sum % 10);
    }		
}
