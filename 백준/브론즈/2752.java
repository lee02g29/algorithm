import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);

    		int[] temp = new int[3];
    		
    		for(int i = 0; i < 3; i++) {
    			int x = sc.nextInt();
    			temp[i] = x;
    		}
  	
    		Arrays.sort(temp);
    		
    		for(int i = 0; i < 3; i++) {
    			System.out.print(temp[i] + " ");
    		}	
    }
}
