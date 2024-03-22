import java.io.*;
import java.util.*;
/*
자세한 주석은 bfs 코드를 참고
*/
public class Main {
    static int size;
    static int[][] map;
    static int[][] visit;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
  
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(bf.readLine());

        map = new int[size][size];
        visit = new int[size][size];

        int cnt = 0;

        for (int i = 0; i < size; i++) {
            String[] str = bf.readLine().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1 && visit[i][j] == 0) {
                  // 방문한 적이 없는 새로운 단지일 때 dfs
                    cnt++;
                    dfs(i, j, cnt);
                }
            }
        }

        int[] apart = new int[cnt];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (visit[i][j] != 0) {
                    int num = visit[i][j];
                    apart[num - 1]++;
                  // 단지별로 숫자를 붙였으므로,
                  // 숫자별로 집의 수를 세기
                }
            }
        }

        Arrays.sort(apart); // 오름차순 정렬

        bw.write(cnt + "\n"); // 단지수
        for (int i = 0; i < cnt; i++) {
            bw.write(apart[i] + "\n");
        } // 집의 수 오름차순

        bw.flush();
        bw.close();
    }

    public static void dfs(int a, int b, int cnt) {
      // dfs - 재귀 방식
        visit[a][b] = cnt;

        for (int i = 0; i < 4; i++) {
            int nx = a + dx[i];
            int ny = b + dy[i];

            if (check(nx, ny))
                continue;

            if (visit[nx][ny] != 0)
                continue;

            if (map[nx][ny] == 0)
                continue;

            dfs(nx, ny, cnt);
          // dfs를 재귀로 호출함
        }
    }

    public static boolean check(int x, int y) {
        return x < 0 || x >= size || y < 0 || y >= size;
    }

    public static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
