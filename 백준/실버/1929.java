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
    	
    	int m = Integer.parseInt( str[0] ); 
    	int n = Integer.parseInt( str[1] ); 
      // 찾으려는 범위는 m부터 n까지의 수
    	
    	int[] prime = new int[n + 1];
      // 소수인지를 저장할 배열. 0 ~ n까지의 수
    	
    	for(int i = 2; i <= n; i++) {
    		prime[i] = 1; // 2 ~ n을 일단 소수라고 생각하기, 0과 1은 소수가 아님
    	}
    	
    	for(int i = 2; i * i <= n; i++) { // 2부터 n까지 확인하되, 범위는 n의 제곱수까지만 체크.
    		for(int j = i * i; j <= n; j = j + i) { // i * i부터 시작해서, i의 배수들을 모두 탐색
    			prime[j] = 0; // 그리고 탐색한 숫자들은 소수가 아님. 
    		}
    	}
    	
    	for(int i = m; i <= n; i++) { // m부터 n까지의 숫자들 중
    		if(prime[i] == 1) bw.write(i + "\n"); // 소수가 있다면 출력
    	}

    	bw.flush();
    	bw.close();
    }   
      	
}
