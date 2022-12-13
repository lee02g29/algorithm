import java.util.*;

class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextInt()) {
        	int n = sc.nextInt();
        	int s = sc.nextInt();
        	
        	if(n == 0 && s == 0) {
        		break;
        	} else if(n > s){
        		System.out.println("Yes");
        	} else {
        		System.out.println("No");
        	}
        }       
    }
}
