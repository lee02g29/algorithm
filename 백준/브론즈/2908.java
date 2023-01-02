import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int x = sc.nextInt();   		
    		int y = sc.nextInt();
    		
    		int x2 = 0;
    		int y2 = 0;
    		
    		int ans = 0;
    		
    		while(x > 0 && y > 0) {
    			x2 = x2 * 10 + x % 10;
    			y2 = y2 * 10 + y % 10;
    			
    			x = x / 10;
    			y = y / 10;
    		}
    		
    		ans = (x2 > y2) ? x2 : y2;
    		
    		System.out.println(ans);
    }
}
