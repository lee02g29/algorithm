import java.util.*;
import java.io.*;

class Main {
	public static int[] par;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] prime = new boolean[10001];

		for (int i = 2; i <= 10000; i++) {
			prime[i] = true;
		}

		for (int i = 2; i * i <= 10000; i++) {
			for (int j = i * i; j <= 10000; j = j + i) {
				prime[j] = false;
			}
		} 

    // 숫자가 적으므로 미리 소수를 구해놓기

		int test = Integer.parseInt(bf.readLine());

		for (int t = 0; t < test; t++) {
			String[] str = bf.readLine().split(" ");

			boolean[] visit = new boolean[10001];
      // 방문여부
			int[] len = new int[10001];
      // 단계
			Queue<Integer> queue = new LinkedList<>();
      // bfs용 큐

			int s = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
      // 시작 숫자와 마지막 숫자
      
			queue.add(s);
			visit[s] = true;
      // 시작 숫자를 큐에 넣고 탐색 시작
      // 시작 숫자 방문 처리
      
			while (!queue.isEmpty()) {
        // 큐가 다 빌 때까지 
				int num = queue.poll();
        // 숫자 꺼내오기
				for (int i = 0; i < 4; i++) {
          // 바꾸고자하는 자리
					for (int j = 0; j <= 9; j++) {
          // 새로운 숫자
						if (i == 0 && j == 0) 
              // 맨 앞은 0으로 못씀
							continue;

						int temp = change(num, i, j);
            // 특정 위치의 숫자 바꾸기
						if (prime[temp] && !visit[temp]) {
              // 소수고 방문한적도 없음
							queue.add(temp);
							visit[temp] = true;
							len[temp] = len[num] + 1;
              // 큐에 넣고 방문처리
              // 단계 + 1
						}
					}
				}
			}
			
			bw.write(len[e] + "\n");
      // 마지막 숫자의 단계 출력
		}

		bw.flush();
		bw.close();
	}

	public static int change(int num, int idx, int chn) {
    // 숫자 위치 변환 함수
		StringBuilder sb = new StringBuilder(String.valueOf(num));
    // 문자열로 변환
		sb.setCharAt(idx, (char) (chn + '0'));
    // 원하는 위치의 숫자를 변경
		return Integer.parseInt(sb.toString());
    // 다시 숫자로 변환

	}

}
