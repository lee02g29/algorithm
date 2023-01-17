import java.util.*;

class Main {
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int k = sc.nextInt();
    		int n = sc.nextInt();
    		
    		System.out.println( factorial(k) / ( factorial(n) * factorial(k - n) ) );  		
      // 이항계수 (n, r) = n! / ( r! * ( n - r )! )
      // 참고로 조합( nCr )도 같음 
    }   
    
    public static int factorial(int n) { // 팩토리얼 함수, 재귀함수로 했다가 스택오버플로우 났음
    	int ans = 1;
    	
    	for(int i = 1; i <= n; i++) {
    		ans = ans * i;
    	}
    	
    	return ans;
    }    
}
