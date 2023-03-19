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
    	
    	int k = Integer.parseInt( str[0] ); // 이미 가지고 있는 랜선의 개수
    	int n = Integer.parseInt( str[1] ); // 필요한 랜선의 개수
    	
    	ArrayList<Integer> line = new ArrayList<>(); // 랜선의 길이를 저장할 리스트
    	
    	long max = 0L; // 길이가 가장 긴 랜선을 저장할 변수
    	
    	for(int i = 0; i < k; i++) { // 길이를 모두 저장
    		int temp = Integer.parseInt( bf.readLine() );
    		line.add( temp );
    		if(max < temp) max = temp; // 최대값 갱신
    	}
    	
      // 이진 탐색의 범위는 1~max(가장 긴 길이)까지
      // left의 값이 0이면 런타임 에러 발생함 주의
      // int로 하면 합이 int의 범위를 넘어설 수 있기 때문에 long
    	long left = 1L;  
    	long right = max; 
    	long ans = 0L; // 답 = 최대 랜선의 길이
    	
    	while(left <= right) { // 이진탐색
    		
    		long mid = ( left + right ) / 2; // 중간 값
    		long sum = 0L; // 자른 랜선의 개수의 합
    		
    		for(int i = 0; i < k; i++) { // 랜선들을 탐색
    			sum = sum + (line.get(i) / mid); 
          // 길이를 중간값으로 나눈 몫을 합하기. 문제 조건에 의하여 나머지는 필요없음
    		}
 	
    		if(sum >= n) { // 현재 랜선의 개수가 필요한 랜선의 개수보다 많다면
    			left = mid + 1; // 현재 중간 값 이후를 탐색
    		} else if(sum < n) { // 현재 랜선의 개수가 필요한 랜선의 개수보다 적다면
    			right = mid - 1; // 현재 중간 값 이전의 값을 탐색
    		} 
    		
    		if(sum >= n && mid > ans) ans = mid; // 현재 랜선의 개수가 n 이상이고, 중간값이 현재 저장된 답보다 크다면 갱신
        // 조건에 의하여 현재 랜선의 개수는 n개를 넘어도 괜찮음
        // 딱 n개여도 최적값이 있을 수 있으므로 계속 탐색함
    		
    	}
    	
    	bw.write(ans + "\n");
    	
    	bw.flush();
    	bw.close();
    }   
      	
}
