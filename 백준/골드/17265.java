import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int n;
    static String[][] path;
    static int[] dx = { 1, 0 };
    static int[] dy = { 0, 1 };
    // 방향은 두 개, 아래와 오른쪽
    static int min;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();

        n = Integer.parseInt(s);
        path = new String[n][n];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] str = bf.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                path[i][j] = str[j];
            }
        }

        dfs(0, 0, Integer.parseInt(path[0][0]), null);
        // 시작점. 시작점의 값을 보냄

        bw.write(max + " " + min + "\n");

        bw.flush();
        bw.close();
    }

    public static boolean check(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    public static void dfs(int x, int y, int res, String next) {
        if (x == n - 1 && y == n - 1) {
            min = Math.min(min, res);
            max = Math.max(max, res);
        } // 맨 마지막 위치에 왔다면 값을 갱신

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 다음 위치

            if (check(nx, ny)) {
                continue;
            } // 맵 바깥

            if ((nx + ny) % 2 == 1) { // 짝수번째(인덱스가 0부터이므로 홀수 일때)
                dfs(nx, ny, res, path[nx][ny]);
                // 별도의 연산 x, 연산자만 넘김
            } else {
                int current = res; // 지금까지 계산 결과
                int value = Integer.parseInt(path[nx][ny]); // 이번 숫자
                switch (next) { // 연산자에 따라 계산
                    case "*":
                        current = current * value;
                        break;
                    case "+":
                        current = current + value;
                        break;
                    case "-":
                        current = current - value;
                        break;
                    default:
                        break;
                }
                dfs(nx, ny, current, null);
                // 계산 결과를 넘기고 연산자는 비움
            }

        }

    }
}
