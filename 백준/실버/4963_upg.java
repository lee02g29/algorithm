import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    // 8방향
    public static int w;
    public static int h;
    public static int[][] map;
    public static int[][] visit;
    // 너비 높이 맵 방문 여부

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String[] str = bf.readLine().split(" ");

            w = Integer.parseInt(str[0]);
            h = Integer.parseInt(str[1]);
            // 너비와 높이

            int cnt = 0;

            if(w == 0 && h == 0) break;
            // 입력 끝이 오면 종료

            map = new int[h][w];
            visit = new int[h][w];
        

            for(int i = 0; i < h; i++) {
                str = bf.readLine().split(" ");
                Arrays.fill(visit[i], 0);
                
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            } // 맵과 방문 여부 배열 초기화

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && visit[i][j] == 0) {
                      // 땅이고, 방문한 적 없으면 탐색
                        dfs(i, j);
                        cnt++; // 섬 개수 증가
                    }
                }
            }

            bw.write(cnt + "\n");
        }



        bw.flush();
        bw.close();
    }

    public static boolean check(int x, int y) {
        if( x < 0 || y < 0 || x >= h || y >= w ) {
            return true;
        } else return false;
    } // 맵 바깥 여부

    public static void dfs(int x, int y) {
        visit[x][y] = 1; // 방문 처리

        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 다음 지점

            if(check(nx,ny)) continue; // 맵 바깥

            if(visit[nx][ny] != 0) continue; // 방문한 적 있음

            if(map[nx][ny] == 0) continue; // 땅이 아님

            visit[nx][ny] = 1; // 다음 지점 방문 처리

            dfs(nx, ny);
        }
    }
}
