import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(bf.readLine()); // 숫자 개수
        int[] nums = new int[cnt + 1]; // 숫자 목록
        int[] dp = new int[cnt + 1]; // 현재 숫자까지 최대합
        int max = Integer.MIN_VALUE; // 최대합 구하는 변수

        String[] str = bf.readLine().split(" ");

        for(int i = 0; i < cnt; i++) {
            nums[i + 1] = Integer.parseInt(str[i]);
        } // 숫자 입력받기, 이전 값과 비교를 위해 0번째 인덱스를 비웠음

        for(int i = 1; i <= cnt; i++) {
            if(dp[i-1] + nums[i] >= nums[i]) {
                dp[i] = dp[i-1] + nums[i];
            } // 이전 숫자까지의 합 + 현재 숫자를 비교
              // 지금 숫자보다 합이 더 크면 갱신
            else dp[i] = nums[i];
            // 합이 더 크지 않으면 현재 숫자를 사용
        }

        for(int i = 1; i <= cnt; i++) {
            if(max < dp[i]) max = dp[i];
        } // 최대 합 찾기

        bw.write(max + "\n");
        // 답 출력

        bw.flush();
        bw.close();
    }
}
