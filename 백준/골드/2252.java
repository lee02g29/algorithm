import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");
		
		int n = Integer.parseInt( str[0] ); // 사람수
		int m = Integer.parseInt( str[1] ); // 키 잰 횟수
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    // 키 잰 상태
		int[] in = new int[n + 1];
    // 진입차수
		
		Queue<Integer> queue = new LinkedList<>();
    // 큐
		
		for(int i = 0; i <= n; i++) {
			arr.add( new ArrayList<>());
		} // 키 잰 상태 입력받기
		
		for(int i = 0; i < m; i++) {
			str = bf.readLine().split(" ");
			
			int a = Integer.parseInt( str[0] );
			int b = Integer.parseInt( str[1] );
      // 사람 a와 b
      // 키 : a < b
			
			arr.get(a).add(b);
      // a의 그래프는 b를 향한다
			in[b]++;
      // b의 진입 차수 증가
		}

		for(int i = 1; i <= n; i++) {
			if(in[i] == 0) queue.offer(i); 
        // 진입차수 0인 사람 미리 큐에 넣기
		}
		
		while(!queue.isEmpty()) {
			int from = queue.peek();
			queue.poll();
      // 큐에 있는 첫번째 값 보기
			
			bw.write(from + " ");
      // 첫번째 값 출력하기
			
			for(int i = 0; i < arr.get(from).size(); i++) {
        // 첫번째 사람에 연결된 사람들 보기
				int temp = arr.get(from).get(i);
				
				in[temp]--;
        // 연결된 사람의 진입차수 -1하기
				
				if(in[temp] == 0) queue.offer(temp);
        // 진입차수 0되면 큐에 넣기
			}
			
		}

		bw.flush();
		bw.close();

	}

}
