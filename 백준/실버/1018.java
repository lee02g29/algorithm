import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 

/*
떠오르는데로 짠 코드이기에, 
코드가 매우 길고 이상합니다.
더 좋은 방법이 존재하니 참고만 해주세요.
*/

class Main  {
    public static void main(String[] args) throws IOException{
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String[] str = bf.readLine().split(" ");
    	int n = Integer.parseInt( str[0] );
    	int m = Integer.parseInt( str[1] );    	
    	
    	String[][] chess = new String[n][m]; // 입력 보드판
    	
    	for(int i = 0 ; i < n; i++) {
    		str = bf.readLine().split("");    		
    		for(int j = 0; j < m; j++) {
    			chess[i][j] = str[j]; 			
    		}   		
    	} // 입력받은 보드 저장하기
    	
    	String[] black = new String[m];
    	String[] white = new String[m];
      // 정상적 체스판 배열, 앞에서부터 볼 때
      // 검은색으로 시작할 때, 하얀색으로 시작할 때
    	
    	for(int i = 0; i < m; i++) {
    		if(i % 2 == 0) {
    			black[i] = "B";
    			white[i] = "W";
    		} else {
    			black[i] = "W";
    			white[i] = "B";
    		}
    	} // 정상적으로 색칠된 체스판의 경우를 저장하기
      
    	int min = m * n + 1; // 다시 칠해야할 정사각형의 최소 개수
    	
      // 앞에서부터 체크하기
    	for(int i = 0; i < n - 8 + 1; i++) {
    		for(int j = 0; j < m - 8 + 1; j++) { // 시작 지점 고르기
    			String first = chess[i][j]; // 가장 왼쪽 위 정사각형의 색
    			int count = 0; // 다시 칠해야할 정사각형의 개수

    			for(int k = 0; k < 8 && i + k < n; k++) {
    				int index = 0;
    				for(int l = 0; l < 8 && j + l < m; l++) { // 시작지점부터 8 * 8 탐색하기
    					if(first.equals("B")) { // 가장 왼쪽 위 정사각형 색이 B라면, 
    						if(k % 2 == 0) { // 홀수번째 줄은 black 배열 쓰기
        						if( chess[k + i][l + j].equals(black[index++]) ) { // 현재 색이 올바른 색이라면
        							continue; // 아무 것도 하지 않고 넘김
        						} else { // 올바르지 않다면
        							count++; // 개수 증가
        						}
        					} else {  // 짝수번째 줄은 white 배열 쓰기
        						if( chess[k + i][l + j].equals(white[index++]) ) {
        							continue;
        						} else {
        							count++;
        						}
        					}
    					} else if(first.equals("W")) { / 가장 왼쪽 위 정사각형 색이 W라면
    						if(k % 2 == 0) { // 홀수번째 줄은 white 배열 쓰기
        						if( chess[k + i][l + j].equals(white[index++]) ) {
        							continue;
        						} else {
        							count++;
        						}
        					} else {  // 짝수번째 줄은 black 배열 쓰기
        						if( chess[k + i][l + j].equals(black[index++]) ) {
        							continue;
        						} else {
        							count++;
        						}
        					}
    					}
    				}
    			}    		
    			if(count < min) min = count; // 최소치 갱신
    		}
    	}
    	
      // 뒤에서부터 체크하기
    	for(int i = 0; i < n - 8 + 1; i++) {
    		for(int j = 0; j < m - 8 + 1; j++) {
    			String first = chess[i][j];
    			int count = 0;
    			
    			for(int k = 0; k < 8 && i + k < n; k++) {
    				int index = 0;
    				for(int l = 7; l >= 0 && j + l < m; l--) { // 다른 곳은 이 부분, 앞이 아니라 뒤에서부터 체크하는 방법.
              // 체스판의 탐색 순서를 역으로, 정상적인 경우의 배열을 앞에서부터 탐색하면
              // 반대의 경우를 체크할 수 있음
              // 이 외에는 동일
    					if(first.equals("B")) {
    						if(k % 2 == 0) {
        						if( chess[k + i][l + j].equals(black[index++]) ) {
        							continue;
        						} else {
        							count++;
        						}
        					} else {
        						if( chess[k + i][l + j].equals(white[index++]) ) {
        							continue;
        						} else {
        							count++;
        						}
        					}
    					} else if(first.equals("W")) {
    						if(k % 2 == 0) {
        						if( chess[k + i][l + j].equals(white[index++]) ) {
        							continue;
        						} else {
        							count++;
        						}
        					} else {
        						if( chess[k + i][l + j].equals(black[index++]) ) {
        							continue;
        						} else {
        							count++;
        						}
        					}
    					}
    						
    				}
    			}    		
    			if(count < min) min = count; // 최소치 갱신
    		}
    	}
    	
    	
    	bw.write(min + "\n");
    	
    	bw.flush();
    	bw.close();
    }   
      	
}
