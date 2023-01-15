import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int mult = 1;
    		int min = (a >= b) ? b : a;
    		boolean roof = true;
    		
    		while( roof ) {
    			if(min == 1) {
					roof = false;
					break;
				}
    			
    			for(int i = 2; i <= min; i++) {
    				if(a % i == 0 && b % i == 0) {					
    					mult = mult * i;
    					a = a / i; 
    					b = b / i;
    					min = (a >= b) ? b : a;
    					break;
    				}   
    				
    				if(i == min) {
    					roof = false;
    					break;
    				}
    			}  			
    		} 		
    		
    		System.out.println(mult);
    		System.out.println(mult * a * b);
    }   		
}
