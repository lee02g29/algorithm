import java.util.*;

class Main {
	
	static int[][] pop = new int [15][15];
	// 계산 결과 저장 배열. 입력 값은 14까지지만, 0층도 포함하기에 15까지로 두었다.
			
    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		int test_case = sc.nextInt();   		
    		
    		for(int t = 0; t < test_case; t++) {
    			int k = sc.nextInt();
    			int n = sc.nextInt();	
    			int ans = people(k, n);
    			
    			System.out.println(ans);
    		}
    }   	
    
    // 동적 프로그래밍, 하향식 방법
    public static int people(int k, int n) {   	
    	if(pop[k][n] != 0) return pop[k][n];   	
    	// 결과가 이미 있다면 새로 계산하지 않고 저장된 값 주기
    	// 메모이제이션. 값을 저장해두지 않으면 같은 값을 여러번 계산해야해서 굉장히 느려질 수 있다.
    	else {
	    	if(k == 0) pop[k][n] = n; // 0층 값들
	    	else if(n == 1) pop[k][n] = 1; // k층의 1번방은 모두 1명이다.
	    	else {
	    		pop[k][n] = people(k, n - 1) + people(k - 1, n);
	    		// k층 n번방의 인원은 k-1층 n번방 인원 + k층 n-1번방 인원
	    		// 파스칼의 삼각형을 생각해보기
	
	    	}
	    	return pop[k][n];
    	}
    }
    
}
