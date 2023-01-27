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
    	int[] prime = new int[1001]; // 소수체크용 배열
    	
    	String[] str = bf.readLine().split(" "); // 숫자 입력받기
    	int[] num = new int[n]; // 입력받은 숫자를 저장할 배열
    	int count = 0; // 개수 체크
    	
    	for(int i = 0; i < n; i++) {
    		num[i] = Integer.parseInt( str[i] );
    	}
    	
    	for(int i = 2; i <= 1000; i++) {
    		prime[i] = 1; 
    		// 2~1000까지는 소수의 후보이므로 1, 0과 1은 소수가 아니므로 1로 바꾸지 않음
    	}
    	
    	for(int i = 2 ; i * i <= 1000; i++) {
    		for(int j = i * i; j <= 1000; j = j + i) {
    			prime[j] = 0;
    		}
    	}
    	// 에라토스테네스의 체를 이용하여 1000까지의 소수를 미리 구하기
    	
    	for(int i = 0; i < n; i++) {
    		if(prime[ num[i] ] == 1) {
    			count++;
    		}
    		// 입력받은 수 중 소수가 있는지 체크
    		// 있으면 개수를 증가
    	}
    	
    	bw.write(count + "\n");
    	// 소수의 개수 출력

    	bw.flush();
    	bw.close();
    }   
}
