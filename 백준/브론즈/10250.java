import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int t = sc.nextInt();
    		
    		for(int test = 0; test < t; test++) {
    			int h = sc.nextInt();
    			int w = sc.nextInt();
    			int n = sc.nextInt();
    			int ans = 0;
    			
    			int floor = (n % h);
    			int room = (n / h);  
    			if(floor != 0) room = room + 1;
    			if(floor == 0) floor = h;   			   			
    			ans = floor * 100 + room;
  		
    			System.out.println(ans);
    		}
    }
}
