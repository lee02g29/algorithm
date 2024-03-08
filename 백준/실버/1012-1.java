import java.io.*;
import java.util.*;

public class Main {

    static int n, m; // 맵 크기
    static int[][] farm; // 땅

    public static int[] dx = { 0, 1, 0, -1 };
    public static int[] dy = { 1, 0, -1, 0 };
    // 4방향

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nums = Integer.parseInt(bf.readLine());
        // 테스트 수 

        while (nums-- > 0) {
            String[] str = bf.readLine().split(" ");

            int cnt = 0;
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);
          // 땅 크기, 배추 수

            farm = new int[n][m];
          // 문제에서는 가로와 세로가 반대인데
          // 이대로 해결하는 것이 편해서 이리 진행

            for(int i = 0; i < k; i++) {
                str = bf.readLine().split(" ");

                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);

                farm[x][y] = 1;
            } // 땅 초기화

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(farm[i][j] == 1) { 
                      // 배추가 있는 곳부터 탐색 시작
                        bfs(i, j); // bfs
                        cnt++; // 배추 구역 추가
                    }
                }
            } // 땅 탐색

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void bfs(int x, int y) {
      // bfs
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(x, y)); // 현재지점부터 시작
        farm[x][y] = 0;
        // 없어도 되는 부분
      
        while (!queue.isEmpty()) {
            Pair p  = queue.poll();
            int cx = p.x;
            int cy = p.y;
            // 현재 좌표 
            farm[cx][cy] = 0;
            // (없어도 되는 부분) 현재 좌표 방문 처리
          
            for(int i = 0; i < 4;i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                // 4방향 탐색
              
                if(check(nx, ny)) continue;
                // 땅 바깥 패스

                if(farm[nx][ny] == 0) continue;
                // 배추가 없는 곳 패스
              
                farm[nx][ny] = 0;
                // 현재 좌표 방문 처리
              
                queue.offer(new Pair(nx, ny));
                // 다음 방 지점으로 등록
            }
            
        }
    }

    public static boolean check(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= m;
    } // 맵 바깥 검사

    public static class Pair { // 좌표용 클래스
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }       
    }
}
