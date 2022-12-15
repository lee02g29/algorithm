import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		while(sc.hasNext()) {
    			String str = sc.nextLine();

    			if(str.equals("#")) {
    				break;
    			} else {
    				int count = 0;
    				for(int i = 0; i < str.length(); i++) {
    					if(str.charAt(i) == 'a' || str.charAt(i) == 'A' 
    							|| str.charAt(i) == 'e' || str.charAt(i) == 'E' 
    							|| str.charAt(i) == 'i' || str.charAt(i) == 'I' 
    							|| str.charAt(i) == 'o' || str.charAt(i) == 'O' 
    							|| str.charAt(i) == 'u' || str.charAt(i) == 'U') {
    						count++;
    					}
    				}
    				System.out.println(count);    				
    			}
    		}
    }
}
