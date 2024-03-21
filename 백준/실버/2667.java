import java.io.*;
import java.util.*;

public class Main {
    static int size; // 맵 크기
    static int[][] map; // 맵
    static int[][] visit; // 방문처리 + 단지 번호 붙이기
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    // 4방향 탐색

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(bf.readLine());

        map = new int[size][size];
        visit = new int[size][size];
        // 맵과 방문처리용 맵

        int cnt = 0;

        for (int i = 0; i < size; i++) {
            String[] str = bf.readLine().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        } // 맵 입력받기

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1 && visit[i][j] == 0) {
                  // 단지이고, 방문한적이 없을 때 
                    cnt++; // 단지 추가
                    bfs(i, j, cnt); // bfs시작
                }
            }
        }

        int[] apart = new int[cnt];
       // 단지별 집의 수 배열
      
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visit[i][j] != 0) { // 집이 아닌 곳을 제외
                    int num = visit[i][j]; // 해당 지점의 단지 번호
                    apart[num - 1]++; // 집 수 추가
                }

            }
        }

        Arrays.sort(apart); // 집 수 정렬

        bw.write(cnt + "\n"); // 단지수 출력
        for (int i = 0; i < cnt; i++) {
            bw.write(apart[i] + "\n");
        } // 오름차순으로 출력

        bw.flush();
        bw.close();
    }

    public static void bfs(int a, int b, int cnt) {
      // bfs, 시작 좌표 및 단지 번호
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(a, b));
        visit[a][b] = cnt;
        // 시작 지점 처기

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                // 다음 좌표

                if (check(nx, ny)) // 맵 바깥 처리
                    continue;

                if (visit[nx][ny] != 0) // 방문 지점 처리
                    continue;

                if (map[nx][ny] == 0) // 단지 아닌 지점 처리
                    continue;

                queue.offer(new Pair(nx, ny));
                visit[nx][ny] = cnt;
              // 다음 지점 큐에 넣기
            }
        }
    }

    public static boolean check(int x, int y) {
        return x < 0 || x >= size || y < 0 || y >= size;
    } // 맵 바깥 처리

    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    } // 좌표용 클래스
}
