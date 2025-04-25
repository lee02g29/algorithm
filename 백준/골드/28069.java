import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = bf.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        boolean[] stair = new boolean[n + 1]; // 해당 층에 갈 수 있음
        Queue<Integer> queue = new LinkedList<>();

        stair[0] = true;
        queue.offer(0);
        // 0 층에서 출발

        for (int i = 0; i < k; i++) {

            int size = queue.size(); // 이번 단계만 탐색하기 위함

            for (int j = 0; j < size; j++) {
                int cur = queue.poll();

                if (cur + 1 <= n && stair[cur + 1] != true) {
                    stair[cur + 1] = true;
                    queue.offer(cur + 1);
                }  // + 1 층

                if (cur + (cur / 2) <= n && stair[cur + (cur / 2)] != true) {
                    stair[cur + (cur / 2)] = true;
                    queue.offer(cur + (cur / 2));
                } // 순간이동
            }
        }

        if (stair[n] == true) { // n층에 간다면 
            bw.write("minigimbob" + "\n");
        } else { // 갈 수 없으면
            bw.write("water" + "\n");
        }

        bw.flush();
        bw.close();
    }

}
