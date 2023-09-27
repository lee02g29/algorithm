import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int test = Integer.parseInt(bf.readLine());

		for (int t = 0; t < test; t++) {
			int market = Integer.parseInt(bf.readLine());
			boolean flag = true;

			int[][] coord = new int[market + 2][2];
            // 집 편의점 펜타포트
			int[][] len = new int[market + 2][market + 2];
            // i에서 j로 갈 때 최소 길이

			for (int i = 0; i < market + 2; i++) {
				for (int j = 0; j < market + 2; j++) {
					if (i == j)
						len[i][j] = 0;
                        // 자기 자신은 0으로 표시
					len[i][j] = 1_000_000_000;
                    // 적당히 큰 값을 주어 접근 할 수 없음을 표시
				}
			}

			for (int i = 0; i < market + 2; i++) {
				String[] str = bf.readLine().split(" ");

				int x = Integer.parseInt(str[0]);
				int y = Integer.parseInt(str[1]);

				coord[i][0] = x;
				coord[i][1] = y;
                // 좌표 등록
				
				for (int j = 0; j < i; j++) {
					int dis = Math.abs((coord[i][0] - coord[j][0])) + Math.abs((coord[i][1] - coord[j][1]));

					if (dis <= 1000) {

						len[i][j] = dis;
						len[j][i] = dis;
					}

				}
                // 등록과 동시에 50m * 20개 = 1000
                // 길이가 1000 이하인 것만 등록하기
			}

			for (int k = 0; k < market + 2; k++) { // 중간 지점

				for (int i = 0; i < market + 2; i++) { // 시작 지점

					if (i == k)
						continue;
                        // 같은 경우 패스

					for (int j = 0; j < market + 2; j++) { // 도착 지점

						if (j == k || j == i) // 같은 경우 패스
							continue;
						len[i][j] = Math.min(len[i][k] + len[k][j], len[i][j]);
						len[j][i] = Math.min(len[j][k] + len[k][i], len[j][i]);

                        // 정방향, 역방향 모두 길이체크. 
                        // 원래 저장된 값 vs 중간 지점을 지나가는 길이
                        // 최소값 채택
					}
				}
			}

//			for (int i = 0; i < market + 2; i++) {
//				bw.write(Arrays.toString(len[i]) + "\n");
//			}
//			bw.write("\n");

			if (len[0][market + 1] != 1_000_000_000) {
                // 시작 자점~도착지점 의 길이가 변했다면
				bw.write("happy" + "\n");
                // 도착할 수 있음
			} else {
				bw.write("sad" + "\n");
                // 아니면 도착 못함
			}
		}

		bw.flush();
		bw.close();

	}

}
