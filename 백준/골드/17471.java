import java.io.*;
import java.util.*;

public class Main {
    static int nums;
    static int[] area;
    static int[] com;
    static ArrayList<ArrayList<Integer>> arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        nums = Integer.parseInt(bf.readLine()); // 구역 개수

        area = new int[nums]; // 구역별 인구
        com = new int[nums]; // 조합 저장(이번 지역구 구분)
        arr = new ArrayList<>(); // 구역 인접 그래프

        String[] str = bf.readLine().split(" ");

        for(int i = 0; i < nums; i++) {
            arr.add(new ArrayList<>());
        } // 이중 arraylist 만들기

        for(int i = 0; i < area.length; i++) {
            area[i] = Integer.parseInt(str[i]);
        } // 인구수 저장하기

        for(int i = 0; i < nums; i++) {
            str = bf.readLine().split(" ");

            int cnt = Integer.parseInt(str[0]);

            for(int j = 1; j <= cnt; j++) {
                arr.get(i).add(Integer.parseInt(str[j]) - 1);
            }
        } // 인접 그래프 만들기

        combi(0);

        if(min == Integer.MAX_VALUE) {
            bw.write(-1 + "\n");
        } // 나눌 수 없을 때 
        else bw.write(min + "\n");
        // 그 외에

        bw.flush();
        bw.close();

    }

    public static void combi(int n) {
        if(n == nums) {
            check(com);
            return;
        } // 조합 완성시 -> 그 조합으로 구역을 나누고 
      // 조건에 맞는지 그리고 인구차가 얼만지 확인하기 

        for(int i = 0; i<= 1; i++) {
            com[n] = i;
            combi(n + 1);
        }
    }

    public static void check(int[] areas) { // bfs를 진행함
        Queue<Integer> queue = new LinkedList<>(); // bfs용 큐
        boolean[] visit = new boolean[nums]; // 방문 처리

        int sum1 = 0; 
        int sum2 = 0;
        // 조합 0/1에 따라 합을 저장
      
        queue.add(0);
        visit[0] = true;
        int start = areas[0];
        sum1 += area[0];
      // 최초 bfs 세팅 0번째부터 시작하기

        while(!queue.isEmpty()) {
            int peek = queue.poll();

            for(int i = 0; i < arr.get(peek).size(); i++) {
                int cur = arr.get(peek).get(i);
              // 다음 구역
                if(start == areas[cur] && !visit[cur]) { 
                  // 해당 구역이 0번째 구역과 같은 선거구이고, 방문한적이 없다면 
                    // System.out.println("p1: " + peek + " " + cur);
                    queue.add(cur);
                    visit[cur] = true;
                    sum1 += area[cur];
                  // 큐에 넣고 방문 처리
                }
            }
        }

        //////

        for(int i = 0; i < nums; i++) {

            if(!visit[i] && start != areas[i]) {
                queue.add(i);
                visit[i] = true;
                sum2 += area[i];
                start = areas[i];
                break;
            }
        } // 남은 구역 중, 0번째 구역과 같은 선거구가 아닌 곳 찾기

        while(!queue.isEmpty()) {
            int peek = queue.poll();

            for(int i = 0; i < arr.get(peek).size(); i++) {
                int cur = arr.get(peek).get(i);

                if(start == areas[cur] && !visit[cur]) {
                    queue.add(cur);
                    visit[cur] = true;
                    sum2 += area[cur];
                }
            }
        } // bfs

        for(int i = 0; i < nums; i++) {
            if(visit[i] == false) return;
        } // 방문하지 않은 곳이 있음 = 나눌 수 없음

        if(min > Math.abs(sum1 - sum2)) {
            min = Math.abs(sum1 - sum2);
        } // 최소값 갱신

        // System.out.println(Arrays.toString(areas));
        // System.out.println(Arrays.toString(visit));
        // System.out.println(sum1 + " - " + sum2 + " = " + min);
    }
}
