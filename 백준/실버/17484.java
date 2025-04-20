import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bf.readLine().split(" ");
        int h = Integer.parseInt(str[0]); // 높이
        int w = Integer.parseInt(str[1]); // 너비

        int[][] univ = new int[h][w]; // 우주 공간에서 연료 소모량
        int[][][] dp = new int[h][w][3]; // 현재 칸까지 최소 연료 소모량
        int[] dir = {-1, 0, 1}; // 방향 편하게 하려던 시도, 현재 코드에선 사용 x
        int ans = Integer.MAX_VALUE; // min을 쓰기 때문에 큰 값으로

        for (int i = 0; i < h; i++) {
            str = bf.readLine().split(" ");

            for (int j = 0; j < w; j++) {
                univ[i][j] = Integer.parseInt(str[j]);
            }
        } // 입력받기

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = univ[0][i];
            }
        } // 첫 줄은 시작점이므로 첫 줄 연료값으로 초기화

        for (int i = 1; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 왼쪽 위에서 온 경우
                if (j - 1 >= 0) 
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + univ[i][j];
                    // 왼쪽 위 지점에서, 위쪽, 오른쪽에서 온 경우 중 짧은 거 체크
                else // 맵 바깥
                    dp[i][j][0] = Integer.MAX_VALUE; // 접근 불가 매직 넘버

                // 위에서 온 경우
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + univ[i][j];
                // 위쪽 지점에서, 왼쪽, 오른쪽에서 온 경우 중 짧은 거 체크

                // 오른쪽 위에서 온 경우
                if (j + 1 < w)
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + univ[i][j];
                    // 오른쪽 위 지점에서, 왼쪽, 위쪽에서 온 경우 중 짧은 거 체크
                else // 맵 바깥
                    dp[i][j][2] = Integer.MAX_VALUE; // 접근 불가 매직 넘버
            }
        }
        

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(dp[h - 1][i][j], ans);
            }
        } // 마지막 줄에서 최소값 출력

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }

}
