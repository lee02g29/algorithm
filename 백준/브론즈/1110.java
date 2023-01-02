import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int num = sc.nextInt();
    		int cycle = 0;
    		int temp = num;
    		int one = 0;
    		int ten = 0;
    		int sum = 0;
    		
    		while(true) {
    		
    			one = temp % 10; // 일의 자리
	    		ten = temp / 10; // 십의 자리
	    			
	    		sum = one + ten;
	    		if(sum >= 10) sum = sum % 10; // 합의 가장 오른쪽 자리 수
	    		
	    		temp = one * 10 + sum;
	    		cycle++;
	    		
	    		if(temp == num) {
	    			System.out.println(cycle);
	    			break;
	    		}

    		}
    }
}
