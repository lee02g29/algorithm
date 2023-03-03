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
    	
    	String[] str = bf.readLine().split(" "); 
    	int[] list = new int[n]; // 주어진 수의 개수
    	
    	for(int i = 0; i < n; i++) {
    		list[i] = Integer.parseInt(str[i]); // 주어진 수 배열
    	}
    	
    	int m = Integer.parseInt( bf.readLine() ); 
    	
    	str = bf.readLine().split(" ");
    	int[] find = new int[m]; // 찾아야하는 수의 개수
    	
    	for(int i = 0; i < m; i++) {
    		find[i] = Integer.parseInt(str[i]); // 찾아야하는 수 배열
    	}
    	
    	Arrays.sort(list);
    	
    	for(int i = 0; i < m; i++) { // 찾아야 하는 수들을 하나씩 찾기
    		if( binarySearch(list, find[i]) ) { // 이진 탐색의 결과가 true라면
    			bw.write( 1 + "\n"); // 1을 출력
    		} else { // 결과가 false라면
    			bw.write( 0 + "\n"); // 0을 출력
    		}
    	}

    	bw.flush();
    	bw.close();
    }   
    
    public static boolean binarySearch(int[] list, int x) { // 이진탐색, 주어진 수의 배열과 찾을 수를 매개변수로 받음
    	int start = 0;
    	int end = list.length - 1;
      // 탐색 범위값
    	
    	while(start <= end) {
    		
    		int mid = (start + end) / 2; // 중간값 설정
    		
    		if(list[mid] == x) { // 중간값이 찾고자 하는 값과 같다면
    			return true; // true를 반환
    		} else if(list[mid] > x) { // 중간값이 찾고자 하는 값보다 크다면
    			end = mid - 1; // 중간값 이전의 값들만 사용 -> end값을 중간값 -1로
    		} else { // 중간값이 찾고자 하는 값보다 작다면
    			start = mid + 1; // 중간값 이후의 값만 사용 -> start 값을 중간값 + 1로
    		}
    	}
    	
    	return false; // 모두 탐색하였지만, 찾으려는 값이 없었으면 false를 반환
    	
    }
      	
}
