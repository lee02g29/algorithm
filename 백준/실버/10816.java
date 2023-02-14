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
    	ArrayList<Integer> nums = new ArrayList<>(); // 주의사항 frequecy 함수를 쓰면 시간 초과가 발생함
    	String[] str = bf.readLine().split(" ");
    	
    	for(int i = 0; i < n; i++) {
    		int temp = Integer.parseInt( str[i] );
    		nums.add(temp);
    	} // 가지고 있는 카드의 값을 저장
    	
    	Collections.sort(nums);
      // lowerbound와 upperbound를 사용하기 위해서는, 리스트가 정렬되어 있어야 함
    	
    	n =  Integer.parseInt( bf.readLine() );
      // m개의 정수
    	
    	str = bf.readLine().split(" "); 
    	
    	for(int i = 0; i < n; i++) {
    		int temp = Integer.parseInt( str[i] ); // m개의 정수 값들
    		int count = upper_bound(nums, temp) - lower_bound(nums, temp);
        
        // upperbound는 특정 값보다 큰, 첫번째 원소의 인덱스를 반환한다
        // lowerbound는 특정 값보다 크거나 같은, 첫번째 원소의 인덱스를 반환한다.
        // 둘의 차이는 upperbound는 같은 경우를 체크하지 않고, lowerbound는 같은 경우를 체크한다.
        // upperbound의 값에서 lowerbound의 값을 빼면, 특정 값(비교하려는 숫자)와 같은 숫자가 몇 개인지가 알 수 있다.
        // 즉, upperbound의 값 - lowerbound의 값 = 중복값 개수, 라고 할 수 있다.
        
    		
    		bw.write(count + " ");
    	}
    	
    	bw.flush();
    	bw.close();
    }   
    
    public static int lower_bound (ArrayList<Integer> a, int data) {
      // lowerbound는 특정 값보다 크거나 같은 첫번째 원소의 인덱스를 반환
    	int start = 0;
    	int end = a.size();
    	
    	while(start < end) {
    		int mid = (start + end) / 2; // 중간 값
    		if(a.get(mid) >= data) { // data의 값이 중간 값보다 크거나 같다면
    			end = mid; // 중간 값 이후의 값은 필요가 없으므로.  mid의 값이 end의 새로운 값이 된다
    		} else {
    			start = mid + 1; // 작다면 이전의 값은 필요가 없으므로, mid + 1 값이 start의 새로운 값이 된다
    		}
    	}
    	// 이분 탐색 방법을 사용하여 찾는다
      
    	return end;
    }
    
    public static int upper_bound (ArrayList<Integer> a, int data) {
      // upperbound는 특정 값보다 큰 첫번째 원소의 인덱스를 반환
    	int start = 0;
    	int end = a.size();
    	
    	while(start < end) {
    		int mid = (start + end) / 2;
    		if(a.get(mid) <= data) { // data 값이 중간 값보다 작거나 같다면
    			start = mid + 1; // 이전 값은 필요가 없으므로, mid + 1 값이 start의 새로운 값이 된다
    		} else {
    			end = mid; // 크다면 이후 값은 필요가 없으므로, mid의 값이 end의 새로운 값이 된다
    		}
    	}
      // 이분 탐색 방법을 사용하여 찾는다
    	
    	return end;
    }
      	
}
