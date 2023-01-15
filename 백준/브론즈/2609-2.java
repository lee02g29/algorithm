import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int max = a >= b ? a : b;
    		int min = max == a ? b : a;
    		
    		int gcd = gcd(max, min);
    		System.out.println( gcd );
    		System.out.println( a * b / gcd );
    		
    }   	
    
    public static int gcd(int a, int b) {
    	if(b == 0) return a;
    	else return gcd(b, a % b);
    }
}
