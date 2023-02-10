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
    	
    	int n = Integer.parseInt( bf.readLine() );
    	int sum = 0;
    	int bag = 0; // 설탕 봉지 수
    	
    	for(int i = 0; i <= n; i = i + 3) { // 0부터 시작하여 3kg씩 증가하는
    		sum = i // 현재 kg수, 3kg짜리부터 확인하기에 i값을 사용
    		bag = (i / 3); // 3kg 봉지수
    		
    		if( ( n - i ) % 5 == 0) { // 주어진 n kg에서 현재 kg수를 빼고, 그 값이 5(kg)로 나누어 떨어진다면
    			sum = n; // n kg에 도달할 수 있음
    			bag = bag + (n - i) / 5;	// 기존의 3kg 봉지수에 5kg 봉지수를 더하기
    			
    			bw.write( bag + "\n"); // 총 봉지수 출력
    			break; // 계산 종료
    		}   		
    	}
    	
    	if(sum != n) { // n kg에 도달할 수 없으면
			bw.write(-1 + "\n"); // -1을 출력
		}
		
    	bw.flush();
    	bw.close();
    }   
   
}
