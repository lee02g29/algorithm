import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = bf.readLine().split(" ");
		int n = Integer.parseInt( str[0] );
		int w = Integer.parseInt( str[1] );
		int l = Integer.parseInt( str[2] );
		
		str = bf.readLine().split(" ");
		
		int total = 0; // 시간 초
		int sum = 0; // 다리 위 현재 무게
		
		Queue<Integer> in = new LinkedList<>(); // 대기중인 트럭 큐
		Queue<Integer> out = new LinkedList<>(); // 다리 위 큐
		
		for(int i = 0; i < n; i++) {
			in.add( Integer.parseInt( str[i] ) );
		}		
		
		for(int i = 0; i < n; i++) {
			
			while(true) { // 트럭이 다리 위에 올라갈 수 있을 때 까지반복
				if(out.size() == w) { 
          // 다리 위에 트럭 개수 + 0의 개수 = 다리 길이인 경우
					sum -= out.peek();
					out.poll();				
          // 다리 맨 앞에 있는 것을 제거
          // 그리고 무게도 줄이기
				}
				
				if(sum + in.peek() <= l) break; 
        // 다음 트럭이 올라가도 최대 하중 이하라면 반복문 종료 -> 트럭 올리러
				out.add(0); // 0을 넣기
				total++; // 단위시간 1 증가
        // 다음 트럭이 오를 수 없을 때 수행함
			}
      
			// 다음 트럭 올리기
			sum += in.peek(); // 트럭 무게 증가
			out.add(in.poll()); // 대기중인 트럭 올리기
			total++;	// 단위시간 1 증가
      
		}
		
		bw.write( ( total + w ) + "\n"); 
    // 마지막 트럭이 다리 위에 오르고 끝나기 때문에 다리 길이만큼 시간을 증가시키기
		
		bw.flush();
		bw.close();
	}
}
