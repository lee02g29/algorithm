import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int[] count = new int[42];
    		int ans = 0;
    		
    		for(int i = 0; i < 10; i++) {
    			int num = sc.nextInt();
    			count[num % 42]++;
    		}
    		
    		for(int i = 0 ; i < 42; i++) {
    			if(count[i] != 0) {
    				ans++;
    			}
    		}
    		
    		System.out.println(ans);		
    				
    }
}
