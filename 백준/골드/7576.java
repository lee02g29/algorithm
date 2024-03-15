import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;   
    static Queue<Pair> queue;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    // bfs용 4방향
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bf.readLine().split(" ");

        m = Integer.parseInt(str[0]); // 가로
        n = Integer.parseInt(str[1]); // 세로
        int max = Integer.MIN_VALUE; // 최대 일수 + 1을 저장
        boolean isPossible = true; // 모든 토마토가 익을 수 있는지 여부

        arr = new int[n][m]; // 토마토 상자
        queue = new LinkedList<>(); // bfs용 큐

        for(int i = 0; i < n; i++) {
            str = bf.readLine().split(" ");

            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        } // 상자 입력받기

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    queue.offer(new Pair(i, j));
                }
            }
        } // 1인 지점, 즉 토마토가 있는 지점 큐에 넣기

        bfs(); // bfs

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) isPossible = false;
              // 한 칸이라도 익지 않은 칸이 있음 = 모두 익는 것이 불가
                if(max < arr[i][j]) max = arr[i][j];
              // bfs를 진행한 후, 최대값을 구하기
            }
        } //

        if(!isPossible) { // 모두 익는 것이 불가
            bw.write(-1 + "\n"); // -1 출력
        }
        else bw.write((max - 1) + "\n"); // 그 외에는 최대값 -1
        // 이유 : bfs 시작이 1일이고, 끝나는 것이 max일
        // 따라서 걸리는 시간 : max - 1일

        bw.flush();
        bw.close();
    }

    public static void bfs() {

        while(!queue.isEmpty()) { // bfs
            Pair cur = queue.poll();
            // System.out.println(cur.x + " " + cur.y + " " + arr[cur.x][cur.y]);
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
              // 4방향

                if(check(nx, ny)) continue; // 맵 바깥 x

                if(arr[nx][ny] != 0) continue; // 빈 공간이 아니면 x

                arr[nx][ny] = arr[cur.x][cur.y] + 1; 
                // 해당 칸의 토마토가 익는 날짜는 이전 칸의 + 1
                queue.offer(new Pair(nx, ny)); // 다음 탐색
            }
        }
    }

    public static boolean check(int x, int y) { // 맵 바깥 체크
        return x < 0 || x >= n || y < 0 || y >= m;
    }

    public static class Pair { // 좌표용 클래스
        int x;
        int y;

        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
}
