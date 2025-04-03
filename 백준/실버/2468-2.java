import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static int[][] land;
    static int[][] visit;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = bf.readLine();

        n = Integer.parseInt(str);
        land = new int[n][n];
        visit = new int[n][n];
        int max = Integer.MIN_VALUE;
        int cnt = 1;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                land[i][j] = Integer.parseInt(line[j]);
                if (max < land[i][j])
                    max = land[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], 0);
        }

        for (int i = 0; i <= max; i++) {

            cnt = 0;
            for (int a = 0; a < n; a++) {
                Arrays.fill(visit[a], 0);
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (land[j][k] > i && visit[j][k] == 0) {
                        bfs(j, k, i);
                        cnt++;
                    }
                }
            }

            answer = Math.max(answer, cnt);
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
    }

    public static void bfs(int x, int y, int h) {

        Queue<Pair> queue = new LinkedList<>();
       // bfs는 큐를 이용

        queue.offer(new Pair(x, y));
        visit[x][y] = 1;
       // 함수로 받은 좌표 방문 처리 및 큐에 넣기

        while (!queue.isEmpty()) { // 큐가 빌 때까지,
            Pair cur = queue.poll();

            for (int l = 0; l < 4; l++) {
                int nx = cur.x + dx[l];
                int ny = cur.y + dy[l];
              // 큐에서 꺼낸 지점을 기준으로 탐색

                if (check(nx, ny)) {
                    continue;
                }

                if (visit[nx][ny] != 0 || land[nx][ny] <= h) {
                    continue;
                }

                queue.offer(new Pair(nx, ny));
              // 모든 조건을 클리어 한 좌표는 큐에 넣기
                visit[nx][ny] = 1;
              // 방문 처리
            }
        }
    }

    public static class Pair {
      // 2차 배열 좌표용 클래스
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
