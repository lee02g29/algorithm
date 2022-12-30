import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		while(true) {
    			String[] nums = sc.nextLine().split(" ");
    			int[] num = new int[3];
    			
    			for(int i = 0 ; i < 3; i++) {
    				num[i] = Integer.parseInt(nums[i]);
    			}
    			
    			
    			if( num[0] == 0 && num[1] == 0 && num[2] == 0) {
    				break;
    			}
    			
    			Arrays.sort(num);
    		
    			if(num[2] * num[2] == num[0] * num[0] + num[1] * num[1]) {
    				System.out.println("right");

    			} else {
    				System.out.println("wrong");
    			}
			
    		}
    }
}
