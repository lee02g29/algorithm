import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int test_case = sc.nextInt();   		
    		
    		for(int t = 0; t < test_case; t++) {
    			int r = sc.nextInt();
    			String str = sc.next();
    			String ans = "";
    			
    			for(int i = 0 ; i < str.length(); i++) {
    				for(int j = 0 ; j < r; j++) {
    					ans = ans + str.charAt(i);
    				}
    			}    			
    			System.out.println(ans);
    		}
    }
}
