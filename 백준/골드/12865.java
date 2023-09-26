import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = bf.readLine().split(" ");

		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
    // 물건 개수, 가방 최대 무게

		int[] dp = new int[k + 1];
    // 이전 & 이번 최대 가치

		for (int i = 1; i <= n; i++) {
    // 물건들 탐색
			str = bf.readLine().split(" ");

			int w = Integer.parseInt(str[0]);
			int v = Integer.parseInt(str[1]);
      // 무게, 가치
			for (int j = k; j >= 1; j--) { 
        // 뒤에서부터 변경
        // 무게 내림차순으로 탐색
				if( j < w ) { // 탐색 중인 무게 < 물건 무게
          // = 못 넣음
					dp[j] = dp[j];
          // 이전 값 그대로 받음
				} else { // 넣을 수 있음
					if(j - w < 0) dp[j] = dp[j]; 
            // 탐색 과정에서 무게의 차가 마이너스가 되면
            // 이전 값 사용
					else dp[j] = Math.max(v + dp[j - w], dp[j]);
          // 그 외에는 이번 물건을 넣거나, 넣지 않거나 
          // 둘 중 가치가 좋은 것을 선택
				}
			}
			// System.out.println(Arrays.toString(dp));
		}
		
		bw.write(dp[k] + "\n");
    // 마지막 값이 제일 최대
		
		bw.flush();
		bw.close();

	}

}
