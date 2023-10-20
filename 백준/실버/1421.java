import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		int w = Integer.parseInt(str[2]);
    // n개의 나무, 자를 때 금액, 팔 때 금액
    
		int[] len = new int[n];
		int max = -1;
    // 나무 중 제일 긴 길이

		long ans = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			int next = Integer.parseInt(bf.readLine());

			len[i] = next;
			max = Math.max(max, len[i]);
		} // 나무 길이를 입력받고 동시에 제일 긴 길이 찾기

		for (int i = 1; i <= max; i++) {
      // 1~최대 길이까지 탐색
			long sum = 0;

			for (int j = 0; j < n; j++) {
        // 나무들 탐색
				int cnt = 0;

				if (len[j] >= i) { 
          // 현재 나무길이가, 탐색중인 길이보다 클 때
          
					if (len[j] % i == 0) {
            // 현재 나무 길이 / 탐색 길이의 나머지가 0이면
						cnt = len[j] / i - 1; // 1을 빼줘야 자른 횟수가 나옴
					} else
						cnt = len[j] / i; // 그외엔 그대로

					int temp = w * i * (len[j] / i) - cnt * c;
          // 이번 나무 총 비용
          // 비용 * 길이 * 나무 개수 - 자른 횟수 * 자를때 금액

					if (temp > 0)
						sum += temp;
          // 총 비용이 +일때만 계산
          // -라면 이번 나무 안팜
				}

			}

			ans = Math.max(ans, sum);
      // 더 많은 수익이라면 갱신
		}

		bw.write(ans + "\n");

		bw.flush();
		bw.close();
	}

}
