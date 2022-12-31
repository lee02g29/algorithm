import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int c = sc.nextInt();
    		
    		int[] count = new int[10];
    		int ans = a * b * c;
    		
    		while(ans > 0) {
    			int num = ans % 10;
    			ans = ans / 10;
    			count[num]++;
    		}
    		
    		for(int i = 0; i <= 9; i++) {
    			System.out.println(count[i]);
    		}
    		
    }
}
