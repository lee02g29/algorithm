import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int[] car = new int[5];
    		int count = 0;
    		
    		int day = sc.nextInt();
    		sc.nextLine();
    		String[] str = sc.nextLine().split(" ");
    		
    		
    		for(int i = 0; i < 5; i++) {
    			car[i] = Integer.parseInt(str[i]);
    		}
    		
    		for(int i = 0; i < 5; i++) {
    			if(day == car[i]) count++;
    		}
    		
    		System.out.println(count);
    }
}
