import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
  // 4방 탐색용

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]); // 수빈이의 지점
		int k = Integer.parseInt(str[1]); // 동생의 지점

		Queue<Integer> queue = new LinkedList<>(); // 큐
		int visit[] = new int[100010]; 
    // 방문 여부 체크용이자, 최단 시간 체크용

		int cnt = 0;

		queue.add(n);
		visit[n] = 1;
		// 수빈이의 지점부터 시작하기
    
		while (!queue.isEmpty()) {

			int cur = queue.peek();
			queue.remove();

			if(visit[k] > 0 && visit[cur] >= visit[k]) break;  
      // 도착지점에 이미 방문했거나, 현재 지점의 방문 시간이 최단시간보다 긴 경우
      // 확인 안해도 됨

      // cur * 2 체크
			if (cur * 2 <= 100000 && (visit[cur * 2] == visit[cur] + 1 || visit[cur * 2] == 0)) {
        // 100000을 넘어가지 않고, 
        // cur * 2에 방문하지 않았거나, 현재 지점의 방문 시간 + 1과 같으면, 
				queue.add(cur * 2);
				visit[cur * 2] = visit[cur] + 1;
        // 큐에 넣고 최단 시간처리
				if (cur * 2 == k) // 동생이 있는 지점이라면 
					cnt++; // 카운트 체크
			}

      // cur + 1 체크
			if (cur + 1 <= 100000 && (visit[cur + 1] == visit[cur] + 1 || visit[cur + 1] == 0)) {
				queue.add(cur + 1);
				visit[cur + 1] = visit[cur] + 1;

				if (cur + 1 == k)
					cnt++;
			}

      // cur - 1 체크
			if (cur - 1 >= 0 && (visit[cur - 1] == visit[cur] + 1 || visit[cur - 1] == 0)) {
				queue.add(cur - 1);
				visit[cur - 1] = visit[cur] + 1;

				if (cur - 1 == k)
					cnt++;
			}

		}
		
		bw.write((visit[k] - 1) + "\n"); // 결과 출력
		
		if(n == k) bw.write(1 + "\n"); // 둘이 지점이 같으면 
		else bw.write(cnt + "\n"); // 아니면

		bw.flush();
		bw.close();
	}

}
