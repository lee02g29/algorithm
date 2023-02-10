import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

/*
아무 생각없이 짠 코드이기에 매우 가독성이 나쁘고, 
풀이 과정이 난잡함을 미리 알아두시면 좋겠습니다.
깔끔한 코드는 다른 버전 코드를 보시기를 권장드립니다.
*/


class Main  {
    public static void main(String[] args) throws IOException{
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int n = Integer.parseInt( bf.readLine() );
    	int sum = 0; // 현재 담은 설탕 무무게
    	int five = 0; // 5키로 봉지수
    	int three = 0; // 3키로 봉지수
    	
    	while(true) {
    		
    		while(true) { // 5킬로부터 체크
	    		sum = sum + 5;
	    		five++;
	    		
	    		if(sum > n) { // 5키로를 계속 늘리다가, 넘어가면
	    			sum = sum - 5; // 그 전 값을 사용
	    			five--; // 봉지수도 같이 감소
	    			break;
	    		}
    		}
    		
    		while(true) {
    			if(sum == n) { // n키로를 맞췄으면
    				break; // 루프를 종료
    			} 
    			if(sum == 0 && (n % 3 != 0)) { // 5키로를 계속 줄이다가 현재 무게 합이 0이 되었는데, 그 값이 3으로 나누어 떨어지지 않으면
    				break; // n키로에 도달할 수 없음
    			}
    			
    			sum = sum + 3;
    			three++;
    			
    			if(sum > n) { // 3키로를 계속 더하다가 n키로를 넘으면
    				if(five == 0) { // 5키로를 이미 다 줄였다면
    					sum = sum - 3; // 3키로만 감소
        			three--;
    				} else if(five > 0) { // 줄일 수 있는 5키로가 남았다면
    					sum = sum - 8; // 3 + 5키로를 감소
    					three--;
    					five--;
					// 봉지수도 같이 감소
    				}  				
    			} 			
    		}
    		
    		if(sum == n) { // n키로를 맞췄으면
    			bw.write(five + three + "\n"); // 봉지수 출력
				  break;
			  } else { // 아니면 
				  bw.write(-1 + "\n"); // -1을 출력
				  break;
			  }
    	}
		
    	bw.flush();
    	bw.close();
    }   
   
}
