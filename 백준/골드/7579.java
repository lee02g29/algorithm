import java.util.*;

import javax.swing.plaf.metal.MetalTheme;

import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
    // n개의 앱, 확보해야할 m바이트

		int[] memory = new int[n];
		int[] cost = new int[n];
		int[] dp = new int[10001];
    // 앱의 각각의 메모리
    // 앱을 종료할 때 코스트
    // dp[i] = i코스트를 이용해서 만들 수 있는 최대 
    // 메모리

		str = bf.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			memory[i] = Integer.parseInt(str[i]);
		} // 각각의 메모리

		str = bf.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(str[i]);
		} // 각각 코스트
		
		for(int i = 0; i <= 10000; i++) {
			dp[i] = -1;
		} // 나올 수 없는 값으로 초기화
		
		for(int i = 0; i < n; i++) {
			int cur = cost[i];
      // i번째 앱의 코스트
			
			for(int j = 10000; j >= cur; j--) {
        // 중복으로 값을 계산하지 않기 위해
        // 뒤에서부터
				if(dp[j - cur] != -1) {
          // j코스트 - 현재 코스트
          // 이미 값이 있다면
					dp[j] = Math.max(dp[j], dp[j - cur] + memory[i]);
          // 이미 저장된 값과 (j - cur)코스트에 저장된 값 + i번째 앱의 메모리
          // 비교하여 큰 값으로 갱신
				}
			}

			dp[cur] = Math.max(dp[cur], memory[i]);
      // 이번 앱의 코스트도
      // 이미 저장된 값과 이번 앱의 메모리 값을 비교하여 갱신
		}
		

		for(int i = 0; i <= 10000; i++) {
			if(dp[i] >= m) {
				bw.write(i + "\n");
				break;
			}
		} // 앞에서부터 체크하면서
    // m 값이 넘는 경우가 있으면 출력
    // 먼저 나오는 경우가
    // 코스트가 제일 작음

		bw.flush();
		bw.close();
	}

}
