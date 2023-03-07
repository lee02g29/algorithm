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
    	
    	int t = Integer.parseInt( bf.readLine() ); // 테스트 케이스의 개수
    	
    	for(int i = 0; i < t; i++) {
    		String[] str = bf.readLine().split(" "); 
    		int n = Integer.parseInt(str[0]); // 문서의 개수
    		int index = Integer.parseInt(str[1]); // 인쇄하고자 하는 문서가 현재 존재하는 곳(인덱스 값)
    		int count = 0; // 제거한 문서 수
    		
    		ArrayList<Integer> queue = new ArrayList<>(); // 문서가 들어온 순서 큐
    		ArrayList<Integer> prior = new ArrayList<>(); // 큐에 있는 우선순위를 내림차순으로 저장할 리스트
    		
    		str = bf.readLine().split(" ");
    		
    		for(int q = 0; q < n; q++) {
    			int temp = Integer.parseInt(str[q]);
    			queue.add(temp); // 큐에 N개의 문서를 순서대로 저장하기. 중요도가 입력됨
    			prior.add(temp); // 우선순위 리스트에도 저장하기 
    		}
    		
    		Collections.sort(prior, Collections.reverseOrder()); // 우선순위 리스트를 내림차순으로 정렬하기
    		    		
    		while(queue.size() > 0) { // 큐에 있는 문서가 모두 처리될 때까지 반복
    			if( queue.get(0) == prior.get(0) ) { 
            // 큐 맨 앞에 있는 문서의 중요도 = 우선순위 리스트 맨 앞의 중요도, 즉 큐에 있는 문서 중 중요도가 가장 높은 문서라면
    				int s = queue.remove(0); // 큐에서 그 문서를 제거하고
    				prior.remove(0); // 우선순위 리스트에서도 제거
    				count++; // 제거한 문서 수 증가
    				
    				if(index == 0) { // 제거한 문서가 우리가 알고 싶었던 문서라면,
    					bw.write(count + "\n"); // 제거한 문서수를 출력
    					break; // 더 이상 탐색할 필요가 없으므로 종료
    				} else {
    					index--; // 알고 싶었던 문서가 아니라면, 문서를 하나 제거하였으므로 인덱스 값을 하나 감소
    				}
    				
    			} else { // 큐 맨 앞에 있는 문서의 중요도 != 우선 순위 리스트 맨 낲의 중요도, 즉 큐에 있는 문서 중 중요도가 가장 높지 않은 문서인 경우
    				queue.add( queue.remove(0) );  // 그 문서를 다시 맨 뒤로 보내기
    				
    				if(index == 0) { // 그 값이 큐 맨 앞에 있는 경우라면
    					index = queue.size() - 1; // 인덱스 값을 맨 마지막 값으로 조정
    				} else {
    					index--; // 아니라면 인덱스 값 감소
    				}
    			} 			
    		}
		
    	}

    	bw.flush();
    	bw.close();
    }   
      	
}
