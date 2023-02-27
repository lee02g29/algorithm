import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

class Main  {
    public static void main(String[] args) throws IOException{
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String[] str = bf.readLine().split(" ");
    	int n = Integer.parseInt( str[0] );
    	int m = Integer.parseInt( str[1] );
    	
    	
    	String[][] chess = new String[n][m];
    	
    	for(int i = 0 ; i < n; i++) {
    		str = bf.readLine().split("");    		
    		for(int j = 0; j < m; j++) {
    			chess[i][j] = str[j]; 			
    		}   		
    	} // 보드판 입력하기
    	
    	int min = 64; // 바꿔야할 정사각형 최소 개수, 체스판은 64칸이기에 64를 초기치로
    	
    	for(int i = 0; i < n - 8 + 1; i++) {
    		for(int j = 0; j < m - 8 + 1; j++) { 
          // 8 * 8을 탐색하기 위한 기준점을 고르는 반복문. 기준점에서 8칸까지 탐색하므로, 경계를 넘지 않도록 범위를 조정하기
    			int count = 0; // 바꿔야할 정사각형 개수

    			for(int k = 0; k < 8; k++) {	
    				String block = "";
    				for(int l = 0; l < 8; l++) { // 기준점에서 8 * 8 탐사하기		
              // *왼쪽 위가 흰색일 때를 기준으로 함
    					if( k % 2 == 0 ) { // 행의 인덱스 값이 짝수
    						if( l % 2 == 0 ) { // 열의 인덱스 값이 작수
    							block = "W";
    						} else {
    							block = "B";
    						} // 행의 인덱스 값이 짝수일 때, 행과 열의 합이 짝수이면 W, 홀수이면 B여야 함
    					} else {
    						if( l % 2 == 0 ) {
    							block = "B";
    						} else {
    							block = "W";
    						}
    					}  // 행의 인덱스 값이 홀수일 때, 행과 열의 합이 짝수이면 W, 홀수이면 B여야 함				
    					if(!chess[i + k][j + l].equals(block)) {
    						count++;
    					}
    				}
    			} 
    			if(count > 32) count = 64 - count; 
          // 바꿔야할 개수가 32개가 넘는다면, 지금보다 왼쪽 위가 검은색일 때, 더 최소의 개수를 가진다.
          // 따라서 64에서 바꿔야할 개수를 뺀다. 
          // 그 값은 왼쪽 위가 검은 색일 때를 기준으로 했을 경우, 바꿔야할 정사각형의 개수와 같다.
          
    			if(count < min) min = count;
          // 최소치 갱신
    		}
    	}    	    	
    	
    	bw.write(min + "\n");
    	
    	bw.flush();
    	bw.close();
    }   
      	
}
