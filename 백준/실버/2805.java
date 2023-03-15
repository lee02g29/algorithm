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
    	
    	int n = Integer.parseInt( str[0] ); // 숫자의 개수
    	int m = Integer.parseInt( str[1] ); // 가져가려는 나무의 길이
    	
    	str = bf.readLine().split(" "); 
    	ArrayList<Integer> tree = new ArrayList<>(); // 나무들의 높이를 저장할 리스트
    	
    	long max = 0L; // 나무들 중 최고 높이
    	
    	for(int i = 0; i < n; i++) {
    		int temp = Integer.parseInt( str[i] ); 
    		tree.add( temp ); // 나무의 높이를 저장
    		if(max < temp) max = temp; // 최대 높이 찾기
    	}
    	
      // 이분탐색을 통하여 값을 찾을 것
    	long left = 0L; // 범위의 왼쪽 끝
    	long right = max; // 범위의 오른쪽 끝
    	long ans = 0; // 찾으려는 높이
    	
    	while(left <= right) { // 왼쪽이 오른쪽을 넘어서는 값을 가지지 않는다면 반복
    		
    		long mid = ( left + right ) / 2; // 중간값
    		long sum = 0L; // 자른 나무 길이의 합을 저장할 변수
    		
    		for(int i = 0; i < n; i++) { 
    			if(tree.get(i) > mid) { // 중간값보다 작다면 잘리지 않는다. = 중간값보다 큰 나무들만 자른다
    				sum = sum + (tree.get(i) - mid); // 잘린 길이를 합하여 저장
    			}
    		}
 	
    		if(sum >= m) { // 자른 길이의 합이 m보다 크다면
    			left = mid + 1; // 중간 값 이후의 숫자들만 확인
    		} else if(sum < m) { // 작다면
    			right = mid - 1; // 중간값 이전의 값들만 확인
    		} 
    		
    		if(sum >= m && mid > ans) ans = mid; // 자른 길이의 합이 m보다 크고, 이전 높이보다 크면 답을 현재 중간 값으로 갱신
        
        // 주의사항 : 합이 m과 같은 경우가 없을 수도 있다. 
        // 또한, 합이 m보다 크기만 하다면 더 탐색하여 잘라야할 높이의 최적값을 찾아야 한다. 중간에 탐색을 멈추지 말 것
    		
    	}
    	
    	bw.write(ans + "\n"); // 찾은 최고 높이를 출력할 것
    	
    	bw.flush();
    	bw.close();
    }   
      	
}
