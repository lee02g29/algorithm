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

        String str = bf.readLine();
        int glass = Integer.parseInt(str); // 포도주 수
        int[] wine = new int[glass]; // 포도주 양 입력
        int[][] dp = new int[glass][3]; // dp배열
        /*  
          dp[i][0] : i번째 포도주를 마시지 않은 경우. 
          dp[i][1] : i번째 포도주를 마시는 경우이며, 이전(i-1)은 마시지 않은 상태
          dp[i][2] : i번째 포도주를 마시며, 이전(i-1)도 마셨던 상태
        */
        int max = 0; // 포도주를 최대로 먹은 양

        for(int i = 0; i < glass; i++) {
            str = bf.readLine();

            wine[i] = Integer.parseInt(str);
        } // 입력받기

        dp[0][1] = dp[0][2] = wine[0]; // 초기값

        if(glass >= 2) { 
          // 입력이 하나만 오는경우가 있음
          // 따라서 분리
            dp[1][0] = dp[0][2]; // 이 부분은 없어도 정답은 나옴
            dp[1][1] = wine[1]; // 초기라, 이 포도주만 마시는 것이 최대
            dp[1][2] = wine[0] + wine[1]; // 연속 -> 둘 다 마신거
        }

        for(int i = 2; i < glass; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            // 안마실거니까 이전 상태 중 가장 큰 값을 선택
            dp[i][1] = dp[i-1][0] + wine[i]; 
            // i번째 포도주를 마시지만, 이전(i-1)은 마시지 않은 상태이므로 이전에 마시지 않은 상태에서 전이
          
            // dp[i][1] = Math.max(dp[i-2][2] + wine[i], dp[i-1][0] + wine[i]); 이거여도 정답은 나옴
            // 근데 dp[i-2][2] > dp[i-1][0]인 케이스를 찾지 못했음

            dp[i][2] = dp[i-1][1] + wine[i];
            // i번째 포도주를 마시면서도 이전(i-1)도 마셨던 상태이므로, 이전에 연속 1잔만 마신 상태서 전이
        }

        for(int i = 0; i < glass; i++) {
            for(int j = 0; j < 3; j++) {
                max = Math.max(max,dp[i][j]);
            }
        } // 모든 값중 최대값을 출력

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }

}
