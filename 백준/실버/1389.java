import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bf.readLine().split(" ");

        int n = Integer.parseInt(str[0]); // 사람 수
        int m = Integer.parseInt(str[1]); // 관계 수
        
        int people = n + 1; // 케빈 베이컨의 수가 제일 작은 사람
        int nums = 99999999; // 최소 케빈 베이컨의 수를 저장

        int[][] arr = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                arr[i][j] = 99999999;
              // 적당히 큰 수로 세팅. Integer.MAX_VALUE는 오류 남
            }
        } // 플루이드 워셜 배열 세팅

        for(int i = 0; i < m; i++) {
            str = bf.readLine().split(" ");

            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);

            arr[s][e] = 1;
            arr[e][s] = 1;
          // 양방향임을 주의
        } // 관계도 입력

        for(int k = 1; k <= n; k++) { // 경유
            for(int i = 1; i <= n; i++) { // 시작
                for(int j = 1; j <= n; j++) { // 종료
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                  // 더 짧은 경로로 갱신
                }
            }
        } // 플루이드 워셜

        
        for(int i = 1; i <= n; i++) {
            int sum = 0; // 각 사람 별 케빈 베이컨 수

            for(int j = 1; j <= n; j++) {
                if(arr[i][j] == 99999999) sum += 0; 
                  // 설정된 최대값이 변하지 않음 = 못감
				        else sum += arr[i][j];
              // 그 외엔 수 더하기
            }
            if(nums > sum) { 
              // 기존 최소 베이컨의 수보다 지금 베이컨의 수가 작음
                nums = sum;
                people = i;
              // 베이컨의 수와 사람 번호 갱신
              
              // 앞에 나오는 사람이 먼저 체크되고, 
              // 베이컨의 수가 같다면 갱신되지 않으므로
              // 자동으로 작은 숫자의 사람이 저장됨
            }
        }

        bw.write(people + "\n"); // 최소 수인 사람 출력

        bw.flush();
        bw.close();
    }
}
