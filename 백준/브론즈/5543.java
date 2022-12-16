import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int min1 = 2000;
    		int min2 = 2000;
    		for(int i = 0; i < 3; i++) {
    			int price = sc.nextInt();
    			if(price < min1) min1 = price;
    		}
    		for(int i = 0; i < 2; i++) {
    			int price = sc.nextInt();
    			if(price < min2) min2 = price;
    		}
    		System.out.println(min1 + min2 - 50);			
    }
}
