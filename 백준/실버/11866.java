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
    	int n = Integer.parseInt( str[0] ); // n명의 사람
    	int k = Integer.parseInt( str[1] ); // k번째 사람
    	int count = 0; // k번째 사람인지 확인하기 위한 변수
    	Queue<Integer> people = new LinkedList<>(); // 큐 선언
    	int[] order = new int[n]; // 제거된 사람 순서를 저장할 배열
    	int cur = 0; // 제거된 사람 순서 배열에 저장된 인원
    	
    	for(int i = 1; i <= n; i++) {
    		people.add(i);
    	}
    	
    	while(!people.isEmpty()) {
    		int num = people.remove();
    		count++; // 체크한 사람 수 증가
    		
    		if(count == k) { // k번째 사람이면
    			order[cur] = num; // order배열에 저장
    			count = 0; // 체크한 사람수를 초기화
    			cur++; // 인원수를 증가시킨다
    		} else { // k번쨰 사람이 아니면
    			people.add(num); // 큐 뒤에 다시 넣기
    		}
    	}
      // 접근 방식 : 큐의 앞에서 숫자를 먼저 제거. 
      // 그 후 그 숫자가 k번째 숫자라면 order 배열에 저장
      // k번째 숫자가 아니라면 다시 큐 뒤에 넣기
      // 이 과정을 큐에 남은 것이 없을 때까지 반복하기
    	
    	bw.write("<"); // 앞 괄호
    	for(int i = 0; i < n; i++) {
    		if(i == n - 1) bw.write(order[i] + ""); // 마지막 숫자에는 ','가 필요가 없으므로 따로 출력
    		else bw.write(order[i] + ", ");   		
    	}
    	bw.write(">"); // 뒤 괄호
    	bw.flush();
    	bw.close();
    }   
}
