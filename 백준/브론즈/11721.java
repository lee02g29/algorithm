import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		String str = sc.nextLine();
    		
    		for(int i = 1; i <= str.length(); i++) {
    			System.out.print(str.charAt(i-1));
    			if(i % 10 == 0 ) {
    				System.out.println();
    			}
    		}
    }
}
