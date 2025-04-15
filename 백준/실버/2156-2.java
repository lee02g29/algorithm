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
        int glass = Integer.parseInt(str);
        int[] wine = new int[glass];
        int[] dp = new int[glass];

        for (int i = 0; i < glass; i++) {
            str = bf.readLine();

            wine[i] = Integer.parseInt(str);
        }

        dp[0] = wine[0]; // 초기 값, 1번 째 포도주를 먹는 것이 최대

        if (glass >= 2) {
            dp[1] = wine[0] + wine[1]; // 초기 값, 다 먹는게 최대
        }

        if(glass >= 3) {
            dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2]));
            // 이번 거만 먹기, 1 + 3번 째 포도주 먹기, 2 + 3번 째 포도주 먹기 중 최대 값
        }

        // 1 2 3을 구분한 이유 -> 세 번째 경우가 값에 따라 달라서
        
        for (int i = 3; i < glass; i++) {
            dp[i] = Math.max(
                    dp[i - 1], // i번 째 포도주 안먹음 -> 이전 값 가져옴
                    Math.max(dp[i - 2] + wine[i], // i번 째 포도주 먹고 i - 1번째는 안먹음
                             dp[i - 3] + wine[i - 1] + wine[i]));
                              // i번째와 i-1번째를 마시고, i-2는 안 마신 경우 -> 연속 두 잔
        }
        //
        bw.write(dp[glass - 1] + "\n");

        bw.flush();
        bw.close();
    }

}
