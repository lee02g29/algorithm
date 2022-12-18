import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int first = sc.nextInt();
    		int second = sc.nextInt();
    		int result = 0;
    		int[] num = new int[3];
    		
    		for(int i = 0; i < 3; i++) {
    			num[i] = second % 10;
    			second = second / 10;
    		}
    		
    		for(int i = 0; i < 3; i++) {
    			System.out.println( first * num[i] );
    			result = result + first * num[i] * (int)Math.pow(10,i);
    		}
    		
    		System.out.println(result);
    		
    }
}
