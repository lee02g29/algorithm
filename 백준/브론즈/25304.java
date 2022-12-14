import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int sum = 0;
        	int total = sc.nextInt();
        	int n = sc.nextInt();
        	
        	for(int i = 0; i < n ; i++) {
        		int money = sc.nextInt();
        		int count = sc.nextInt();
        		sum = sum + money * count;
        	}

        	if(total == sum) {
        		System.out.println("Yes");
        	} else {
        		System.out.println("No");
        	}
    }
}
