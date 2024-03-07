import java.io.*;
import java.util.*;

public class Main {

    static int n, m; // 맵 크기
    static int[][] arr; // 맵
    static int[][] route; // 거리 맵

    public static int[] dx = { 0, 1, 0, -1 };
    public static int[] dy = { 1, 0, -1, 0 };
    // bfs용 4방향

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bf.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
       // 맵 크기

        arr = new int[n][m];
        route = new int[n][m];
        // 맵 최초 세팅

        int s1 = 0;
        int s2 = 0;
        // 목표 지점
        
        for (int i = 0; i < n; i++) {
            str = bf.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
               // 맵 입력받기

                if(arr[i][j] == 0) {
                    route[i][j] = 0;
                  // 원래 0인 곳은 0으로 초기화
                } else {
                    route[i][j] = -1; // 거리 맵을 -1으로 초기화

                    if(arr[i][j] == 2) {
                        s1 = i;
                        s2 = j;
                    } // 목표 지점 찾기
                }                
            }
        }

        find(s1, s2); // bfs 시작, 목표지점부터 탐색하기

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(route[i][j] + " ");
            }
            System.out.println();
        } // 맵 출력

        bw.flush();
        bw.close();
    }

    public static void find(int x, int y) {
      // bfs 
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(x, y));
        route[x][y] = 0;
        // 탐색 시작 지점 초기화

        while (!queue.isEmpty()) {
          // bfs
            Pair p = queue.poll();

            int cx = p.x;
            int cy = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 4방향

                if (check(nx, ny)) // 맵 바깥 체크
                    continue;

                if (arr[nx][ny] == 0 || route[nx][ny] >= 0) 
                  // 갈 수 없는 곳이나, 이미 방문한 곳 패스
                    continue;
                
                route[nx][ny] = route[cx][cy] + 1;
                // 거리는 이전 지점 + 1

                queue.offer(new Pair(nx, ny));
                // 지점 추가
            }
        }

    }

    public static boolean check(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    } // 맵 바깥 체크

    public static class Pair { // 좌표용 클래스
        int x;
        int y;

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

    }
}
