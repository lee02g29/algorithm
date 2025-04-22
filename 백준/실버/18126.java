import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Pair>> arr;
    static long[] dist;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bf.readLine();

        n = Integer.parseInt(s);
        arr = new ArrayList<>();
        dist = new long[n + 1]; // 해당 방까지의 거리
        visit = new boolean[n + 1]; // 방문 여부 배열
        // +1인 이유 : 0안쓰려고
        long max = -1;

        for(int i = 0; i <= n; i++) {
            arr.add(new ArrayList<Pair>());
        } // 이중리스트 초기화

        for(int i = 0; i < n - 1; i++) {
            String[] str = bf.readLine().split(" ");

            int a = Integer.parseInt(str[0]); // 시작점
            int b = Integer.parseInt(str[1]); // 도착점
            int c = Integer.parseInt(str[2]); // 거리

            arr.get(a).add(new Pair(b, c));
            arr.get(b).add(new Pair(a, c));
            // 양방향이므로 둘 다 리스트에 넣기
        }

        bfs(1); // 1번방부터 시작

        for(int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        } // 최장거리인 방 찾기

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }

    public static void bfs(int s) {
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(s ,0));
        dist[s] = 0;
        visit[s] = true;
        // 최초의 지점 방문 처리 및 거리 처리
        // 자신->자신의 거리는 0
        
        while (!queue.isEmpty()) {
            Pair cur = queue.poll(); // 현재 지점

            for(int i = 0; i < arr.get(cur.end).size(); i++) { 
            // 현재지점과 연결된 다음 지점 탐색
                Pair next = arr.get(cur.end).get(i); // 다음 지점

                if(!visit[next.end]) { // 다음 지점을 방문한 적이 없을 때
                    visit[next.end] = true; // 방문 처리
                    dist[next.end] = dist[cur.end] + next.dist; // 이전 거리 + 가중치
                    queue.offer(new Pair(next.end, dist[next.end]));
                    // 큐에 넣기

                } 
            }
        };

    }

    static class Pair {
        int end; // 도착점
        long dist; // 거리

        Pair(int end, long dist){
            this.end = end;
            this.dist = dist;
        }
    }
}
