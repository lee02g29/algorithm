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
    	
    	ArrayList<Integer> nums = new ArrayList<>(); // 숫자 리스트
    	ArrayList<Integer> fres = new ArrayList<>(); // 최고 빈도수의 숫자들이 담길 리스트
    	int[] count = new int[8001]; // -4000 ~ 4000의 범위, 해당 숫자가 들어왔을 때 빈도수 체크할 배열
    	int cnt = 0; // 최대 빈도수를 저장할 변수
    	
    	int sum = 0; // 입력받은 숫자들의 합, 
    	
    	for(int i = 0; i < n; i++) {
    		int m = Integer.parseInt( bf.readLine() ); // 숫자 입력받기
    		sum = sum + m; // 숫자들의 합 구하기
    		count[m + 4000]++; 
        // 인덱스의 값은 0부터 시작이지만, 숫자의 범위가 -4000부터이기 때문에, 4000을 더하여 0으로 맞춰주기
    		nums.add(m);
    	}
    	
    	Collections.sort(nums); // 오름차순으로 정렬
	
    	for(int i = 0; i < n; i++) {
        // 빈도수만 탐색함
    		int temp = nums.get(i); // 빈도수를 체크할 숫자, 입력받은 숫자들만 탐색하여 시간을 줄이기
  		
    		if( count[temp + 4000] > cnt ) { // 새로운 숫자의 빈도수가 저장된 최대 빈도수보다 크다면
    			cnt = count[temp + 4000]; // 최대 빈도수를 갱신
    			fres.clear(); // 이전에 저장된 최대 빈도수를 가진 숫자를 전부 제거
    			fres.add(temp); // 최대 빈도수를 가진 이번 숫자를 저장
    		} else if( count[temp + 4000] == cnt && !fres.contains( temp )) { 
          // 만약 빈도수가 같은 숫자가 있다면, 그리고 그 숫자가 리스트에 없다면
    			fres.add(temp); // 그 값도 저장
    		}
    		
    	}
    	
    	Collections.sort(fres); // 오름차순으로 정렬 -> 빈도수가 같은 숫자가 여럿 있다면 두번째로 작은 숫자를 찾아야하기 때문
    	
    	double aver = sum / (double) n; // 평균 값을 구하기. sum과 n이 모두 int이기에 어느한쪽을 double로 바꾸기
    	int cen = nums.get( (1 + n) / 2 - 1); // 중간 값 찾기, n은 홀수이기에 0.5값이 나오는 일이 없음. 또한 인덱스는 0부터이기에 1을 빼줌
    	int freq = 0; // 최대 빈도수를 가진 숫자
    	
    	if(fres.size() == 1) { // 최대 빈도수인 숫자가 하나라면
    		freq = fres.get(0); // 그 숫자를 사용.
    	} else if( fres.size() > 1) { // 최대 빈도수인 숫자가 여러개라면(2개 이상이라면)
    		freq = fres.get( 1 ); // 두번째로 작은 숫자를 사용(0번째 값은 제일 작은 값)
    	}
    	
    	int range = nums.get( nums.size() - 1 ) - nums.get(0); // 마지막 값에서 맨 앞 값 빼기 = 제일 큰 값에서 제일 작은 값 빼기
    	
    	String result = String.format("%.0f", aver); // 평균값을 첫째자리에서 반올림, 주의 : 문자열임
    	if(result.equals("-0")) result = "0"; 
      // 평균값이 -1 ~ 0인경우( -1, 0 미포함) , String.format을 사용하여 반올림을 하면 -0으로 출력되기 때문에, 그 일을 방지하고자 함
    	
    	bw.write(result + "\n"); // 평균값
    	bw.write(cen + "\n"); // 중간값
    	bw.write(freq + "\n"); // 최대빈도수 숫자
    	bw.write(range + "\n"); // 값 범위

    	bw.flush();
    	bw.close();
    }   
      	
}
