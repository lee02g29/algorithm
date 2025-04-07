import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int w;
    public static int h;
    public static int[][] map;
    public static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String[] str = bf.readLine().split(" ");

            w = Integer.parseInt(str[0]);
            h = Integer.parseInt(str[1]);

            int cnt = 0;

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visit = new int[h][w];
        

            for(int i = 0; i < h; i++) {
                str = bf.readLine().split(" ");
                Arrays.fill(visit[i], 0);
                
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1 && visit[i][j] == 0) {
                        bfs(i, j);
                        cnt++;
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
    }

    public static void bfs(int x, int y) {

        Queue<Pair> queue = new LinkedList<>();
        // bfs는 큐를 사용

        queue.offer(new Pair(x, y));
        visit[x][y] = 1;
        // 최초 좌표 큐에 넣고 방문 처리

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            // 현재 좌표 꺼내기

            for(int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                // 다음 방문할 좌표 계산
    
                if(check(nx,ny)) continue;
    
                if(visit[nx][ny] != 0) continue;
    
                if(map[nx][ny] == 0) continue;
    
                queue.offer(new Pair(nx, ny));
                visit[nx][ny] = 1;
                // 방문 가능한 좌표라면 큐에 넣고 방문 처리
            }
            
        }
    }

    public static class Pair { // 좌표용 클래스
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
}
