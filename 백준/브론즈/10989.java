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
        // 속도가 빠른 BufferedReade와 BufferedWriter를 이용하기
    	
    	int n = Integer.parseInt( bf.readLine() );
    	int[] count = new int[10001]; 
    	
    	for(int i = 0; i < n; i++) {
    		int num = Integer.parseInt( bf.readLine() );
    		count[num]++;
    	}
        // 입력받는 숫자의 수는 많지만 숫자의 범위는 작기에, 각 숫자가 몇 번 나왔는지만 저장하기(Counting sort의 원리를 활용)
        // 입력받는 숫자를 모두 저장하면, 메모리 초과가 날 것        
    	
    	for(int i = 0 ; i < 10001; i++) {
    		if(count[i] != 0) {
    			for(int j = 0; j < count[i]; j++) { // 나온 횟수만큼 숫자를 출력하기
    				bw.write( i + "\n" );
                    // BufferedWriter는 자동개행을 해주지 않음
    			}
    		}	
    	}  		
    	bw.flush();
    	bw.close();
        // 버퍼를 잡고 있기에 사용 후 뒤처리 하기
    }   
}
