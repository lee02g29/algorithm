import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int n = sc.nextInt();
    		int min = 1000000;
    		int max = -1000000;
    		
    		for(int i = 0; i < n; i++) {
    			int num = sc.nextInt();
    			if(num > max) max = num;
    			if(num < min) min = num;
    		}
    		
    		System.out.println(min + " " + max);

    }
}
