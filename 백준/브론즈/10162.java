import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);

    		int[] button = {300, 60, 10};
    		int[] count = new int[3];
    		int sum = 0;
    		int time = sc.nextInt();
    		
    		if(time % 10 != 0) {
    			System.out.println(-1);
    		}
    		else {
    			for(int i = 0; i < 3; i++) {
        			while(true) {
        				count[i]++;
        				int temp = sum + button[i] * count[i];
        				
        				if(temp > time) {
        					count[i]--;
        					sum = sum + button[i] * count[i];
        					break;
        				}

        			}
        		}
    			
    			for(int i = 0; i < 3; i++) {
    				System.out.print(count[i] + " ");
    			}
    			
    		
    		}
    		
		
    }
}
