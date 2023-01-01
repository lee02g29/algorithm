import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int test_case = sc.nextInt();
    		sc.nextLine();
    		
    		for(int t = 0; t < test_case; t++) {
    			String str = sc.nextLine();
    			int score = 0;
    			int sum = 0;
    			for(int i = 0; i < str.length(); i++) {  				   				
    				if(str.charAt(i) == 'O') {
    					score++;
    					sum = sum + score;
    				}
    				else if(str.charAt(i) == 'X') {
    					score = 0;
    				}
    			}
    			System.out.println(sum);
    		}
    				
    }
}
