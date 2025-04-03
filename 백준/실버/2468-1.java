import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static int n;
    static int[][] land;
    static int[][] dfs;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    // 4방향

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = bf.readLine();

        n = Integer.parseInt(str); // 지역의 크기
        land = new int[n][n]; // 지역 높이 정보
        dfs = new int[n][n]; // 방문 정보
        int max = Integer.MIN_VALUE; 
        // 지역의 최대 높이 -> 그냥 연산 덜하고 싶었음
        int cnt = 0; 
        // 잠기지 않는 지역 수. 
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                land[i][j] = Integer.parseInt(line[j]);
                if (max < land[i][j])
                    max = land[i][j];
            }
        } // 지역 높이 정보

        for (int i = 0; i < n; i++) {
            Arrays.fill(dfs[i], 0);
        } // 방문 정보 초기화

        for (int i = 0; i <= max; i++) { 
          // '아무 지역도 물에 잠기지 않을 수도 있다.'에 따라 수위가 0일 수도 있음
    
            cnt = 0; // 비의 수위? 마다 지역수 초기화
          
            for (int a = 0; a < n; a++) {
                Arrays.fill(dfs[a], 0);
            } // 방문기록 초기화

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (land[j][k] > i && dfs[j][k] == 0) {
                      // 수위보다 높고, 방문한적 없는 지점
                        dfs(j, k, i);
                      // dfs와 현재 수위를 전달
                        cnt++;
                      // 지역 수 증가
                    }
                }
            }

            answer = Math.max(answer, cnt);
           // 수위마다 잠기지 않는 지역 수가 다르므로, 계속 체크
        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
    }

    public static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return true;
        } else
            return false;
    } // 맵 바깥 체크 함수

    public static void dfs(int x, int y, int h) {

        dfs[x][y] = 1; // 방문 처리

        for (int l = 0; l < 4; l++) {
            int nx = x + dx[l];
            int ny = y + dy[l];
          // 4방향 방문 

            if (check(nx, ny)) {
                continue;
            } // 맵 바깥 

            if (dfs[nx][ny] != 0 || land[nx][ny] <= h) {
                continue;
            } // 방문한 적이 있거나, 수위보다 낮은 지역이거나

            dfs(nx, ny, h);
            // 다음 지점 방문
        }
    }
}
